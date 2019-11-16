package com.yh.TestTemplateMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HitAndRunMethod extends StealingMethod {
    private static final Logger LOGGER = LoggerFactory.getLogger(HitAndRunMethod.class);

    @Override
    protected String pickTarget() {
        return "old goblin woman";
    }

    @Override
    protected void confuseTarget(String target) {
        LOGGER.info("aproach the {} from the behind", target);
    }

    @Override
    protected void stealTheItem(String target) {
        LOGGER.info("grab the handbag and run away fast!");
    }
}
