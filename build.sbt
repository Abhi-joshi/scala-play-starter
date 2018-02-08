name := """scala-play-starter"""
organization := "com.abhishek"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
    "com.typesafe.play" %% "play-slick" % "3.0.1",
    "com.typesafe.play" %% "play-slick-evolutions" % "3.0.1",
    "com.typesafe.play" %% "play-json" % "2.6.8",
    "com.h2database" % "h2" % "1.4.196",
    "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % "test",
    "org.postgresql" % "postgresql" % "42.2.1",
    "javax.xml.bind" % "jaxb-api" % "2.3.0",
    guice
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.abhishek.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.abhishek.binders._"
