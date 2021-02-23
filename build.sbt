name := "twitter-kstreams"

version := "0.1"

scalaVersion := "2.13.4"

mainClass in Compile := Some("com.sambeth.twitter.streams.TwitterProducer")

dockerBaseImage := "openjdk:8-jre-alpine"
maintainer := "Samuel Baafi Bokaye <sambethslim@gmail.com>"
dockerEnvVars := Map(
  "TWITTER_CONSUMER_TOKEN_KEY" -> sys.env.getOrElse("TWITTER_CONSUMER_TOKEN_KEY", "default"),
  "TWITTER_CONSUMER_TOKEN_SECRET" -> sys.env.getOrElse("TWITTER_CONSUMER_TOKEN_SECRET", "default"),
  "TWITTER_ACCESS_TOKEN_KEY" -> sys.env.getOrElse("TWITTER_ACCESS_TOKEN_KEY", "default"),
  "TWITTER_ACCESS_TOKEN_SECRET" -> sys.env.getOrElse("TWITTER_ACCESS_TOKEN_SECRET", "default"),
)
dockerExposedVolumes := Seq("/opt/docker/logs")
dockerUpdateLatest := true

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies += "com.danielasfregola" %% "twitter4s" % "7.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

enablePlugins(JavaAppPackaging, DockerPlugin, AshScriptPlugin)
