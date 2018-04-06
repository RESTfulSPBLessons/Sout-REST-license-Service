package com.antonromanov.firstcrud.firstcrud.Services;

import com.antonromanov.firstcrud.firstcrud.model.License;


import java.util.List;

public interface LicenseService {

    Iterable<License> listAllEmployees();

    public Iterable<License> getAllbySerialFiltered(String serial);
    public Boolean serialExistsCheck(String serial);


}
