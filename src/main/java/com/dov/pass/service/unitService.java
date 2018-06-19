package com.dov.pass.service;

import com.dov.pass.dao.Unit;
import com.dov.pass.dao.unitInterface;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
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
        try {
            return (Unit) em.createQuery("SELECT u FROM Unit u WHERE u.email = :findemail").setParameter("findemail", email).getSingleResult();
        }
        catch (NoResultException e){
            Unit u = new Unit();
            u.setEmail(email);
            return u;
        }
    }


    public boolean checkExistByEmail(String email){
        try{
            em.createQuery("SELECT u FROM Unit u WHERE u.email = :findemail").setParameter("findemail", email).getSingleResult();
        }
        catch(NoResultException e){
            return false;
        }
        return true;
    }

    public Unit getEntityByHash(String hash) throws NoResultException{
        return (Unit) em.createQuery("SELECT u FROM Unit u WHERE u.hash = :h").setParameter("h", hash).getSingleResult();
    }

    public boolean checkExistByHash(String hash){
        try{
            if(em.createQuery("SELECT u FROM Unit u WHERE u.hash = :h").setParameter("h", hash).getSingleResult() != null){
                return true;
            }
                    else return false;
        }
        catch (NoResultException e){
            return false;
        }
    }
}