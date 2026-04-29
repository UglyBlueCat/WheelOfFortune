package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class APIControllerTests {

    @Test
    void ClassAPIControllerExists() {
        try {
            Class<?> player = Class.forName("org.example.wheeloffortune.APIController");
        } catch (ClassNotFoundException cnfe) {
            Assert.state(
                    false,
                    "APIController class does not exist"
            );
        }
    }
}
