import Dependencies._

ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := ".io.github.waleedsamy"

lazy val root = (project in file("."))
  .settings(
    name := "kafka-on-the-shore",
    libraryDependencies ++= Seq(
      kafkaClients,
      scalaTest % Test
    )
  )