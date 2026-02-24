package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.lang.reflect.Field;

@SpringBootTest
public class PlayerClassTests {

    @Test
    void TestPlayerClassExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
        } catch (ClassNotFoundException cnfe) {
            Assert.state(
                    false,
                    "Player Class does not exist"
            );
        }
    }

    @Test
    void TestNameVariableExists() {
        try {
            Field field = Player.class.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            Assert.state(
                    false,
                    "Player variable name does not exist"
            );
        }
    }
}
