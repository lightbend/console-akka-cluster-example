ThisBuild / scalaVersion := "2.13.5"
ThisBuild / version := "0.1.0"
ThisBuild / scalacOptions ++= Seq(
  "-target:8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlog-reflective-calls",
  "-Xlint"
)

name := "akka-cluster-example"

val AkkaVersion = "2.6.14"
val AkkaHttpVersion = "10.2.4"

libraryDependencies ++= Seq(
  // Akka HTTP dependencies
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
  // Akka Dependencies
  "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor"   % AkkaVersion,
  "com.typesafe.akka" %% "akka-cluster" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream"  % AkkaVersion,
  "com.typesafe.akka" %% "akka-discovery" % AkkaVersion,
  // Logback
  "ch.qos.logback" % "logback-classic" % "1.2.3",

)

Compile / mainClass := Some("com.lightbend.example.com.lightbend.rp.example.akkacluster.App")
