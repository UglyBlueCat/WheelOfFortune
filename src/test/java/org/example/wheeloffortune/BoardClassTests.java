package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.lang.Boolean;

@SpringBootTest
public class BoardClassTests {

    @Test
    void TestPlayerClassExists(){
        try {
            Class.forName("org.example.wheeloffortune.Board");
        } catch (ClassNotFoundException cnfe) {
            Assert.state(
                    false,
                    "Board Class does not exist"
            );
        }
    }

    @Test
    void TestPlayersVariableExists(){
        Assert.state(
                (new Board().players = new ArrayList<>()).isEmpty(),
                "Board variable name does not exist"
        );
    }

    @Test
    void TestPhraseVariableExists(){
        var x = new Board();
        x.setPhrase("");
        Assert.state(
                x.getPhrase().isEmpty(),
                "Phrase variable does not exist"
        );
    }

    @Test
    void TestAnonymisedPhraseExists(){
        var x = new Board();
        char c = 'a';
        x.setAnonymisedPhrase(new char[]{c});
        Assert.state(
                Arrays.equals(x.getAnonymisedPhrase(), new char[]{c}),
                "Anonymised phrase variable does not exist"
        );
    }

    @Test
    void TestGuessedLettersVariableExists(){
        var x = new Board();
        var s = Set.of('a');
        x.setGuessedLetters(s);
        Assert.state(
                x.getGuessedLetters().equals(s),
                "Guessed letters variable exists"
        );
    }

    @Test
    void TestTableOfPhrasesExists() throws ClassNotFoundException {
        var x = Class.forName("org.example.wheeloffortune.Board");
        try {
            Field fieldOfTableOfPhrases = x.getDeclaredField("tableOfPhrases");
        } catch (NoSuchFieldException e) {
            Assert.state(
                    false,
                    "Table of phrases variables does not exist"
            );
        }
    }

    @Test
    void TestConfirmTableOfPhrasesContainsSpecifiedList() throws ClassNotFoundException {
        var x = new Board();
        var testTableOfPhrases =  List.of(new String[]{
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
                x.getTableOfPhrases(),
                "Table of Phrases is not empty"
        );
        Assert.isInstanceOf(
                List.class,
                x.getTableOfPhrases(),
                "Table of Phrases is not a List"
        );
        Assert.isTrue(
                x.getTableOfPhrases().equals(testTableOfPhrases),
                "Table of Phrases is not set to specified list"
        );
    }

    @Test
    void TestConfirmCheckLetterMethodExists() throws ClassNotFoundException {
        var x = Class.forName("org.example.wheeloffortune.Board");
        try {
            x.getMethod("checkLetter", Character.TYPE);
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
            Assert.state(false,"Check Letter method does not exist");
        }
    }

    @Test
    void TestConfirmRevealLetterMethodExists() throws ClassNotFoundException {
        var x = Class.forName("org.example.wheeloffortune.Board");
        try {
            x.getMethod("revealLetter", Character.TYPE);
        } catch (NoSuchMethodException e) {
            Assert.state(false,"Reveal Letter method does not exist");
        }
    }

    @Test
    void TestConfirmCheckPhraseMethodExists() throws ClassNotFoundException {
        var x = Class.forName("org.example.wheeloffortune.Board");
        try {
            x.getMethod("checkPhrase");
        } catch (NoSuchMethodException e) {
            Assert.state(false,"Check Phrase method does not exist");
        }
    }

    @Test
    void TestConfirmGeneratePhraseMethodExists() throws ClassNotFoundException {
        var x = Class.forName("org.example.wheeloffortune.Board");
        try {
            x.getMethod("generatePhrase");
        } catch (NoSuchMethodException e) {
            Assert.state(false,"Check Generate Phrase method does not exist");
        }
    }
}
