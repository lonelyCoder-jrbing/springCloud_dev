package com.yh.Strategy;

public class DragonSlayer {
    private DragonSlayingStratagy dragonSlayingStratagy;

    public DragonSlayer(DragonSlayingStratagy dragonSlayingStratagy) {
        this.dragonSlayingStratagy = dragonSlayingStratagy;
    }

    public void changeStrategy(DragonSlayingStratagy dragonSlayingStratagy) {
        this.dragonSlayingStratagy = dragonSlayingStratagy;
    }

    public void gotoBattle() {
        this.dragonSlayingStratagy.excute();
    }
}
