package com.antonromanov.firstcrud.firstcrud.controllers;
// This Project created by Anton Romanov (www.antonromanov.com) 26.03.2018 at 17:30
// Source URL - ...
// Git Hub repo - ...


import com.antonromanov.firstcrud.firstcrud.Services.LicenseService;
import com.antonromanov.firstcrud.firstcrud.model.License;
import com.antonromanov.firstcrud.firstcrud.model.Response;
import com.antonromanov.firstcrud.firstcrud.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//   @GetMapping("/get")

    @GetMapping("/rest")
    //  @RequestMapping(value = "user/", method = RequestMethod.GET)
    public List<License> newRequest() {
        //   public ResponseEntity<List<License>> getAllArticles(){
        //  return licenseService.failedInSub();

        return licenseRepository.getAll();


    }

    // http://localhost:8080/rest/check?serial=1


    // @GetMapping("/check")
    @RequestMapping(value = "check", method = RequestMethod.GET)
    //public Map<String, String> CheckSerial(@RequestParam("serial") String id) {
    public ResponseEntity<?> CheckSerial(@RequestParam("serial") String id) {

   //    Map<String, String> result = new HashMap<>();

        Response response = new Response();


        if (licenseService.serialExistsCheck(id)) {

            System.out.println("Проверили serial    ");

            if ((licenseService.getAllbySerialFiltered(id)) != null) {


                //result.put("Message", "Ok");
                //result.put("do_exit", "false");

                response.setMessage("Ok");
                response.setDoExit(false);




            } else {

                //  result.put("Ваша лицензия истекла!", true);
              //  result.put("Message", "Ваша лицензия истекла!");
              //  result.put("do_exit", "true");

                response.setMessage("Ваша лицензия истекла!");
                response.setDoExit(true);


            }
        } else {


          //  result.put("Message", "Нет пользователя с таким серийным номером!");
          //  result.put("do_exit", "true");

            response.setMessage("Нет пользователя с таким серийным номером!");
            response.setDoExit(true);

        }

        return ResponseEntity.ok(response);

    }


}
