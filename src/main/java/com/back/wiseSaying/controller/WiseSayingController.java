package com.back.wiseSaying.controller;

import com.back.AppContext;
import com.back.Rq;
import com.back.WiseSaying;
import com.back.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc = AppContext.sc;
    private final WiseSayingService wiseSayingService = AppContext.wiseSayingService;

    public void cmdAdd() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        int num = wiseSayingService.add(author, content);
        System.out.println(num + "번 명언이 등록되었습니다.");
    }

    public void cmdUpdate(Rq rq) {
        int id;

        try {
            id = Integer.parseInt(rq.getParam("id"));
        } catch (Exception e) {
            System.out.println("ID를 올바르게 입력해주세요.");
            return;
        }

        WiseSaying ws = wiseSayingService.findById(id);
        if (ws == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + ws.getContent());
        System.out.print("명언 : ");
        String author = sc.nextLine().trim();
        System.out.println("작가(기존) : " + ws.getAuthor());
        System.out.print("작가 : ");
        String content = sc.nextLine().trim();

        wiseSayingService.update(ws, author, content);
    }

    public void cmdRemove(Rq rq) {
        int id;

        try {
            id = Integer.parseInt(rq.getParam("id"));
        } catch (Exception e) {
            System.out.println("ID를 올바르게 입력해주세요.");
            return;
        }

        if (!wiseSayingService.remove(id)) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    public void cmdList(Rq rq) {
        List<WiseSaying> list;

        list = wiseSayingService.list();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(WiseSaying ws : list) {
            System.out.printf("%d / %s / %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
        }
    }
}
