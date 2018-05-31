package com.dov.pass.service;

import com.dov.pass.dao.dbpersist;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class dbImpl implements dbpersist {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(employee empl) {
        em.persist(empl);
    }

    @Override
    public employee getByLogin(String login) {
        return null;
    }

    @Override
    public employee getById(int Id) {
        return null;
    }
}
