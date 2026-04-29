package org.example.wheeloffortune;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.util.Assert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class APIControllerTests {

    @Autowired
    private APIController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private RestTestClient restTestClient;

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

    @Test
    void APIHasRootEndpoint() {
        assertThat(controller).isNotNull();
        restTestClient.get()
                .uri("http://localhost:%d/".formatted(port))
                .exchange()
                .expectBody(String.class)
                .isEqualTo("Default response from Wheel of Fortune");
    }
}
