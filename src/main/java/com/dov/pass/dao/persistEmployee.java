package com.dov.pass.dao;

import com.dov.pass.service.employee;

public interface persistEmployee {

    public void save(employee em);

    public employee getByLogin(String login);

    public employee getById(int Id);
}
