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
    void ClassPlayerExists() {
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
    void VariableNameExists() {
        try {
            Player.class.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            Assert.state(
                    false,
                    "Player variable name does not exist"
            );
        }
    }

    @Test
    void VariableNameIsString() {
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
    void VariableCurrentPointsExists() {
        try {
            Player.class.getDeclaredField("currentPoints");
        } catch (NoSuchFieldException e) {
            Assert.state(
                    false,
                    "Player variable currentPoints does not exist"
            );
        }
    }

    @Test
    void VariableCurrentPointsIsInteger() {
        try {
            Field field = Player.class.getDeclaredField("currentPoints");
            AnnotatedType fieldAnnotatedType = field.getAnnotatedType();
            Type fieldType = fieldAnnotatedType.getType();
            String fieldTypeName = fieldType.getTypeName();

            Assert.state(
                    Objects.equals(fieldTypeName, "java.lang.Integer"),
                    String.format("currentPoints field Type should be java.lang.Integer but is actually %s", fieldTypeName)
            );
        } catch (NoSuchFieldException e) {
            Assert.state(
                    false,
                    "Player variable currentPoints does not exist"
            );
        }
    }

    @Test
    void MethodPickALetterExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            player.getMethod("pickALetter", Character.TYPE);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"pickALetter() method does not exist");
        }
    }

    @Test
    void MethodPickALetterReturnsBoolean() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            Method playerPickALetter = player.getMethod("pickALetter", Character.TYPE);
            AnnotatedType methodAnnotatedReturnType = playerPickALetter.getAnnotatedReturnType();
            Type methodReturnType = methodAnnotatedReturnType.getType();
            String methodTypeName = methodReturnType.getTypeName();

            Assert.state(
                    Objects.equals(methodTypeName, "boolean"),
                    String.format("pickALetter() return Type should be boolean but is actually %s", methodTypeName)
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"pickALetter() method does not exist");
        }
    }

    @Test
    void MethodGuessThePhraseExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            Class[] cArg = new Class[1];
            cArg[0] = String.class;
            player.getMethod("guessThePhrase", cArg);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"guessThePhrase() method does not exist");
        }
    }

    @Test
    void MethodGuessThePhraseReturnsBoolean() {
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
                    String.format("guessThePhrase() return Type should be boolean but is actually %s", methodTypeName)
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"guessThePhrase() method does not exist");
        }
    }

    @Test
    void MethodStartGameExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            player.getMethod("startGame");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"startGame() method does not exist");
        }
    }

    @Test
    void MethodStartAgainExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            player.getMethod("startAgain");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"startAgain() method does not exist");
        }
    }

    @Test
    void MethodGiveUpExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            player.getMethod("giveUp");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"giveUp() method does not exist");
        }
    }
}
