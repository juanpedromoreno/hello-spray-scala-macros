scalaVersion := "2.11.2"

name := "macros"

version := "1.0"

publishArtifact in(Test, packageSrc) := true

val paradiseVersion = "2.0.1"

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.11.2"
)

conflictWarning in ThisBuild := ConflictWarning.disable

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

javaOptions in Test ++= Seq("-XX:MaxPermSize=128m", "-Xms512m", "-Xmx512m")

sbt.Keys.fork in Test := false

addCompilerPlugin("org.scalamacros" % "paradise" % paradiseVersion cross CrossVersion.full)