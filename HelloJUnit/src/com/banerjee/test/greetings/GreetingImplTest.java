package com.banerjee.test.greetings;

import com.banerjee.java.greetings.impl.GreetingImpl;
import com.banerjee.java.greetings.interfaces.Greeting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class GreetingImplTest {

    private Greeting greeting;

    @BeforeEach
    public void setup() {
        greeting = new GreetingImpl();
    }

    @Test
    public void greetShouldReturnValidOutput()  {
        String result = greeting.greet("Mate");
        assertNotNull(result);
        assertEquals("Good Day Mate", result);
    }

    @Test
    public void greetShouldThrowAnExceptionForNameNull()    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Greeting greeting = new GreetingImpl();
                greeting.greet(null);
            }
        });
    }

    @Test
    public void greetShouldThrowAnExceptionForNameEmpty()    {
         assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Greeting greeting = new GreetingImpl();
                greeting.greet("");
            }
        });
    }

    @AfterEach
    public void teardown()  {
        greeting = null;
    }
}