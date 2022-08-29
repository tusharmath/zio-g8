object Dependencies {
  import sbt._
  val zioVersion = "2.0.0"
  val zioSchemaVersion = "0.2.1"

  val ZIOCore = "dev.zio" %% "zio" % zioVersion
  val ZIOTest = "dev.zio" %% "zio-test" % zioVersion % Test
  val ZIOTestSbt = "dev.zio" %% "zio-test-sbt" % zioVersion % Test
}
