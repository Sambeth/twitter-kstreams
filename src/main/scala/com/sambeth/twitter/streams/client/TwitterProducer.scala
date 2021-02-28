//package com.sambeth.twitter.streams.client
//
//import java.io.File
//
//import com.danielasfregola.twitter4s.TwitterStreamingClient
//import com.danielasfregola.twitter4s.entities.Tweet
//import com.danielasfregola.twitter4s.entities.streaming.StreamingMessage
//import com.sambeth.twitter.streams.client.Conf.ProducerAppConfig
//import com.sambeth.twitter.streams.common.HelperFunctions
//import com.sksamuel.avro4s.{AvroOutputStream, AvroSchema, Record, RecordFormat}
//import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
//import org.slf4j.{Logger, LoggerFactory}
//import pureconfig.ConfigSource
//import pureconfig.generic.auto._
//
//import scala.io.Source
//import scala.jdk.CollectionConverters._
//import scala.util.Try
//
//object TwitterProducer extends App with HelperFunctions {
//
//  lazy val logger: Logger = LoggerFactory.getLogger(getClass)
//
//  val tracking: Seq[String] = Seq("bitcoin")
//
//  // get avro schema record format
////  val tweetFormat = RecordFormat[CustomTweet]
//  val tweetFormat = RecordFormat[Tweet]
//
//  // read config file
//  val configFileString = Source.fromResource("producer.conf").mkString("""""")
//
//  val baseConfig = ConfigSource.string(configFileString).at("base").load[ProducerAppConfig].map { config =>
//    val producerConfig: Map[String, AnyRef] = config.producerConfig.toMap
//    val serializerConfig: Map[String, AnyRef] = config.serializerConfig.toMap
//    val base: Map[String, AnyRef] = producerConfig ++ serializerConfig
//
//    // set up kafka producer
//    val kafkaProducer = new KafkaProducer[String, Record](base.asJava)
//
////    Try {
////      // set up twitter stream
////      val streamClient = TwitterStreamingClient()
////      streamClient.filterStatuses(
////        stall_warnings = true, tracks = tracking
////      )(sendTweetText(config.tweetTopicName, kafkaProducer))
////
////      // flush stream appropriately
////      kafkaProducer.flush()
////
////    }.recover {
////      case error: InterruptedException => logger.error("Failed to flush and close producer", error)
////      case error => logger.error(s"An unexpected error occurred while producing $tracking related tweets", error)
////    }
//  }
//
//  def sendTweetText(topic: String,
//                    kafkaProducer: KafkaProducer[String, Record]): PartialFunction[StreamingMessage, Unit] = {
//    case tweet: Tweet => {
////      sambether(tweet)
////      println("I am super here")
////      val customTweet: CustomTweet = CustomTweet(
////        contributors=tweet.contributors,
////        coordinates=tweet.coordinates,
////        created_at=tweet.created_at,
////        current_user_retweet=tweet.current_user_retweet,
////        entities=tweet.entities,
////        extended_entities=tweet.extended_entities,
////        extended_tweet=tweet.extended_tweet,
////        favorite_count=tweet.favorite_count,
////        favorited=tweet.favorited,
////        filter_level=tweet.filter_level,
////        geo=tweet.geo,
////        id=tweet.id,
////        id_str=tweet.id_str,
////        in_reply_to_screen_name=tweet.in_reply_to_screen_name,
////        in_reply_to_status_id=tweet.in_reply_to_status_id,
////        in_reply_to_status_id_str=tweet.in_reply_to_status_id_str,
////        in_reply_to_user_id=tweet.in_reply_to_user_id,
////        in_reply_to_user_id_str=tweet.in_reply_to_user_id_str,
////        is_quote_status=tweet.is_quote_status,
////        lang=tweet.lang,
////        place=tweet.place,
////        possibly_sensitive=tweet.possibly_sensitive,
////        quoted_status_id=tweet.quoted_status_id,
////        quoted_status_id_str=tweet.quoted_status_id_str,
////        quoted_status=tweet.quoted_status,
////        scopes=tweet.scopes,
////        retweet_count=tweet.retweet_count,
////        retweeted=tweet.retweeted,
////        retweeted_status=tweet.retweeted_status,
////        source=tweet.source,
////        text=tweet.text,
////        truncated=tweet.truncated,
////        display_text_range=tweet.display_text_range,
////        user=tweet.user,
////        withheld_copyright=tweet.withheld_copyright,
////        withheld_in_countries=tweet.withheld_in_countries,
////        withheld_scope=tweet.withheld_scope,
////        metadata=tweet.metadata
////      )
////      println(customTweet.toString)
////      val tweetRecord: Record = tweetFormat.to(customTweet)
////      println(customTweet.toString)
////      println(tweetRecord.getSchema)
////      val producerRecord = new ProducerRecord[String, Record](topic, tweetRecord)
////      println("I am super here lower")
////      println("I am here as super well")
////      kafkaProducer send producerRecord
////      kafkaProducer.send(
////        new ProducerRecord[String, Record](topic, tweetFormat.to(tweet))
////      )
//    }
//  }
//
////  def sambether(tweet: Tweet): Unit = {
////    println("It is meesy")
////    val tweetRecord: Record = tweetFormat.to(tweet)
////    println("it is meesy second")
////  }
//}
