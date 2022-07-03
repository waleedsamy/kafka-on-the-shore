package io.github.waleedsamy.playground.kafka

import java.util.Properties
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Collections

object Consumer extends App {

  val topic = "CountryCounter"

  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("group.id", "CountryCounter")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

  val consumer = new KafkaConsumer[String, String](props)
  consumer.subscribe(Collections.singletonList(topic))

  while (true) {
    val records = consumer.poll(100)
    records.forEach(r => {
      println(
        f"topic = ${r.topic()}, partition = ${r.partition()}, offset = ${r.offset()}, key = ${r.key()}, value = ${r.value()}"
      )
    })
  }
}
