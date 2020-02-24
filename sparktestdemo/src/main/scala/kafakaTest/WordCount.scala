package kafakaTest
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.{HashPartitioner, SparkConf}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.{Seconds, StreamingContext}
object WordCount {

  val updateFunc = (iterator: Iterator[(String, Seq[Int], Option[Int])]) => {
    iterator.flatMap{case(x,y,z)=> Some(y.sum + z.getOrElse(0)).map(n=>(x, n))}
  }

  def main(args: Array[String]): Unit = {
//    //接收命令行中的参数
//    val Array(zkQuorum, groupId, topics, numThreads, hdfs) = Array("hadoop1:2181", "streaming", "test2", "3", "file:///C:\\Users\\XT\\Desktop\\test")
//    //创建SparkConf并设置AppName
//    val conf = new SparkConf().setAppName("UrlCount")
//    //创建StreamingContext
//    val ssc = new StreamingContext(conf, Seconds(2))
//    //设置检查点
//    ssc.checkpoint(hdfs)
//    //设置topic信息
//    val topicMap = topics.split(",").map((_, numThreads.toInt)).toMap
//    //从Kafka中拉取数据创建DStream
//    val lines = KafkaUtils.createStream(ssc, zkQuorum, groupId, topicMap, StorageLevel.MEMORY_AND_DISK).map(_._2)
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
    val topics = Array("test")
    val stream = KafkaUtils.createDirectStream[String, String](
      ssc,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    ).map(_.key())
//    val wc = stream.flatMap(el=>el)
//    val result = wc.updateStateByKey(updateFunc, new HashPartitioner(ssc.sparkContext.defaultParallelism), true)
//    val wc = lines.flatMap(_.split(" ")).map((_, 1))
//    val result = wc.updateStateByKey(updateFunc, new HashPartitioner(ssc.sparkContext.defaultParallelism), true)
    //将结果打印到控制台
    ssc.checkpoint("./")
//    result.print()
    ssc.start()
    ssc.awaitTermination()




  }
}
