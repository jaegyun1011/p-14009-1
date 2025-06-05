package com.back.wiseSaying.repository;

import com.back.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WiseSayingRepository {
    private final List<WiseSaying> db = new ArrayList<>();
    private int lastId = 0;

    public int create(String author, String content) {
        db.add(new WiseSaying(++lastId, author, content));
        return lastId;
    }

    public List<WiseSaying> read() {
        return db.reversed();
    }

    public void update(WiseSaying ws, String author, String content) {
        ws.setAuthor(author);
        ws.setContent(content);
    }

    public boolean delete(int id) {
        int idx = convertIdx(id);

        if(idx == -1)
            return false;

        db.remove(idx);
        return true;
    }

    public WiseSaying findById(int id) {
        return db.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private int convertIdx(int id) {
        return IntStream.range(0, db.size())
                .filter(i -> db.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }
}
