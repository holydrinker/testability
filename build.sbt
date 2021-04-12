name := "testability"

version := "0.1"

scalaVersion := "2.12.11"

val dependencies = new Dependencies(new Versions())

libraryDependencies ++= Seq(
  dependencies.typesafeConfig,
  dependencies.postgres,
  dependencies.scalaTest,
  "org.scalactic" %% "scalactic" % "3.2.5"
)
