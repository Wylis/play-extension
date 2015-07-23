import sbt._
import Keys._

object BuildSettings {
  val buildScalaVersion = "2.11.7"
  val buildOrganization = "org.wylis"
  val buildName = "play-extension"
  val buildVersion = "1.0-SNAPSHOT"

  val scalazVersion = "7.1.+"
  val scalatestVersion = "2.2.+"

  libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.+"

  val buildSettings =  Seq (
    name := buildName,
    organization := buildOrganization,
    scalaVersion := buildScalaVersion,
    version := buildVersion,

    resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
    publishSetting
  )

  lazy val publishSetting = publishTo <<= version.apply{
    v =>
      val nexus = "http://wylis.org:8081/nexus"
      if (v.trim.endsWith("SNAPSHOT"))
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "content/repositories/releases")
  }
}

object Dependencies {
  import BuildSettings._

  lazy val scalaz = "org.scalaz" %% "scalaz-core" % scalazVersion
  lazy val play = "com.typesafe.play" %% "play" % "2.4.2"
}

trait CommonBuild {
  import Dependencies._
  def commonProject(name: String, baseFile: java.io.File) =
    Project(id = name, base = baseFile, settings = BuildSettings.buildSettings).settings(
      libraryDependencies += scalaz,
      libraryDependencies += play
    )
}

object PlayExtensionBuild extends Build with CommonBuild {
  lazy val root = commonProject("play-extension", file("."))
}