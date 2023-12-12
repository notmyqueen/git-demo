package com.review.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logTest {
    private static final Logger logger = LoggerFactory.getLogger(logTest.class);

    public static void main(String[] args) {
        System.out.println("hi");
        logger.debug("LOGGER!!!");
    }
}
