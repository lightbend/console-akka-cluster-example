// Docker packaging
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.22")

// Cinnamon
addSbtPlugin("com.lightbend.cinnamon" % "sbt-cinnamon" % "2.11.3")
credentials += Credentials(Path.userHome / ".lightbend" / "commercial.credentials")
resolvers += Resolver.url("lightbend-commercial", url("https://repo.lightbend.com/commercial-releases"))(
  Resolver.ivyStylePatterns
)