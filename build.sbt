lazy val commonSettings = Seq(
  version := "1.0.0",
  scalaVersion := "2.11.8",
  libraryDependencies ++= testDependencies,
  testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a")),
  crossPaths := false
)

lazy val testDependencies = Seq(
  "junit" % "junit" % "4.12" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test,
  "org.scalatest" % "scalatest_2.11" % "3.0.0" % Test
)

def initProject(project: Project) : Project = project
  .configure(initSourceDirs)
  .settings(name := project.base.getAbsoluteFile.name)
  .settings(commonSettings: _*)

def initSourceDirs(project: Project) : Project = {
  val sourceMainDirs = Seq(
    "src/main/java",
    "src/main/scala",
    "src/main/resources"
  )
  val sourceTestDirs = Seq(
    "src/test/java",
    "src/test/scala",
    "src/test/resources"
  )
  (sourceMainDirs ++ sourceTestDirs).map(new File(project.base.getAbsoluteFile, _)).foreach(_.mkdirs)
  project
}

lazy val core = (project in file("app-core"))
  .configure(initProject)
  .settings(
	libraryDependencies ++= Seq(
	  "org.springframework" % "spring-core" % "4.3.2.RELEASE",
	  "org.apache.commons" % "commons-lang3" % "3.4",
	  "org.slf4j" % "slf4j-api" % "1.7.21",
	  "ch.qos.logback" % "logback-classic" % "1.1.7" % Runtime
	)
  )
  
lazy val module = (project in file("app-module"))
  .configure(initProject)
  .settings(
  )
  .dependsOn(core)
