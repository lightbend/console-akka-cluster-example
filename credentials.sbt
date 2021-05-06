ThisBuild / resolvers ++= sys.env.get("LIGHTBEND_COMMERCIAL_MVN").map { url =>
  "lightbend-commercial-mvn" at url
}