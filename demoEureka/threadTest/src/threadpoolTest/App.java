package threadpoolTest;

import sun.nio.cs.ext.MS874;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new PizzaMakingTask(23));
        tasks.add(new PizzaMakingTask(22));
        tasks.add(new PizzaMakingTask(21));

        tasks.add(new CoffeMakingTask(12));
        tasks.add(new CoffeMakingTask(23));
        tasks.add(new CoffeMakingTask(22));
        tasks.add(new CoffeMakingTask(21));
        tasks.add(new CoffeMakingTask(12));
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue(3));
        tasks.stream().forEach(e -> {
            Runnable worker = new Worker(e);
            executor.execute(worker);
        });
        executor.shutdown();


    }


}
