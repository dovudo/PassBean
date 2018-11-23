package com.dao;

import com.Model.Unit;

public interface RepositoryInterface {

    void save(Unit unit);
    Unit findAll();
    Unit findByToken(String token);
}
