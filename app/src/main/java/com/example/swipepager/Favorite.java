package com.example.swipepager;

public class Favorite {
    private int id;
    private int wordId;

    public Favorite(int id, int wordId) {
        this.id = id;
        this.wordId = wordId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }
}
