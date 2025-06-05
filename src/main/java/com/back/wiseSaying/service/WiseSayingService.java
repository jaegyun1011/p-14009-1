package com.back.wiseSaying.service;

import com.back.AppContext;
import com.back.WiseSaying;
import com.back.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository = AppContext.wiseSayingRepository;

    public int add(String author, String content) {
        return wiseSayingRepository.create(author, content);
    }

    public boolean remove(int id) {
        return wiseSayingRepository.delete(id);
    }

    public void update(WiseSaying ws, String author, String content) {
        wiseSayingRepository.update(ws, author, content);
    }

    public List<WiseSaying> list() {
        return wiseSayingRepository.read();
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }
}
