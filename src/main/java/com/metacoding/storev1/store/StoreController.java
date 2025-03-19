package com.metacoding.storev1.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // IoC (Inversion of Control) -> hashset
public class StoreController {

    @GetMapping("/")
    public String list() {
        // 1. 조회

        // 2. req에 담기

        // 3. 이동
        return "store/list";
    }

    @GetMapping("/store/{id}")
    public String detail(@PathVariable("id") int id) {
        // 1. 조회

        // 2. req에 담기

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
    public String save() {
        // 1. 저장

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
