// give the user a nice default project!
ThisBuild / organization := "com.tusharmath"
ThisBuild / scalaVersion := "3.1.1"
ThisBuild / semanticdbEnabled := true
ThisBuild / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / scalacOptions := Seq(
  "-Ywarn-unused",
  "-Werror",
  "-feature",
  "-language:reflectiveCalls"
)

ThisBuild / versionScheme         := Some("early-semver")
ThisBuild / githubWorkflowTargetTags ++= Seq("v*")
ThisBuild / githubWorkflowPublishTargetBranches += RefPredicate.StartsWith(Ref.Tag("v"))
ThisBuild / githubWorkflowPublish := Seq(WorkflowStep.Sbt(List("ci-release")))
ThisBuild / githubWorkflowPublish := Seq(
  WorkflowStep.Sbt(
    List("ci-release"),
    env = Map(
      "PGP_PASSPHRASE"    -> "\${{ secrets.PGP_PASSPHRASE }}",
      "PGP_SECRET"        -> "\${{ secrets.PGP_SECRET }}",
      "SONATYPE_PASSWORD" -> "\${{ secrets.SONATYPE_PASSWORD }}",
      "SONATYPE_USERNAME" -> "\${{ secrets.SONATYPE_USERNAME }}",
    ),
  ),
)

inThisBuild(
  List(
    organization := "com.tusharmath",
    homepage     := Some(url("https://github.com/tusharmath/$name;format="camel"$")),
    licenses     := List("MIT" -> url("https://github.com/tusharmath/$name;format="camel"$/blob/main/LICENSE")),
    developers   := List(
      Developer(
        "tusharmath",
        "Tushar Mathur",
        "tusharmath@gmail.com",
        url("https://tusharmath.com"),
      ),
    ),
  ),
)




lazy val root = (project in file(".")).settings(
  name := "$name;format="camel"$",
     libraryDependencies := Seq(
      Dependencies.ZIOCore,
      Dependencies.ZIOTest,
      Dependencies.ZIOTestSbt,
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
)

Global / scalacOptions := Seq(
  "-Ywarn-unused",
  "-Werror",
  "-feature",
)


