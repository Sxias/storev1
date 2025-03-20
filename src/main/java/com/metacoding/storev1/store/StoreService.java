package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {

    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Transactional
    public void 상품등록(String name, int stock, int price) {
        storeRepository.save(name, stock, price);
    }

    public List<Store> 상품목록() {
        return storeRepository.findAll();
    }

    public Store 상세보기(int id) {
        return storeRepository.findbyId(id);
    }

    @Transactional
    public void 상품삭제(int id) {
        storeRepository.delete(id);
    }

    public Store 상품수정화면(int id) {
        return storeRepository.findbyId(id);
    }

    @Transactional
    public void 상품수정(int id, String name, int stock, int price) {
        storeRepository.update(id, name, stock, price);
    }
}
