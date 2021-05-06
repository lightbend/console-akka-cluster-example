package com.lightbend.example.com.lightbend.rp.example.akkacluster

import akka.actor._
import akka.cluster._
import akka.cluster.ClusterEvent._

object SimpleClusterListener {
  case object GetMembers
  case class MemberList(members: List[String])
}

class SimpleClusterListener extends Actor with ActorLogging {
  import SimpleClusterListener._

  val cluster = Cluster(context.system)

  private var members = List.empty[String]

  override def preStart(): Unit = {
    cluster.subscribe(
      self,
      initialStateMode = InitialStateAsEvents,
      classOf[MemberEvent],
      classOf[UnreachableMember])
  }

  override def postStop(): Unit = {
    cluster.unsubscribe(self)
  }

  override def receive: Receive = {
    case GetMembers =>
      sender() ! MemberList(members)

    case MemberUp(member) =>
      log.info(s"Member is Up: ${member.address}")
      members = member.address.toString :: members

    case UnreachableMember(member) =>
      log.info(s"Member detected as unreachable: ${member}")

    case MemberRemoved(member, previousStatus) =>
      log.info(s"Member is Removed: ${member.address} after ${previousStatus}")
      members = members.filterNot(_ == member.address.toString)

    case event: MemberEvent =>
      log.info(s"New event for Cluster: ${event}")
  }
}