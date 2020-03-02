package streamingTest.comsumer;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public class JavaWordCount {
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "D:\\hadoop-common\\hadoop-common-2.2.0-bin");
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(10));

// input
// Create a DStream that will connect to hostname:port, like localhost:9999
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 9999);
        System.out.println("LINES:  " + lines);
// Split each line into words
//        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());
//// Count each word in each batch
//        JavaPairDStream<String, Integer> pairs = words.mapToPair(s -> new Tuple2<>(s, 1));
//        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey((i1, i2) -> i1 + i2);

// output
//        wordCounts.print();

// execute
        try {
            jssc.start();
            jssc.awaitTermination();
        } catch (Exception e) {
            System.out.println("spark word count start error");
        }


    }


}
