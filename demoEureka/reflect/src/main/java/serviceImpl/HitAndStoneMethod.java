package serviceImpl;

import service.StealMethod;

public class HitAndStoneMethod implements StealMethod {
    @Override
    public String pickTarget() {
        return "old goblin woman";
    }

    @Override
    public void confuseThetarget(String target) {
        System.out.println(String.format("aproach the %s from the behind", target));
    }

    @Override
    public void stealTheItem(String target) {
        System.out.println("grab the handbag and run away fast!");
    }

}
