import sbt._

class Dependencies(versions: Versions) {

  val typesafeConfig = "com.typesafe" % "config" % versions.typesafeConfig

  val postgres = "org.postgresql" % "postgresql" % versions.postgres

  val scalaTest = "org.scalatest" %% "scalatest" % versions.scalaTest % Test

}
