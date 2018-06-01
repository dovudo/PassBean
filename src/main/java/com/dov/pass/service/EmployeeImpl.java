package com.dov.pass.service;

import com.dov.pass.dao.persistEmployee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository("employee")
public class EmployeeImpl implements persistEmployee {
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
