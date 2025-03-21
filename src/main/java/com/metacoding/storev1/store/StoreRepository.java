package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class StoreRepository {

    private EntityManager em;

    public StoreRepository(EntityManager em) {
        this.em = em;
    }

    public void save(String name, int stock, int price) {
        Query query = em.createNativeQuery("insert into store_tb(name, stock, price) values (?, ?, ?)");
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.executeUpdate();
    }

    public List<Store> findAll() {
        // 조건 : @Entity가 붙어있어야 가능 (디폴트 생성자 호출)
        // Setter를 만들지 않아도 대입되는 이유 : Reflection
        Query query = em.createNativeQuery("select * from store_tb order by id desc", Store.class);
        return query.getResultList();
    }

    public Store findbyId(int id) {
        Query query = em.createNativeQuery("select * from store_tb where id = ? order by id desc", Store.class);
        query.setParameter(1, id);
        // return : Object 객체 >> Downcasting 필요
        try {
            return (Store) query.getSingleResult();
        } catch (Exception e) { // NoResultException
            return null;
        }
    }

    public void delete(int id) {
        Query query = em.createNativeQuery("delete from store_tb where id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public void update(int id, String name, int stock, int price) {
        Query query = em.createNativeQuery("update store_tb set name = ?, stock = ?, price = ? where id = ?");
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.setParameter(4, id);
        query.executeUpdate();
    }
}
