package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

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
    void TestNameVariableExists(){
        Assert.state((new Board().name = "").isEmpty(), "Board name variable does not exist");
    }
}
