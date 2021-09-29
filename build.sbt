val scala213 = "2.13.6"
val scala3 = "3.0.2"
val scala31 = "3.1.0-RC2"

lazy val supportedScalaVersions = List(scala213, scala3, scala31)


ThisBuild / scalaVersion     := scala3
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "bad-type-operand-stack-reproducer",
    crossScalaVersions := supportedScalaVersions

  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
