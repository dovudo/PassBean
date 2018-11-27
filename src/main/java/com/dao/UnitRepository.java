package com.dao;

import com.Model.Unit;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepository extends CrudRepository<Unit,Long> {

    Unit findByToken(String token);
    Unit findByEmail(String email);
    Iterable<Unit> findAll();

}
