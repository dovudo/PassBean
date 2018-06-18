package com.dov.pass.dao;

public interface unitInterface {

    void save(Unit u);
    Unit getById(int id);
    Unit getByEmail(String email) throws Exception;
}
