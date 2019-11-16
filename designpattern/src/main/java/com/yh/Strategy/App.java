package com.yh.Strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("green draggon spooted ahead");
        DragonSlayer slayer = new DragonSlayer(() -> {
            logger.info("with the excalibur you serve the dragon's head ");
        });
        slayer.gotoBattle();

        logger.info("red dragon emerges");
        slayer.changeStrategy(() -> {
            logger.info("you shoot the dragon with the crossbow and it falls dead on the ground");

        });
        slayer.gotoBattle();


        logger.info("black dragon lands before you");
        slayer.changeStrategy(() -> {
            logger.info("you cast the spell  of disintegration the dragon vaporizes in a pile of dust");
        });
        slayer.gotoBattle();
    }


}
