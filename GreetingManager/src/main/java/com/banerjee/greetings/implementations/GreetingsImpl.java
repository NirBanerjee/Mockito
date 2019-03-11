package com.banerjee.greetings.implementations;

import com.banerjee.greetings.interfaces.Greetings;

public class GreetingsImpl implements Greetings {

    @Override
    public String greet(String name)  {
        return "Good Day " + name ;
    }
}
