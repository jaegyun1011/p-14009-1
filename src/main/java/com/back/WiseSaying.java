package com.back;

public class WiseSaying {
    private int id;
    private String content;
    private String author;

    public WiseSaying(int id, String author, String content) {
        setId(id);
        setContent(content);
        setAuthor(author);
    }

    public int getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
