
 lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)
  .settings(
    name := """play-java-starter-example""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.6",
    libraryDependencies ++= Seq(
      guice, evolutions, javaJdbc,
      // Test Database
      //"com.h2database" % "h2" % "1.4.199",
      // Testing libraries for dealing with CompletionStage...
      "org.assertj" % "assertj-core" % "3.14.0" % Test,
      "org.awaitility" % "awaitility" % "4.0.1" % Test,
    ),
    javacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-parameters",
      "-Xlint:unchecked",
      "-Xlint:deprecation",
      "-Werror"
    ),
    // Make verbose tests
    testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
  )

libraryDependencies += "io.ebean" % "ebean" % "11.45.1"
 libraryDependencies ++= Seq(
   "mysql" % "mysql-connector-java" % "8.0.25"
 )
 libraryDependencies += javaJdbc % Test
playEbeanModels in Compile := Seq("models.*")


//#play-ebean-debug
playEbeanDebugLevel := 4
//#play-ebean-debug

//#play-ebean-agent-args
playEbeanAgentArgs += ("detect" -> "false")
//#play-ebean-agent-args

//#play-ebean-test
inConfig(Test)(PlayEbean.scopedSettings)

playEbeanModels in Test := Seq("models.*")
//#play-ebean-test