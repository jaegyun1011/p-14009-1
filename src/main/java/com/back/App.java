package com.back;

import com.back.system.controller.SystemController;
import com.back.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner sc = AppContext.sc;
    private final SystemController systemController = AppContext.systemController;
    private final WiseSayingController wiseSayingController = AppContext.wiseSayingController;

    public void run() {
        boolean exit = false;

        systemController.title();
        while(!exit) {
            systemController.input();
            Rq rq = new Rq(sc.nextLine().trim());

            switch(rq.getCmd()) {
                case "등록" -> wiseSayingController.cmdAdd();
                case "삭제" -> wiseSayingController.cmdRemove(rq);
                case "수정" -> wiseSayingController.cmdUpdate(rq);
                case "목록" -> wiseSayingController.cmdList(rq);
                case "종료" -> {
                    systemController.cmdExit();
                    exit = true;
                }
                default -> systemController.cmdWrong();
            }
        }
    }
}
