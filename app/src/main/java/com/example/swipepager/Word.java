package com.example.swipepager;

public class Word {

    private int wordId;
    private String name;
    private String contents;
    private String tags;

    public Word(int wordId, String name, String contents, String tags) {
        this.wordId = wordId;
        this.name = name;
        this.contents = contents;
        this.tags = tags;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
