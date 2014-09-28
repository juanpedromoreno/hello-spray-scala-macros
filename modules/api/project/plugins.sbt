
resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")