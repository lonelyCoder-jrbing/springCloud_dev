package threadpoolTest;

public class PizzaMakingTask extends Task {

    //制造每个pizza需要的时间
    private static final int TIME_PER_CUP = 100;

    public PizzaMakingTask(int numCups) {
        super(TIME_PER_CUP * numCups);
    }

    @Override
    public String toString() {
        return String.format("%s %s ", this.getClass().getSimpleName(), super.toString());
    }
}
