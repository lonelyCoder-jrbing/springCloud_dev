package threadpoolTest;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Task {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
    private final int id;
    private final int timeMS;




    public Task(int timeMS) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.timeMS = timeMS;
    }

    public int getId() {
        return id;
    }

    public int getTimeMS() {
        return timeMS;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", timeMS='" + timeMS + '\'' +
                '}';
    }
}
