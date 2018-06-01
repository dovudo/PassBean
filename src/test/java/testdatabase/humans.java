package testdatabase;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Transactional
@Repository("human")
public class humans implements humanInterface  {

    private final static Logger loger = LoggerFactory.getLogger("humans");

    @PersistenceContext
    EntityManager em;

    public void save(human h){
        loger.info("Keep saving by " + this.getClass());
        em.persist(h);
    }
}
