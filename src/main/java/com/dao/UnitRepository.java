package com.dao;

import com.Model.Unit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepository extends CrudRepository<Unit,Long> {

//  @Query("select b from Unit where Unit.token = b")
    Unit findByToken(String token);
    Unit findByEmail(String email);
    Iterable<Unit> findAll();

}
