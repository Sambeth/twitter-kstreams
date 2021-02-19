name := "twitter-kstreams"

version := "0.1"

scalaVersion := "2.13.4"

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies += "com.danielasfregola" %% "twitter4s" % "7.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
