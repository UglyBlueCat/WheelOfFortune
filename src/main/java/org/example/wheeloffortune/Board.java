package org.example.wheeloffortune;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.random.RandomGenerator;

public class Board {
    public List<String> players;
    private String phrase;
    private char[] anonymisedPhrase;
    private Set<Character> guessedLetters;
    private final List<String> tableOfPhrases = List.of(new String[]{
            "A Blessing in Disguise",
            "Best Seat in the House",
            "Once in a Blue Moon",
            "Right Place at the Right Time",
            "The Early Bird Gets the Worm",
            "A Piece of Cake",
            "Living the Dream",
            "Back to the Drawing Board",
            "A Breath of Fresh Air",
            "Making Memories Together"
    });

    /**
     * <ul><li>Add the letter to guessed letters</li>
     * <li>Check the letter exists in the phrase</li></ul>
     * if so:
     * <ul><li>anonymise the phrase</li></ul>
     * @param c A character denoting the letter chosen by the player
     * @return A boolean indicating presence of the chosen letter in the phrase
     */
    public boolean checkLetter(char c) {
        Set<Character> guessedLetters = this.getGuessedLetters();
        if (guessedLetters == null || guessedLetters.isEmpty()) {
            this.setGuessedLetters(Set.of(c));
        } else {
            Set<Character> mutableGuessedLetters = new HashSet<>(guessedLetters);
            mutableGuessedLetters.add(c);
            this.setGuessedLetters(mutableGuessedLetters);
        }

        final boolean letterExists = this.phrase.contains(String.valueOf(c));
        if (letterExists) this.anonymisePhrase();
        return letterExists;
    }

    public void revealLetter(char c) {

    }

    /**
     * Compare the phrase guessed by the player with the correct phrase
     * @param guessedPhrase A string containing the phrase guessed by the player
     * @return A boolean confirming correctness of the guessed phrase
     */
    public boolean checkPhrase(String guessedPhrase) {
        return guessedPhrase.equals(phrase);
    }

    public String generatePhrase() {
        final int randomIndex = RandomGenerator.getDefault().nextInt(tableOfPhrases.size());
        phrase = tableOfPhrases.get(randomIndex);
        return phrase;
    }

    /**
     * Obfuscate all the letters in the phrase except for those already guessed
     * @return A string containing the anonymised phrase
     */
    private String anonymisePhrase() {
        final int phraseLength = phrase.length();
        char[] localAnonymisedPhrase = new char[phraseLength];

        for (int i = 0; i < phraseLength; i++) {
            final char currentChar = phrase.charAt(i);
            localAnonymisedPhrase[i] = currentChar == ' ' || guessedLetters.contains(currentChar) ? currentChar : '*';
        }

        anonymisedPhrase = localAnonymisedPhrase;
        return Arrays.toString(localAnonymisedPhrase);
    }

    public void setupBoard() {
        this.generatePhrase();
    }

    void setPhrase(String s) {
        this.phrase = s;
    }

    /**
     * Ends the game
     * <ul><li>Clears the board</li>
     * <li>Resets guessed letters</li></ul>
     */
    public void endGame() {
        this.setGuessedLetters(Set.of());
        this.setPhrase("");
        this.anonymisePhrase();
    }

    void setAnonymisedPhrase(char[] c) {
        this.anonymisedPhrase = c;
    }

    void setGuessedLetters(Set<Character> s) {
        this.guessedLetters = s;
    }

    String getPhrase() {
        return this.phrase;
    }

    public char[] getAnonymisedPhrase() {
        return this.anonymisedPhrase;
    }

    public Set<Character> getGuessedLetters() {
        return this.guessedLetters;
    }

    public List<String> getTableOfPhrases() {
        return this.tableOfPhrases;
    }
}
