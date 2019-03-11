package com.banerjee.greetings.implementations;

import com.banerjee.greetings.interfaces.Greetings;

public class GreetingsImpl implements Greetings {

    @Override
    public String greet(String name) throws IllegalArgumentException  {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException();
        }
        return "Good Day " + name ;
    }
}
