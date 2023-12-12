package com.review.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public User() {
        System.out.println("User is being generated.");
        logger.info("LOGGGGGGGEEERRR");
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
