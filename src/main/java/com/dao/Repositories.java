package com.dao;

import com.Model.Unit;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



@Transactional
@Repository("Unit")
public class Repositories implements RepositoryInterface {

    @PersistenceContext
    private EntityManager em;

    public void save(Unit unit){
        try{
            em.merge(unit);
        }
        catch (IllegalArgumentException e){
            em.persist(unit);
        }
    }

    public Unit findAll(){
        return null;
    }

    @Override
    public Unit findByToken(String token){
        return em.getReference(Unit.class, Long.getLong(token));
    }
}

