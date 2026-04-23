package org.example.wheeloffortune;

import java.util.HashSet;
import java.util.List;
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

    public boolean checkLetter(char c) {
        return phrase.contains(String.valueOf(c));
    }

    public void revealLetter(char c) {
        Set<Character> mutableGuessedLetters = new HashSet<>(this.guessedLetters);
        mutableGuessedLetters.add(c);
        this.guessedLetters = mutableGuessedLetters;
    }

    public boolean checkPhrase() {
        return true;
    }

    public String generatePhrase() {
        final int randomIndex = RandomGenerator.getDefault().nextInt(tableOfPhrases.size());
        phrase = tableOfPhrases.get(randomIndex);
        return phrase;
    }

    private String anonymisePhrase() {
        return "";
    }

    void setPhrase(String s) {
        this.phrase = s;
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
