package org.example.wheeloffortune;

public class Player {
    public String name;
    public Integer currentPoints;

    /**
     * When the player picks a letter:
     * Call Board.checkLetter() wich performs the following:
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

    public boolean guessThePhrase(String phrase) {
        return true;
    }

    public void startGame() {

    }

    public void startAgain() {

    }

    public void giveUp() {
        
    }
}
