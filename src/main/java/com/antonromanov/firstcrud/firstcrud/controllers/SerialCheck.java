package com.antonromanov.firstcrud.firstcrud.controllers;
// This Project created by Anton Romanov (www.antonromanov.com) 26.03.2018 at 17:30
// Source URL - ...
// Git Hub repo - ...


import com.antonromanov.firstcrud.firstcrud.Services.LicenseService;
import com.antonromanov.firstcrud.firstcrud.model.License;
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
        public List<License> newRequest(){
         //   public ResponseEntity<List<License>> getAllArticles(){
          //  return licenseService.failedInSub();

                    return licenseRepository.getAll();


    }

    // http://localhost:8080/rest/check?serial=1


   // @GetMapping("/check")
     @RequestMapping(value = "check", method = RequestMethod.GET)
   // public List<License> CheckSerial(@RequestParam("serial") String id) {
     //public Map<String,Boolean> CheckSerial(@RequestParam("serial") String id) {
     public Map<String,String> CheckSerial(@RequestParam("serial") String id) {

         Map<String,Boolean> result_old = new HashMap<>();
         Map<String,String> result = new HashMap<>();
         Map<String, Object> result_old_2 = new HashMap<String, Object>();

      licenseService.getAllbySerialFiltered("4");


         if (!(licenseRepository.SerialCheck(id).isEmpty())) {

    /*            System.out.println("Зашли");

             for (License element : licenseRepository.SerialCheck(id)) {
                 System.out.println(element.getSerial());

                 String content = element.getSerial();
                 try{

                     Files.write(Paths.get("d:\\output.txt"), content.getBytes());

                 } catch (IOException e){
                     e.printStackTrace();
                 }


             }
*/

             if ((licenseRepository.getAllbySerial(id)) != null) {

                 result.put("Message", "Ok");
                 result.put("do_exit", "false");

             } else {

               //  result.put("Ваша лицензия истекла!", true);
                 result.put("Message", "Ваша лицензия истекла!");
                 result.put("do_exit", "true");

             }
         } else {

             //result.put("Нет пользователя с таким серийным номером", true);
             result.put("Message", "Нет пользователя с таким серийным номером!");
             result.put("do_exit", "true");

         }
         //return licenseRepository.getAllbySerial(id);

       //  return licenseService.getAllbySerialFiltered("1");

         return result;

         //System.out.println("id:"+ id);
       //  return "success";


    }




}
