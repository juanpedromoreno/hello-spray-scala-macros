scalaVersion := "2.11.2"

name := "api"

version := "1.0"

publishMavenStyle := false

publishArtifact in(Test, packageSrc) := true

val paradiseVersion = "2.0.1"

libraryDependencies ++= {
  val akkaV = "2.3.5"
  val sprayV = "1.3.1"
  Seq(
    "io.spray"            %%   "spray-can"     % sprayV,
    "io.spray"            %%   "spray-routing" % sprayV,
    "io.spray"            %%   "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"     % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"   % akkaV   % "test",
    "org.specs2"          %%  "specs2"         % "2.4.1" % "test",
    "org.scala-lang"      % "scala-reflect"    % "2.11.2"
  )
}

conflictWarning in ThisBuild := ConflictWarning.disable

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

javaOptions in Test ++= Seq("-XX:MaxPermSize=128m", "-Xms512m", "-Xmx512m")

sbt.Keys.fork in Test := false

addCompilerPlugin("org.scalamacros" % "paradise" % paradiseVersion cross CrossVersion.full)