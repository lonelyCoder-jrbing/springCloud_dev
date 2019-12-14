package com.yh.listener;

import java.util.Objects;

public class Robot {

    private RobotListener listener;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 注册机器人监听器
     */
    public void registerListener(RobotListener listener) {
        this.listener = listener;
    }

    /**
     * 工作
     * 重点是在机器人工作的方法中调用监听器中的工作方法
     */
    public void working() {

        if (Objects.nonNull(listener)) {
            //注册机器人
            Event event = new Event(this);
            this.listener.working(event);
            System.out.println("机器人开始工作");

        }
    }

    /**
     * 在机器人跳舞的方法中调用监听器中的跳舞方法
     */
    public void dancing() {
        if (Objects.nonNull(listener)) {
            Event event = new Event(this);
            this.listener.dancing(event);
        }
        System.out.println("机器人开始跳舞...");
    }

}
