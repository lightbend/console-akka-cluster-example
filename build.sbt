name := "akka-cluster-example"

version := "0.1.0"

enablePlugins(JavaAppPackaging)
dockerExposedPorts ++= Seq(8080, 2552)

libraryDependencies ++= Vector(
  "com.typesafe.akka" %% "akka-actor"   % "2.5.23",
  "com.typesafe.akka" %% "akka-cluster" % "2.5.23",
  "com.typesafe.akka" %% "akka-http"    % "10.1.3",
  "com.typesafe.akka" %% "akka-stream"  % "2.5.23",
  "com.lightbend.akka.discovery" %% "akka-discovery-kubernetes-api" % "1.0.2")

mainClass in Compile := Some("com.lightbend.example.com.lightbend.rp.example.akkacluster.App")
