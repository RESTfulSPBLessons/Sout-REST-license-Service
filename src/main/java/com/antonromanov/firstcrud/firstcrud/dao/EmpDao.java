package com.antonromanov.firstcrud.firstcrud.dao;

import com.antonromanov.firstcrud.firstcrud.model.License;

import java.util.List;

public interface EmpDao {


    public void hire(License license);
    public void fire(int id);
    public License getEmployeeById(int id);
    public List<License> listEmpls();






    }
