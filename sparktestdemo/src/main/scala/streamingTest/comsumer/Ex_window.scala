package streamingTest.comsumer

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Ex_window {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\hadoop-common\\hadoop-common-2.2.0-bin")
    val conf = new SparkConf(true).setMaster("local[2]").setAppName("spark streaming wordcount")

    conf.set("spark.streaming.stopGracefullyOnShutdown", "true")

    //环境对象，设置采集周期
    val scc: StreamingContext = new StreamingContext(conf, Seconds(10))
    // TODO: 可以通过ssc.sparkContext 来访问SparkContext或者通过已经存在的SparkContext来创建StreamingContext

    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "use_a_separate_group_id_for_each_stream",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (true: java.lang.Boolean)
    )

    val topics = Array("logAnalyser")

    val kafkaStream: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream[String, String](
      scc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](
        topics,
        kafkaParams
      )
    )


    //采集周期为5秒，窗口为15秒（包含三个采集批次），滑动步长为5秒，即每个批次滑动一次。
    val words: DStream[String] = kafkaStream.flatMap(t => t.value().split(" ")).window(Seconds(30), Seconds(10))


    //    val words: DStream[String] = socketStream.flatMap(_.split(" "))
    words.foreachRDD(_.foreachPartition(_.foreach(records=>println(records))))
    val pairs = words.map(word => (word, 1))

    val wordCounts: DStream[(String, Int)] = pairs.reduceByKey(_ + _)

    // Print the first ten elements of each RDD generated in this DStream to the console
    wordCounts.print

    // Start the computation
    // 通过 streamingContext.start()来启动消息采集和处理
    scc.start()

    // Wait for the computation to terminate
    // 通过streamingContext.stop()来手动终止处理程序
    scc.awaitTermination()

  }
}
