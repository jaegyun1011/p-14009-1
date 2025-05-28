package com.back;

public class WiseSaying {
    private int id;
    private String content;
    private String author;

    WiseSaying(int id, String content, String author) {
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

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
