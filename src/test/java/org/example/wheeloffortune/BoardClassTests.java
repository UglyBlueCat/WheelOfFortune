package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@SpringBootTest
public class BoardClassTests {


    @Test
    void BoardClassExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
        } catch (ClassNotFoundException cnfe) {
            Assert.state(
                    false,
                    "Board Class does not exist"
            );
        }
    }

    @Test
    void PlayersVariableExists() {
        try {
            Field field = Board.class.getDeclaredField("players");
        } catch (NoSuchFieldException e) {
            Assert.state(false, "Board variable players does not exist");
        }
    }

    @Test
    void PhraseVariableExists() {
        try {
            Field field = Board.class.getDeclaredField("phrase");
        } catch (NoSuchFieldException e) {
            Assert.state(false, "Board variable phrase does not exist");
        }
    }

    @Test
    void AnonymisedPhraseVariableExists() {
        try {
            Field field = Board.class.getDeclaredField("anonymisedPhrase");
        } catch (NoSuchFieldException e) {
            Assert.state(false, "Board variable anonymisedPhrase does not exist");
        }
    }

    @Test
    void GuessedLettersVariableExists() {
        try {
            Field field = Board.class.getDeclaredField("guessedLetters");
        } catch (NoSuchFieldException e) {
            Assert.state(false, "Board variable guessedLetters does not exist");
        }
    }

    @Test
    void MethodGetPlayersExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("getPlayers");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"getPlayers() method does not exist");
        }
    }

    @Test
    void MethodSetPlayersExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("setPlayers", List.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"setPlayers() method does not exist");
        }
    }

    @Test
    void MethodGetPhraseExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("getPhrase");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"getPhrase() method does not exist");
        }
    }

    @Test
    void MethodSetPhraseExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("setPhrase", String.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"setPhrase() method does not exist");
        }
    }

    @Test
    void MethodGetAnonymisedPhraseExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("getAnonymisedPhrase");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"getAnonymisedPhrase() method does not exist");
        }
    }

    @Test
    void MethodSetAnonymisedPhraseExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("setAnonymisedPhrase", char[].class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"setAnonymisedPhrase() method does not exist");
        }
    }

    @Test
    void MethodGetGuessedLettersExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("getGuessedLetters");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"getGuessedLetters() method does not exist");
        }
    }

    @Test
    void MethodSetGuessedLettersExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("setGuessedLetters", Set.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"setGuessedLetters() method does not exist");
        }
    }

    @Test
    void MethodGetTableOfPhrasesExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("getTableOfPhrases");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"getTableOfPhrases() method does not exist");
        }
    }

    @Test
    void MethodSetTableOfPhrasesExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("setTableOfPhrases", List.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"setTableOfPhrases() method does not exist");
        }
    }

    @Test
    void variableGetSetPlayersGetsAndSets() {
        final List<String> samplePlayers = Arrays.asList("Jimmy McJimmy", "Bill McWilliams");
        final Board board = new Board();
        board.setPlayers(samplePlayers);
        Assert.state(
                samplePlayers.equals(board.getPlayers()),
                "The value set by Board.setPlayers() was not the same as the value then returned by Board.getPlayers()"
        );
    }

    @Test
    void variableGetSetPhraseGetsAndSets() {
        final String samplePhrase = "This is a test phrase";
        final Board board = new Board();
        board.setPhrase(samplePhrase);
        Assert.state(
                samplePhrase.equals(board.getPhrase()),
                "The value set by Board.setPhrase() was not the same as the value then returned by Board.getPhrase()"
        );
    }

    @Test
    void variableGetSetAnonymisedPhraseGetsAndSets() {
        final char[] sampleAnonymisedPhrase = {'*', 'e', '*', '*', ' ', '*', '*', '*', 'a', '*', 'e'};
        final Board board = new Board();
        board.setAnonymisedPhrase(sampleAnonymisedPhrase);
        Assert.state(
                Arrays.equals(sampleAnonymisedPhrase, board.getAnonymisedPhrase()),
                "The value set by Board.setAnonymisedPhrase() was not the same as the value then returned by Board.getAnonymisedPhrase()"
        );
    }

    @Test
    void variableGetSetGuessedLettersGetsAndSets() {
        final Set<Character> sampleGuessedLetters = Set.of('a', 'e');
        final Board board = new Board();
        board.setGuessedLetters(sampleGuessedLetters);
        Assert.state(
                sampleGuessedLetters.equals(board.getGuessedLetters()),
                "The value set by Board.setGuessedLetters() was not the same as the value then returned by Board.getGuessedLetters()"
        );
    }

    @Test
    void variableGetSetTableOfPhrasesGetsAndSets() {
        final List<String> sampleTableOfPhrases = List.of(new String[]{
                "A Blessing in Disguise",
                "Best Seat in the House",
                "Once in a Blue Moon",
                "Right Place at the Right Time",
                "The Early Bird Gets the Worm",
                "A Piece of Cake",
                "Living the Dream",
                "Back to the Drawing Board",
                "A Breath of Fresh Air",
                "Making Memories Together"
        });
        final Board board = new Board();
        board.setTableOfPhrases(sampleTableOfPhrases);
        Assert.state(
                sampleTableOfPhrases.equals(board.getTableOfPhrases()),
                "The value set by Board.setTableOfPhrases() was not the same as the value then returned by Board.getTableOfPhrases()"
        );
    }

    @Test
    void TableOfPhrasesExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getDeclaredField("tableOfPhrases");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            Assert.state(
                    false,
                    "Table of phrases variables does not exist"
            );
        }
    }

    @Test
    void ConfirmTableOfPhrasesContainsSpecifiedList() {
        Board board = new Board();
        List<String> testTableOfPhrases =  List.of(new String[]{
                "A Blessing in Disguise",
                "Best Seat in the House",
                "Once in a Blue Moon",
                "Right Place at the Right Time",
                "The Early Bird Gets the Worm",
                "A Piece of Cake",
                "Living the Dream",
                "Back to the Drawing Board",
                "A Breath of Fresh Air",
                "Making Memories Together"
        });
        Assert.notEmpty(
                board.getTableOfPhrases(),
                "Table of Phrases is not empty"
        );
        Assert.isInstanceOf(
                List.class,
                board.getTableOfPhrases(),
                "Table of Phrases is not a List"
        );
        Assert.isTrue(
                board.getTableOfPhrases().equals(testTableOfPhrases),
                "Table of Phrases is not set to specified list"
        );
    }

    @Test
    void ConfirmCheckLetterMethodExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("checkLetter", Character.TYPE);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
            Assert.state(false,"Check Letter method does not exist");
        }
    }

    @Test
    void ConfirmRevealLetterMethodExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("revealLetter", Character.TYPE);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"Reveal Letter method does not exist");
        }
    }

    @Test
    void ConfirmCheckPhraseMethodExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("checkPhrase");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"Check Phrase method does not exist");
        }
    }

    @Test
    void ConfirmGeneratePhraseMethodExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getMethod("generatePhrase");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"Check Generate Phrase method does not exist");
        }
    }

    @Test
    void ConfirmAnonymisePhraseMethodExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getDeclaredMethod("anonymisePhrase");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"Check Anonymise Phrase method does not exist");
        }
    }

    @Test
    void ConfirmSetupBoardMethodExists() {
        try {
            Class<?> board = Class.forName("org.example.wheeloffortune.Board");
            board.getDeclaredMethod("setupBoard");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(
                false,
                "Setup board method does not exist"
            );
        }
    }

    @Test
    void ConfirmSetupBoardMethodSetsPhrase() {
        final Board board = new Board();
        board.setupBoard();
        final String phrase = board.getPhrase();

        Assert.state(
                phrase != null && !phrase.isEmpty(),
                "Setup board method did not generate the phrase"
        );
    }

    @Test
    void CheckLetterMethodCorrectlyChecksLetters() {
        Board board = new Board();
        board.setPhrase("Test phrase");
        Assert.state(
                board.checkLetter('a'),
                "Board.checkLetter returned false when letter parameter existed in phrase."
        );
        Assert.state(
                !board.checkLetter('b'),
                "Board.checkLetter returned true when letter parameter did not exist in phrase."
        );
    }

    @Test
    void CheckLetterMethodAddsLetterToGuessedLetters() {
        Board board = new Board();
        board.setPhrase("Test phrase");
        final Set<Character> samplePhraseLetters = Set.of('a', 'e');
        board.setGuessedLetters(samplePhraseLetters);

        final char playerChosenLetter = 's';
        board.checkLetter(playerChosenLetter);

        Set<Character> preUpdatedGuessedLetters = new HashSet<>(samplePhraseLetters);
        preUpdatedGuessedLetters.add(playerChosenLetter);
        Set<Character> updatedGuessedLetters = board.getGuessedLetters();

        Assert.state(
                updatedGuessedLetters.equals(preUpdatedGuessedLetters),
                "Board.checkLetter did not add the letter to guessed letters." +
                        " The updated guessed letters: " + updatedGuessedLetters +
                        " is not equal to: " + preUpdatedGuessedLetters
        );
    }

    @Test
    void CheckLetterMethodCallsAnonymisePhrase() {
        Board board = new Board();
        board.setPhrase("Test phrase");
        board.checkLetter('a');

        final char[] anonymisedPhrase = board.getAnonymisedPhrase();
        final char[] correctlyAnonymisedPhrase = {'*', '*', '*', '*', ' ', '*', '*', '*', 'a', '*', '*'};
        Assert.state(
                Arrays.equals(anonymisedPhrase, correctlyAnonymisedPhrase),
                "The anonymised phrase is being set to: " +
                        Arrays.toString(anonymisedPhrase) +
                        " when it should be set to: " +
                        Arrays.toString(correctlyAnonymisedPhrase)
        );
    }

    @Test
    void ConfirmGeneratePhraseMethodGeneratesPhrase() {
        Board board = new Board();
        List<String> tableOfPhrases = board.getTableOfPhrases();
        board.generatePhrase();
        String phrase = board.getPhrase();
        Assert.state(phrase != null, "phrase is not set");
        Assert.state(tableOfPhrases.contains(phrase), "phrase is not contained in table of phrases. phrase: "+phrase);
    }

    @Test
    void CheckPhraseMethodCorrectlyChecksGuessedPhrase() {
        Board board = new Board();
        final String correctTestingPhrase = "Test phrase";
        final String incorrectTestingPhrase = "Not "+correctTestingPhrase;

        board.setPhrase(correctTestingPhrase);
        Assert.state(board.checkPhrase(correctTestingPhrase), "Board.checkPhrase returned false when guessed phrase was correct");
        Assert.state(!board.checkPhrase(incorrectTestingPhrase), "Board.checkPhrase returned true when guessed phrase was incorrect");
    }

    @Test
    void AnonymisePhraseMethodAnonymisesPhrase() {
        Board board = new Board();
        board.setPhrase("Test phrase");
        Set<Character> letters = Set.of('a', 'e');
        board.setGuessedLetters(letters);

        try {
            Method publicAnonymisePhrase = board.getClass().getDeclaredMethod("anonymisePhrase");
            publicAnonymisePhrase.setAccessible(true);
            publicAnonymisePhrase.invoke(board, (Object[]) null);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        final char[] anonymisedPhrase = board.getAnonymisedPhrase();
        final char[] correctlyAnonymisedPhrase = {'*', 'e', '*', '*', ' ', '*', '*', '*', 'a', '*', 'e'};
        Assert.state(
                Arrays.equals(anonymisedPhrase, correctlyAnonymisedPhrase),
                "The anonymised phrase is being set to: " +
                        Arrays.toString(anonymisedPhrase) +
                        " when it should be set to: " +
                        Arrays.toString(correctlyAnonymisedPhrase)
        );
    }
}
