import sbt._

object Dependencies {
  lazy val kafkaClients = "org.apache.kafka" % "kafka-clients" % "3.2.0"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.11"
}
