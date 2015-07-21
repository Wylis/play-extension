name := "play-extensions"

organization := "org.wylis"

scalaVersion := "2.11.7"

version := "0.0.1"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.+"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)
