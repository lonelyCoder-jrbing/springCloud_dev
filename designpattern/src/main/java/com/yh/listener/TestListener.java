package com.yh.listener;

public class TestListener {

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.setName("alphgo");
        robot.registerListener(new MyRobotListener());
        robot.working();
        robot.dancing();
    }


}
