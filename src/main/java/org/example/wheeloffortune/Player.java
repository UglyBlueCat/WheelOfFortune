package org.example.wheeloffortune;

import java.util.HashSet;
import java.util.Set;

public class Player {
    public String name;
    public Integer currentPoints;

    /**
     * When the player picks a letter:
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
        Set<Character> mutableGuessedLetters = new HashSet<>(board.getGuessedLetters());
        mutableGuessedLetters.add(c);
        board.setGuessedLetters(mutableGuessedLetters);

        boolean letterExistsInPhrase = board.checkLetter(c);

        return letterExistsInPhrase;
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
