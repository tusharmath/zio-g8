// give the user a nice default project!
ThisBuild / organization := "com.tusharmath"
ThisBuild / scalaVersion := "3.1.1"
Global / scalacOptions := Seq(
  "-Ywarn-unused",
  "-Werror",
  "-feature",
  "-language:reflectiveCalls"
)

lazy val root = (project in file(".")).settings(
  name := "$name$"
)
