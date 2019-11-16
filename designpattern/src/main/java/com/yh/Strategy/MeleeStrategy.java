package com.yh.Strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeleeStrategy implements DragonSlayingStratagy {
    private static final Logger LOGGER = LoggerFactory.getLogger(MeleeStrategy.class);

    @Override
    public void excute() {
        LOGGER.info("with your excalibur you serve the dragon's head!");
    }
}
