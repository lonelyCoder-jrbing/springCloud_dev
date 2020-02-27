package kafakaTest.comsumer

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object KafkaWordCount {
  def main(args: Array[String]): Unit = {
//    StreamingExamples.setStreamingLogLeaves()
    val sc = new SparkConf().setAppName("KafkaWordCount").setMaster("local[2]")
//     spark streaming设置，第二个参数为微批处理的时间间隔，后面的时间窗口与移动时间要为此时间倍数
    val ssc = new StreamingContext(sc, Seconds(1))
    // 设置checkpoint的目录，spark默认为hdfs文件，在用户目录下可省略写'checkpoint'，本地文件写file:///...
    ssc.checkpoint("hdfs://localhost:9000/user/ghost/checkpoint")
//    // zookeeper服务地址
    val zkQuorum = "localhost:2181"
//    // topic所在的group，可以设置为自己想要的名称
    val group = "test-consumer-group"
//    // topics的名称
    val topics = "wordSender"
    val numThreads = 1
    val topicMap = topics.split(",").map((_, numThreads.toInt)).toMap
//    val lineMap = KafkaUtils.createDirectStream()(ssc, zkQuorum, group, topicMap)
//    val lines = lineMap.map(_._2)
//    val words = lines.flatMap(_.split(" "))
//    val pair = words.map(x => (x, 1))
//    // 此重载函数复用过去计算过的值，提高效率，第一个时间为处理的时间窗口，第二个时间为窗口移动间隔
//    val wordCount = pair.reduceByKeyAndWindow(_+_, _-_, Seconds(3), Seconds(1), 2)
//    wordCount.print
//    ssc.start
//    ssc.awaitTermination
  }
}
