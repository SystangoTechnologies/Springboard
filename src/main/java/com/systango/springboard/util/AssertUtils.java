package com.systango.springboard.util;

import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * @author Arpit Khandelwal
 */
public class AssertUtils {

    private AssertUtils() {

    }

    public static void notNull(Object... objects) {
        for (Object object : objects) {
            Assert.notNull(object, "argument can not be null");
        }
    }

    public static void positive(BigDecimal value) {
        Assert.isTrue(value.signum() == 1, "argument should be a positive value");
    }
}
