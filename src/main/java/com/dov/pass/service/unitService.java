package com.dov.pass.service;

import com.dov.pass.dao.Unit;
import com.dov.pass.dao.unitInterface;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Transactional
@Repository("Unit")
public class unitService implements unitInterface {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Unit u) {
        em.persist(u);
    }

    @Override
    public Unit getById(int id) {
        return em.find(Unit.class, id);
    }

    @Override
    public Unit getByEmail(String email) {
        return em.find(Unit.class, email);
    }
}
