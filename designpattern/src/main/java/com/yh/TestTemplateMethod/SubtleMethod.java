package com.yh.TestTemplateMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubtleMethod extends StealingMethod {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubtleMethod.class);

    @Override
    protected String pickTarget() {
        return "shop keeper";
    }

    @Override
    protected void confuseTarget(String target) {
        LOGGER.info("Approach the {} with tears runing  and hug him!", target);
    }

    @Override
    protected void stealTheItem(String target) {
        LOGGER.info("while in close contact grab the {}'s wallet ", target);
    }
}
