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
        // 1. 상품 찾기
        Store store = storeRepository.findbyId(id);
        // 2. 없으면 예외
        if (store == null)
            throw new RuntimeException("상품이 존재하지 않습니다.");
        // 3. 있으면 삭제
        else
            storeRepository.delete(id); // write(DML : Insert, Update, Delete)
    }

    public Store 상품수정화면(int id) {
        return storeRepository.findbyId(id);
    }

    @Transactional
    public void 상품수정(int id, String name, int stock, int price) {
        // 1. 상품 찾기
        Store store = storeRepository.findbyId(id);
        // 2. 없으면 예외
        if (store == null)
            throw new RuntimeException("상품이 존재하지 않습니다.");
        // 3. 있으면 삭제
        else
            storeRepository.update(id, name, stock, price);
    }
}
