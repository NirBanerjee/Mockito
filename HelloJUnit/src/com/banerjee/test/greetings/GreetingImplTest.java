package com.banerjee.test.greetings;

import com.banerjee.java.greetings.impl.GreetingImpl;
import com.banerjee.java.greetings.interfaces.Greeting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingImplTest {

    @Test
    public void greetShouldReturnValidOutput()  {
        Greeting greeting = new GreetingImpl();

        String result = greeting.greet("Mate");
        assertNotNull(result);
        assertEquals("Good Day Mate", result);
    }
}