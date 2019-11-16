package com.yh.Strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectileStrategy implements DragonSlayingStratagy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectileStrategy.class);

    @Override
    public void excute() {
        LOGGER.info("you shoot the dragon with the magical crossBow and it falls dwad on the ground ");
    }
}
