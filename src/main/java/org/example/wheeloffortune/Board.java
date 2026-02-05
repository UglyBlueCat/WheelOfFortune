package org.example.wheeloffortune;

import java.util.List;

public class Board {
    public List<String> players;
    private String phrase;
    private char[] anonymisedPhrase;

    void setPhrase(String s){
        this.phrase = s;
    }

    void setAnonymisedPhrase(char[] c){
        this.anonymisedPhrase = c;
    }

    String getPhrase(){
        return this.phrase;
    }

    public char[] getAnonymisedPhrase() {
        return this.anonymisedPhrase;
    }
}
