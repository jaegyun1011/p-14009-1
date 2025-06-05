package com.back;

import com.back.system.controller.SystemController;
import com.back.wiseSaying.controller.WiseSayingController;
import com.back.wiseSaying.repository.WiseSayingRepository;
import com.back.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class AppContext {
    public static final Scanner sc;
    public static final SystemController systemController;
    public static final WiseSayingController wiseSayingController;
    public static final WiseSayingService wiseSayingService;
    public static final WiseSayingRepository wiseSayingRepository;

    static {
        sc = new Scanner(System.in);
        systemController = new SystemController();
        wiseSayingRepository = new WiseSayingRepository();
        wiseSayingService = new WiseSayingService();
        wiseSayingController = new WiseSayingController();
    }
}
