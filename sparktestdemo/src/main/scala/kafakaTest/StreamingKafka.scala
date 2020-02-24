package kafakaTest
//
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
//import com.fasterxml.jackson.databind.deser.std.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe


object StreamingKafka {



  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "D:\\hadoop-common\\hadoop-common-2.2.0-bin")
    val conf = new SparkConf().setMaster("local[2]").setAppName("sparkStremingTest").set("spark.streaming.stopGracefullyOnShutdown", "true")

    val ssc = new StreamingContext(conf, Seconds(2))

    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "streaming-kafka-test",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )
    val topics = Array("wordSender","test")
    val stream = KafkaUtils.createDirectStream[String, String](
      ssc,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    )
    stream.foreachRDD(_.foreachPartition(_.foreach(records=>println(records.value()))))
    ssc.checkpoint("./")
    stream.foreachRDD(x=>println("checkpoint:  ",x.checkpoint()))
    stream.foreachRDD(_.foreachPartition(partition=>if (partition.hasNext) println(partition.next() )))

    ssc.start()
    //设置日志级别
    ssc.sparkContext.setLogLevel("WARN")
    ssc.awaitTermination()
  }
}
