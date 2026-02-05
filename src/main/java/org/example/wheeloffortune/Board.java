package org.example.wheeloffortune;

import java.util.List;
import java.util.Set;

public class Board {
    public List<String> players;
    private String phrase;
    private char[] anonymisedPhrase;
    private Set<Character> guessedLetters;

    void setPhrase(String s){
        this.phrase = s;
    }

    void setAnonymisedPhrase(char[] c){
        this.anonymisedPhrase = c;
    }

    void setGuessedLetters(Set<Character> s){
        this.guessedLetters = s;
    }

    String getPhrase(){
        return this.phrase;
    }

    public char[] getAnonymisedPhrase() {
        return this.anonymisedPhrase;
    }

    public Set<Character> getGuessedLetters() {
        return this.guessedLetters;
    }
}
