package org.example.wheeloffortune;

import org.springframework.beans.factory.annotation.Autowired;

public class Player {
    public String name;
    public Integer currentPoints;

    @Autowired
    public Board board;

    /**
     * When the player picks a letter:
     * Call Board.checkLetter() which performs the following:
     * <ul>
     *     <li>Add the letter to guessed letters</li>
     *     <li>Check the letter exists in the phrase</li>
     * </ul>
     *
     * if so:
     * <ul>
     *     <li>Anonymise the phrase</li>
     * </ul>
     *
     * @param c The letter chosen by the player
     * @return A boolean indicating presence of the chosen letter in the phrase
     */
    public boolean pickALetter(Board board, char c) {
        return board.checkLetter(c);
    }

    public boolean guessThePhrase(Board board, String phrase) {
        return board.checkPhrase(phrase);
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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}
