package com.sambeth.twitter.streams

import com.danielasfregola.twitter4s.TwitterStreamingClient
import com.danielasfregola.twitter4s.entities.Tweet
import com.danielasfregola.twitter4s.entities.streaming.StreamingMessage

object TwitterProducer extends App {

  val streamClient = TwitterStreamingClient()

  def printTweetText: PartialFunction[StreamingMessage, Unit] = {
    case tweet: Tweet => println(tweet.text)
  }

  streamClient.filterStatuses(stall_warnings = true, tracks = Seq("kafka"))(printTweetText)
}
