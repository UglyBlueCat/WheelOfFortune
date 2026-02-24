package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Objects;

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
    void TestNameVariable() {
        try {
            Field field = Player.class.getDeclaredField("name");
            AnnotatedType fieldAnnotatedType = field.getAnnotatedType();
            Type fieldType = fieldAnnotatedType.getType();
            String fieldTypeName = fieldType.getTypeName();

            Assert.state(
                    Objects.equals(fieldTypeName, "java.lang.String"),
                    String.format("name field Type should be String but is actually %s", fieldTypeName)
            );
        } catch (NoSuchFieldException e) {
            Assert.state(
                    false,
                    "Player variable name does not exist"
            );
        }
    }
}
