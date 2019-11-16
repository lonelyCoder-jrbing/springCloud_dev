package com.yh.Strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellStrategy implements DragonSlayingStratagy {
    private static final Logger logger = LoggerFactory.getLogger(SpellStrategy.class);

    @Override
    public void excute() {
        logger.info("you cast the spell of disintegration and the dragon vaporizes in a pile of dust");
    }
}
