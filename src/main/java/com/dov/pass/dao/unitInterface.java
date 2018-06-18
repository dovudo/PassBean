package com.dov.pass.dao;

public interface unitInterface {

    void save(Unit u);
    Unit getById(int id);
    Unit getByEmail(String email) throws Exception;
    boolean checkExistByEmail(String email);
    boolean checkExistByHash(String hash);
    Unit getEntityByHash(String hash);

}
