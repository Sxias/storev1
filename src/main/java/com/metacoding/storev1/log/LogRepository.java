package com.metacoding.storev1.log;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class LogRepository {

    private EntityManager em;

    public LogRepository(EntityManager em) {
        this.em = em;
    }

    public List<Log> findAll() {
        Query query = em.createNativeQuery(
                "select * from log_tb order by id desc", Log.class);
        return query.getResultList();
    }

}
