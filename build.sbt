name := """play-heroku-seed"""

version := "1.0-SNAPSHOT"

lazy val root: Project = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

resolvers += "johnreed2 bintray" at "http://dl.bintray.com/content/johnreed2/maven"

libraryDependencies += "com.github.johnreedlol" %% "scala-trace-debug" % "3.0.3"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "com.typesafe.play" %% "play-slick" % "0.8.0",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc4"
)
