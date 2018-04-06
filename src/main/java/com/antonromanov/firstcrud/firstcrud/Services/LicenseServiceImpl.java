package com.antonromanov.firstcrud.firstcrud.Services;
// This Project created by Anton Romanov (www.antonromanov.com) 27.02.2018 at 18:22
// Source URL - https://github.com/Zianwar/springboot-crud-demo/blob/master/src/main/java/com/ensat/services/ProductServiceImpl.java
// Git Hub repo - https://github.com/RESTfulSPBLessons/Sout-REST-license-Service/tree/tomcat-version
// http://192.168.1.40:8080/license/rest/check?serial=1

import com.antonromanov.firstcrud.firstcrud.model.License;
import com.antonromanov.firstcrud.firstcrud.repositories.LicenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Service
public class LicenseServiceImpl implements LicenseService {

    private LicenseRepository licenseRepository;

    @Autowired
    public void setProductRepository(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    @Override
    public Iterable<License> listAllEmployees() {
        return licenseRepository.findAll();
    }

    @Override
    public Boolean serialExistsCheck(String serial) {

        Iterable<License> values = licenseRepository.getAllbySerial2(serial);
        long size = values.spliterator().getExactSizeIfKnown();

        System.out.println("[ktw = " + size);

        if (size == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Iterable<License> getAllbySerialFiltered(String serial) {

        if (DateCompare(licenseRepository.getAllbySerial3(serial).get(0).getExpirationDate())) {
            return licenseRepository.getAllbySerial3(serial);
        } else {
            return null;
        }
    }

    private boolean DateCompare(Date date) {

        Date today = new Date();
        Boolean result = false;

        if (today.compareTo(date) > 0) {
            result = false;
        } else if (today.compareTo(date) < 0) {
            result = true;
        } else if (today.compareTo(date) == 0) {
            result = false;
        }
        return result;
    }
}
