package com.sambeth.twitter.streams.common

import java.util.Properties

import scala.jdk.CollectionConverters._
import com.typesafe.config.Config

trait HelperFunctions {

  implicit class configMapperOps(config: Config) {
    def toMap: Map[String, AnyRef] = {
      config
        .entrySet()
        .asScala
        .map(pair => (pair.getKey, config.getAnyRef(pair.getKey)))
        .toMap
    }

    def toProperties: Properties = {
      val properties = new Properties()
      properties.putAll(config.toMap.asJava)
      properties
    }
  }

}
