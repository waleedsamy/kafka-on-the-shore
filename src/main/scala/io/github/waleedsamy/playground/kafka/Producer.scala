package io.github.waleedsamy.playground.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object Producer extends App {

  val topic = "CountryCounter"
  val msgCount = 1

  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("client.id", "producer")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)

  (0 until msgCount).foreach(idx => {
    println(s"sending ${idx}...")
    val data = new ProducerRecord[String, String](topic, idx.toString(), s"msg ${idx}")
    producer.send(data)
  })

  producer.close()
  println("done.")
}
