package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

    @Test
    void TestCurrentPointsVariable() {
        try {
            Field field = Player.class.getDeclaredField("currentPoints");
            AnnotatedType fieldAnnotatedType = field.getAnnotatedType();
            Type fieldType = fieldAnnotatedType.getType();
            String fieldTypeName = fieldType.getTypeName();

            Assert.state(
                    Objects.equals(fieldTypeName, "int"),
                    String.format("currentPoints field Type should be int but is actually %s", fieldTypeName)
            );
        } catch (NoSuchFieldException e) {
            Assert.state(
                    false,
                    "Player variable currentPoints does not exist"
            );
        }
    }

    @Test
    void TestMethodPickALetter() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            Method playerPickALetter = player.getMethod("pickALetter", Character.TYPE);
            AnnotatedType methodAnnotatedReturnType = playerPickALetter.getAnnotatedReturnType();
            Type methodReturnType = methodAnnotatedReturnType.getType();
            String methodTypeName = methodReturnType.getTypeName();

            Assert.state(
                    Objects.equals(methodTypeName, "boolean"),
                    String.format("pickALetter return Type should be boolean but is actually %s", methodTypeName)
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"pickALetter() method does not exist");
        }
    }

    @Test
    void TestMethodGuessThePhrase() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            Class[] cArg = new Class[1];
            cArg[0] = String.class;
            Method playerGuessThePhrase = player.getMethod("guessThePhrase", cArg);
            AnnotatedType methodAnnotatedReturnType = playerGuessThePhrase.getAnnotatedReturnType();
            Type methodReturnType = methodAnnotatedReturnType.getType();
            String methodTypeName = methodReturnType.getTypeName();

            Assert.state(
                    Objects.equals(methodTypeName, "boolean"),
                    String.format("guessThePhrase return Type should be boolean but is actually %s", methodTypeName)
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"guessThePhrase method does not exist");
        }
    }
}
