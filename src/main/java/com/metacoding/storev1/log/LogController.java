package com.metacoding.storev1.log;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LogController {

    private LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/log")
    public String list(HttpServletRequest request) {
        List<LogResponse.ListPage> logList = logService.구매목록();
        request.setAttribute("models", logList);
        return "log/list";
    }

    @PostMapping("/log/save")
    public String buy(@RequestParam("storeId") int storeId, @RequestParam("buyer") String buyer,
            @RequestParam("qty") int qty) {
        // 1. 재고 확인 및 구매 등록 (Update & Insert)
        logService.구매하기(storeId, buyer, qty);
        // 2. 리다이렉트
        return "redirect:/log";
    }

}
