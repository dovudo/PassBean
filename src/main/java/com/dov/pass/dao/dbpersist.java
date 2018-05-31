package com.dov.pass.dao;

import com.dov.pass.service.employee;

public interface dbpersist {

    public void save(employee em);

    public employee getByLogin(String login);

    public employee getById(int Id);
}
