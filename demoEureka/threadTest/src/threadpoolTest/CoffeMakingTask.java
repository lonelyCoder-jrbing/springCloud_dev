package threadpoolTest;

public class CoffeMakingTask extends Task {
    //制造每杯咖啡需要的时间
    private static final int TIME_PER_CUP = 100;

    public CoffeMakingTask(int numCups) {
        super(numCups * TIME_PER_CUP);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
    }
}
