ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .settings(
    name := "expl-scala3",
    idePackagePrefix := Some("com.us.dsb.scala3")
  )

scalacOptions ++= Seq(
  "-explain",
  "-feature"
)
