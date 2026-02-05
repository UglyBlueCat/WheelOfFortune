package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

@SpringBootTest
public class BoardClassTests {

    @Test
    void TestPlayerClassExists(){
        try {
            Class.forName("org.example.wheeloffortune.Board");
        } catch (ClassNotFoundException cnfe) {
            Assert.state(false, "Board Class does not exist");
        }
    }

    @Test
    void TestPlayersVariableExists(){
        Assert.state((new Board().players = new ArrayList<>()).isEmpty(), "Board variable name does not exist");
    }

    @Test
    void TestPhraseVariableExists(){
        var x = new Board();
        x.setPhrase("");
        Assert.state((x.getPhrase().isEmpty()), "Phrase variable exists");
    }

    @Test
    void TestAnonymisedPhraseExists(){
        var x = new Board();
        char c = 'a';
        x.setAnonymisedPhrase(new char[]{c});
        System.out.print(c);
        System.out.print(x.getAnonymisedPhrase());
        Assert.state(Arrays.equals(x.getAnonymisedPhrase(), new char[]{c}),"Anonymised phrase variable exists");
    }

    @Test
    void TestGuessedLettersVariableExists(){
        var x = new Board();
        var s = Set.of('a');
        x.setGuessedLetters(s);
        Assert.state(x.getGuessedLetters().equals(s),"Guessed letters variable exists");
    }
}
