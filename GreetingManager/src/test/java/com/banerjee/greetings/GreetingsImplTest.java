package com.banerjee.greetings;

import com.banerjee.greetings.implementations.GreetingsImpl;
import com.banerjee.greetings.interfaces.Greetings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitPlatform.class)
public class GreetingsImplTest {
    private Greetings greeting;

    @BeforeEach
    public void setup() {
        greeting = new GreetingsImpl();
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
                Greetings greeting = new GreetingsImpl();
                greeting.greet(null);
            }
        });
    }

    @Test
    public void greetShouldThrowAnExceptionForNameEmpty()    {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Greetings greeting = new GreetingsImpl();
                greeting.greet("");
            }
        });
    }

    @AfterEach
    public void teardown()  {
        greeting = null;
    }
}
