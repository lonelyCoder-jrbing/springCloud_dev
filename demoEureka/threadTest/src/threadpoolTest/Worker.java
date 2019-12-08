package threadpoolTest;


public class Worker implements Runnable {
    private final Task task;

    public Worker(final Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(task.getTimeMS());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
