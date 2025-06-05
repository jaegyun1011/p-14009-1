package com.back.system.controller;

public class SystemController {
    public void title() {
        System.out.println("== 명언 앱 ==");
    }

    public void input() {
        System.out.print("명령) ");
    }

    public void cmdExit() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void cmdWrong() {
        System.out.println("잘못된 명령어입니다.");
    }
}
