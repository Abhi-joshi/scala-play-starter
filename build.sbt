name := """scala-play-starter"""
organization := "com.abhishek"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "javax.xml.bind" % "jaxb-api" % "2.3.0"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.abhishek.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.abhishek.binders._"
