package consumer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import mqutil.ConnectionUtil;

public class Consumer2 {
    private final static String QUEUE_NAME = "queue_name_test";

    public static void main(String[] args) {
        Consumer2 consumer = new Consumer2();
        try {
            consumer.getMesssage();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    public void getMesssage() throws IOException, TimeoutException {
        ConnectionUtil util = new ConnectionUtil();
        Connection connection = util.getConnection();

        // 创建一个通道
        Channel channel = connection.createChannel();
        // 申明要关注的队列
//        channel.exchangeDeclare("exchange_name_test", "direct",false, false, false, null);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        /*
         * DefaultConsumer类实现了Consumer接口，通过传入频道，告诉服务器我们需要哪个频道的消息
         * 如果频道中有消息就会执行回调函数
         */
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws UnsupportedEncodingException {

                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
