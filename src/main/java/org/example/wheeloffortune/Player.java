package org.example.wheeloffortune;

public class Player {
    public String name;
    public Integer currentPoints;

    public boolean pickALetter(char c) {
        return true;
    }

    public boolean guessThePhrase(String phrase) {
        return true;
    }

    public void startGame() {

    }

    public void startAgain() {

    }

    public void giveUp() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(Integer currentPoints) {
        this.currentPoints = currentPoints;
    }
}
