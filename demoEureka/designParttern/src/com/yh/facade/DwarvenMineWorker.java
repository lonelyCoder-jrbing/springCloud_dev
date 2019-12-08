package com.yh.facade;

import com.sun.xml.internal.xsom.XSUnionSimpleType;

public abstract class DwarvenMineWorker {

    public void gosleep() {
        System.out.println("gold  mine worker go to sleep ..");
    }

    public void weakUp() {
        System.out.println("gold mine worker weak up ");
    }

    public void goHome() {
        System.out.println("gold mine worker go home");
    }

    public void goTtoMine() {
        System.out.println("gold mine worker go to  work...");
    }

    public void action(Action action) {
        switch (action) {
            case GO_HOME:
                goHome();
                break;
            case WAKE_UP:
                weakUp();
                break;
            case GO_TO_MINE:
                goTtoMine();
                break;
            case GO_TO_SLEEP:
                gosleep();
                break;
            default:
                System.out.println("undefined action...");
                break;
        }
    }

    public void action(Action... actions) {
        for (Action e : actions) {
            action(e);
        }
    }

    public abstract void work();

    public abstract String name();

    enum Action {
        GO_TO_SLEEP, GO_TO_MINE, WAKE_UP, GO_HOME;
    }


}
