package com.banerjee.java.greetings.impl;

import com.banerjee.java.greetings.interfaces.Greeting;

public class GreetingImpl implements Greeting {
    @Override
    public String greet(String name) throws IllegalArgumentException  {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException();
        }
        return "Good Day " + name ;
    }
}
