package serviceImpl;

import service.StealMethod;

public class SubtleMethod implements StealMethod {
    @Override
    public String pickTarget() {


        return "shop keeper";
    }

    @Override
    public void confuseThetarget(String target) {
        System.out.println(String.format("Approach the %s with tears runing  and hug him!", target));
    }

    @Override
    public void stealTheItem(String target) {
        System.out.println(String.format("while in close contact grab the %s's wallet ", target));
    }

}
