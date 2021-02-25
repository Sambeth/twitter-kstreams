package com.sambeth.twitter.streams.client

import com.typesafe.config.Config

import scala.concurrent.duration.FiniteDuration

object Conf {

  case class ProducerAppConfig(producerConfig: Config,
                               serializerConfig: Config,
                               tweetTopicName: String,
                               generatorPeriod: FiniteDuration,
                               generatorParallelismLevel: Int = 1)

}
