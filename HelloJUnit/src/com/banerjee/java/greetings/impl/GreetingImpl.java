package com.banerjee.java.greetings.impl;

import com.banerjee.java.greetings.interfaces.Greeting;

public class GreetingImpl implements Greeting {
    @Override
    public String greet(String name)  {
        return "Good Day " + name ;
    }
}
