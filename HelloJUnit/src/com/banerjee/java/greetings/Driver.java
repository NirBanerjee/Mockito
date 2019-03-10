package com.banerjee.java.greetings;

import com.banerjee.java.greetings.impl.GreetingImpl;

public class Driver {
    public static void main(String[] args)  {
        GreetingImpl g = new GreetingImpl();
        System.out.println(g.greet("Mate"));
    }
}
