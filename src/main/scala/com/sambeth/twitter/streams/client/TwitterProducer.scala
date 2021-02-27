package com.sambeth.twitter.streams.client

import com.danielasfregola.twitter4s.TwitterStreamingClient
import com.danielasfregola.twitter4s.entities.Tweet
import com.danielasfregola.twitter4s.entities.streaming.StreamingMessage
import com.sambeth.twitter.streams.client.Conf.ProducerAppConfig
import com.sambeth.twitter.streams.common.HelperFunctions
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.slf4j.{Logger, LoggerFactory}
import pureconfig.ConfigSource
import pureconfig.generic.auto._

import scala.io.Source
import scala.jdk.CollectionConverters._
import scala.util.Try

object TwitterProducer extends App with HelperFunctions {

  lazy val logger: Logger = LoggerFactory.getLogger(getClass)

  val tracking: Seq[String] = Seq("bitcoin")

  // read config file
  val configFileString = Source.fromResource("producer.conf").mkString("""""")

  val baseConfig = ConfigSource.string(configFileString).at("base").load[ProducerAppConfig].map { config =>
    val producerConfig: Map[String, AnyRef] = config.producerConfig.toMap
    val serializerConfig: Map[String, AnyRef] = config.serializerConfig.toMap
    val base: Map[String, AnyRef] = producerConfig ++ serializerConfig

    // set up kafka producer
    val kafkaProducer: KafkaProducer[String, String] = new KafkaProducer[String, String](base.asJava)

    Try {
      // set up twitter stream
      val streamClient = TwitterStreamingClient()
      streamClient.filterStatuses(stall_warnings = true, tracks = tracking)(sendTweetText(config.tweetTopicName, kafkaProducer))

      // flush stream appropriately
      kafkaProducer.flush()

    }.recover {
      case error: InterruptedException => logger.error("Failed to flush and close producer", error)
      case error => logger.error(s"An unexpected error occurred while producing $tracking related tweets", error)
    }
  }

  def sendTweetText(topic: String, kafkaProducer: KafkaProducer[String, String]): PartialFunction[StreamingMessage, Unit] = {
    case tweet: Tweet => {
      tweet.
      val producerRecord: ProducerRecord[String, String] = new ProducerRecord[String, String](topic, tweet.text)
      kafkaProducer send producerRecord
    }
  }
}
