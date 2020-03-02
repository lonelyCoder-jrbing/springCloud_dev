package streamingTest.producer

import java.util

import com.google.gson.annotations.Until
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

object LogReader {
  def main(args: Array[String]): Unit = {
    //kafka服务器地址
    val brokers = "localhost:9092"
    val kafkaTopic = "logAnalyser"
    val props = new util.HashMap[String, Object]()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)
    val lines = readLogfromTxt("D:\\code\\springCloud\\scalaTest\\src\\wordcount\\controller.log");

    val lines01 = readLogfromTxt("D:\\kafka_2.11-2.4.0\\kafka_2.11-2.4.0\\kafka_2.11-2.4.0kafka_2.11-2.4.0logs\\replication-offset-checkpoint")
    while (lines01.length != 0) {
      for (i <- 0 until  lines01.length) {
        val msg = new ProducerRecord[String, String](kafkaTopic, null, lines01(i))
        producer.send(msg)
        Thread.sleep(1000)
      }
    }
  }

  def readLogfromTxt(filePath: String): Array[String] = {
    import scala.io._
    val source = Source.fromFile(filePath, "UTF-8")
    val lines = source.getLines().toArray
    source.close()
    return lines
  }


}
