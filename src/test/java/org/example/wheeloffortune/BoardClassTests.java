package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
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
            Assert.state(false, "Board variable name does not exist");
        }
    }

    @Test
    void PhraseVariableExists() {
        Board board = new Board();
        board.setPhrase("");
        Assert.state(
                board.getPhrase().isEmpty(),
                "Phrase variable does not exist"
        );
    }

    @Test
    void AnonymisedPhraseVariableExists() {
        Board board = new Board();
        char c = 'a';
        board.setAnonymisedPhrase(new char[]{c});
        Assert.state(
                Arrays.equals(board.getAnonymisedPhrase(), new char[]{c}),
                "Anonymised phrase variable does not exist"
        );
    }

    @Test
    void GuessedLettersVariableExists() {
        Board board = new Board();
        Set<Character> letters = Set.of('a');
        board.setGuessedLetters(letters);
        Assert.state(
                board.getGuessedLetters().equals(letters),
                "Guessed letters variable exists"
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
            board.getMethod("anonymisePhrase");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"Check Anonymise Phrase method does not exist");
        }
    }

    @Test
    void CheckLetterMethodCorrectlyChecksLetters() {
        Board board = new Board();
        board.setPhrase("Test phrase");
        Assert.state(board.checkLetter('a'), "Board.checkLetter returned false when letter parameter existed in phrase.");
        Assert.state(!board.checkLetter('b'), "Board.checkLetter returned true when letter parameter did not exist in phrase.");
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
}
