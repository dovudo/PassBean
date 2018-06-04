package com.dov.pass.dao;

public interface persistEmployee {

    void save(employee em);

    employee getByLogin(String login);

    employee getById(int Id);
}
