package com.antonromanov.firstcrud.firstcrud.Services;

import com.antonromanov.firstcrud.firstcrud.model.License;


import java.util.List;

public interface LicenseService {

    Iterable<License> listAllEmployees();

    public List<License> getAllbySerialFiltered(String serial);

}
