package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner scanner;
    private List<WiseSaying> db;
    private int num;

    App() {
        scanner = new Scanner(System.in);
        db = new ArrayList<>();
        db.add(new WiseSaying(0, "", ""));
        num = 0;
    }

    public void run() {
        boolean exit = false;

        System.out.println("== 명언 앱 ==");
        while(!exit) {
            System.out.print("명령) ");
            Rq rq = new Rq(scanner.nextLine().trim());
            //String cmd = input.split("\\?")[0];
            //String[] param = input.contains("?") ? input.split("\\?")[1].split("&") : new String[]{};

            switch(rq.getCmd()) {
                case "등록" -> cmdAdd();
                case "삭제" -> cmdRemove(rq);
                case "수정" -> cmdUpdate(rq);
                case "목록" -> cmdList(rq);
                case "종료" -> exit = true;
                default -> System.out.println("잘못된 명령어입니다.");
            }
        }

        scanner.close();
    }

    private void cmdAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();
        db.add(new WiseSaying(++num, content, author));
        System.out.println(num + "번 명언이 등록되었습니다.");
    }

    private void cmdUpdate(Rq rq) {
        int id;

        try {
            id = Integer.parseInt(rq.getParam("id"));
        } catch (Exception e) {
            System.out.println("ID를 올바르게 입력해주세요.");
            return;
        }

        if (id > num || db.get(id).getId() == -1) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + db.get(id).getContent());
        System.out.print("명언 : ");
        String input = scanner.nextLine().trim();
        db.get(id).setContent(input);

        System.out.println("작가(기존) : " + db.get(id).getAuthor());
        System.out.print("작가 : ");
        input = scanner.nextLine().trim();
        db.get(id).setAuthor(input);
    }

    private void cmdRemove(Rq rq) {
        int id;

        try {
            id = Integer.parseInt(rq.getParam("id"));
        } catch (Exception e) {
            System.out.println("ID를 올바르게 입력해주세요.");
            return;
        }

        if (id > num || db.get(id).getId() == -1) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        db.get(id).setId(-1);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    private void cmdList(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i=num; i>0; i--) {
            if(db.get(i).getId() == -1)
                continue;
            System.out.printf("%d / %s / %s\n", db.get(i).getId(), db.get(i).getAuthor(), db.get(i).getContent());
        }
    }
}
