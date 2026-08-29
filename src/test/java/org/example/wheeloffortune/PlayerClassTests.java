package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Objects;

@SpringBootTest
public class PlayerClassTests {

    @Autowired
    Player autowiredPlayer;

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
    void VariableBoardExists() {
        try {
            Player.class.getDeclaredField("board");
        } catch (NoSuchFieldException e) {
            Assert.state(
                    false,
                    "Player variable board does not exist"
            );
        }
    }

    @Test
    void VariableBoardIsBoard() {
        try {
            Field field = Player.class.getDeclaredField("board");
            AnnotatedType fieldAnnotatedType = field.getAnnotatedType();
            Type fieldType = fieldAnnotatedType.getType();
            String fieldTypeName = fieldType.getTypeName();

            Assert.state(
                    Objects.equals(fieldTypeName, "org.example.wheeloffortune.Board"),
                    String.format("board field Type should be org.example.wheeloffortune.Board but is actually %s", fieldTypeName)
            );
        } catch (NoSuchFieldException e) {
            Assert.state(
                    false,
                    "Player variable board does not exist"
            );
        }
    }

    @Test
    void MethodGetBoardExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            player.getMethod("getBoard");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"getBoard() method does not exist");
        }
    }

    @Test
    void MethodSetBoardExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            player.getMethod("setBoard", Board.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"setBoard() method does not exist");
        }
    }

    @Test
    void VariableBoardInstantiated() {

        Assert.notNull(
                autowiredPlayer,
                "Player is not instantiated"
        );

        final Board board = autowiredPlayer.getBoard();

        Assert.notNull(
                board,
                "Player.board is not instantiated when Player is instantiated"
        );
    }

    @Test
    void MethodPickALetterExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            Class<?>[] cArg = new Class[2];
            cArg[0] = Board.class;
            cArg[1] = Character.TYPE;
            player.getMethod("pickALetter", cArg);
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
            Class<?>[] cArg = new Class[2];
            cArg[0] = Board.class;
            cArg[1] = Character.TYPE;
            Method playerPickALetter = player.getMethod("pickALetter", cArg);
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
            Class<?>[] cArg = new Class[2];
            cArg[0] = Board.class;
            cArg[1] = String.class;
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
            Class<?>[] cArg = new Class[2];
            cArg[0] = Board.class;
            cArg[1] = String.class;
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
    void CheckGuessThePhraseMethodReturnsCorrectBoolean() {
        final Board board = new Board();
        final String correctTestingPhrase = "Test phrase";
        final String incorrectTestingPhrase = "Not "+correctTestingPhrase;
        board.setPhrase(correctTestingPhrase);
        final Player player = new Player();

        Assert.state(
                player.guessThePhrase(board, correctTestingPhrase),
                "Player.guessThePhrase returned false when guessed phrase was correct"
        );
        Assert.state(
                !player.guessThePhrase(board, incorrectTestingPhrase),
                "Player.guessThePhrase returned true when guessed phrase was incorrect"
        );
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

    @Test
    void MethodPickALetterReturnsCorrectBoolean() {
        Board board = new Board();
        board.setPhrase("Test phrase");
        Player player = new Player();

        Assert.state(
                player.pickALetter(board, 'a'),
                "Player.pickALetter did not return true when letter parameter existed in phrase."
        );
        Assert.state(
                !player.pickALetter(board, 'b'),
                "Player.pickALetter returned true when letter parameter did not exist in phrase."
        );
    }

    @Test
    void MethodGetNameExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            player.getMethod("getName");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"getName() method does not exist");
        }
    }

    @Test
    void MethodSetNameExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            player.getMethod("setName", String.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"setName() method does not exist");
        }
    }

    @Test
    void MethodGetCurrentPointsExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            player.getMethod("getCurrentPoints");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"getCurrentPoints() method does not exist");
        }
    }

    @Test
    void MethodSetCurrentPointsExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.Player");
            player.getMethod("setCurrentPoints", Integer.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"setCurrentPoints() method does not exist");
        }
    }

    @Test
    void variableGetSetNameGetsAndSets() {
        final String sampleName = "Jimmy McJimmy";
        final Player player = new Player();
        player.setName(sampleName);
        Assert.state(
                sampleName.equals(player.getName()),
                "The value set by Player.setName() was not the same as the value then returned by Player.getName()"
        );
    }

    @Test
    void variableGetSetCurrentPointsGetsAndSets() {
        final Integer samplePoints = 3;
        final Player player = new Player();
        player.setCurrentPoints(samplePoints);
        Assert.state(
                samplePoints.equals(player.getCurrentPoints()),
                "The value set by Player.setCurrentPoints() was not the same as the value then returned by Player.getCurrentPoints()"
        );
    }
}
