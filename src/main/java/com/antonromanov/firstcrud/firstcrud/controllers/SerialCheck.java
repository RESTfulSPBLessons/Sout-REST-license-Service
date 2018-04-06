package com.antonromanov.firstcrud.firstcrud.controllers;
// This Project created by Anton Romanov (www.antonromanov.com) 26.03.2018 at 17:30
// Git Hub repo - https://github.com/RESTfulSPBLessons/Sout-REST-license-Service/tree/tomcat-version
// http://192.168.1.40:8080/license/rest/check?serial=1

import com.antonromanov.firstcrud.firstcrud.Services.LicenseService;
import com.antonromanov.firstcrud.firstcrud.model.Response;
import com.antonromanov.firstcrud.firstcrud.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class SerialCheck {

    LicenseService licenseService;

    @Autowired
    LicenseRepository licenseRepository;


    @Autowired
    public void setUserService(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @RequestMapping(value = "check", method = RequestMethod.GET)
    public ResponseEntity<?> CheckSerial(@RequestParam("serial") String id) {

        Response response = new Response();

        if (licenseService.serialExistsCheck(id)) {
            if ((licenseService.getAllbySerialFiltered(id)) != null) {
                response.setMessage("Ok");
                response.setDoExit(false);
            } else {
                response.setMessage("Ваша лицензия истекла!");
                response.setDoExit(true);
            }
        } else {
            response.setMessage("Нет пользователя с таким серийным номером!");
            response.setDoExit(true);
        }

        return ResponseEntity.ok(response);
    }
}
