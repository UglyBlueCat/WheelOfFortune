package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;

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
}
