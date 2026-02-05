package org.example.wheeloffortune;

import java.util.List;

public class Board {
    public List<String> players;
    private String phrase;

    void setPhrase(String s){
        this.phrase = s;
    }
    String getPhrase(){
        return this.phrase;
    }
}
