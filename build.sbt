scalaVersion := "2.11.2"

name := "hello-play-macros"

version := "1.0"

lazy val root = (project in file(".")).aggregate(macros, api)

lazy val macros = project.in(file("modules/macros"))

lazy val api = project.in(file("modules/api")).dependsOn(macros)