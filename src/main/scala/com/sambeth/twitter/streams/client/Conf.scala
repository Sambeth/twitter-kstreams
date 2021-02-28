package com.sambeth.twitter.streams.client

import com.typesafe.config.Config


object Conf {

  case class ProducerAppConfig(producerConfig: Config,
                               serializerConfig: Config,
                               tweetTopicName: String)

}
