package org.example.wheeloffortune;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @GetMapping("/")
    public String openGame() {
        String response = "Default response from Wheel of Fortune";
        return response;
    }
}
