ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "expl-scala3",
    idePackagePrefix := Some("com.us.dsb.scala3")
  )
