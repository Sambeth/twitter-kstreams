name := "twitter-kstreams"

version := "0.1"

scalaVersion := "2.13.4"

ThisBuild / scalacOptions    ++= Seq("-language:postfixOps")

mainClass in Compile := Some("com.sambeth.twitter.streams.client.TwitterProducer")

mappings in Universal += {
  val conf = (resourceDirectory in Compile).value / "application.conf"
  conf -> "conf/application.conf"
}

mappings in Universal += {
  val conf = (resourceDirectory in Compile).value / "producer.conf"
  conf -> "conf/producer.conf"
}

dockerBaseImage := "openjdk:8-jre-alpine"
maintainer := "Samuel Baafi Bokaye <sambethslim@gmail.com>"
dockerExposedVolumes := Seq("/opt/docker/logs")
dockerUpdateLatest := true

resolvers += Resolver.sonatypeRepo("releases")
resolvers += "Confluent Repo" at "https://packages.confluent.io/maven"

libraryDependencies += "com.danielasfregola" %% "twitter4s" % "7.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "2.7.0"
libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.14.0"
libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-refined" % "4.0.4"
libraryDependencies += "io.confluent" % "kafka-avro-serializer" % "5.3.0"
libraryDependencies += "org.apache.avro" % "avro" % "1.10.1"

enablePlugins(JavaAppPackaging, DockerPlugin, AshScriptPlugin)
