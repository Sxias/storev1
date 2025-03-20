package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller // IoC (Inversion of Control) -> hashset
public class StoreController {

    private StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/") // mvc pattern
    public String list(HttpServletRequest request) {
        // 1. 조회
        List<Store> storeList = storeService.상품목록();
        // 2. req에 담기
        request.setAttribute("models", storeList);
        // 3. 이동
        return "store/list";
    }

    @GetMapping("/store/{id}")
    public String detail(@PathVariable("id") int id, HttpServletRequest request) {
        // 1. 조회
        Store store = storeService.상세보기(id);
        // 2. req에 담기
        request.setAttribute("model", store);
        // 3. 이동
        return "store/detail";
    }

    @GetMapping("/store/save-form")
    public String saveForm() {
        return "store/save-form";
    }

    @GetMapping("/store/{id}/update-form")
    public String updateForm(@PathVariable("id") int id) {
        // 1. 조회

        // 2. req에 담기

        // 3. 이동
        return "store/update-form";
    }

    @PostMapping("/store/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        // 1. 삭제

        // 2. 리다이렉션
        return "redirect:/";
    }

    @PostMapping("/store/save")
    public String save(@RequestParam("name") String name, @RequestParam("stock") int stock,
            @RequestParam("price") int price) {
        // 1. 저장
        // System.out.println(name + ", " + stock + ", " + price);
        storeService.상품등록(name, stock, price);
        // 2. 리다이렉션
        return "redirect:/";
    }

    @PostMapping("/store/{id}/update")
    public String update(@PathVariable("id") int id) {
        // 1. 수정

        // 2. 리다이렉션
        return "redirect:/store/" + id;
    }
}
