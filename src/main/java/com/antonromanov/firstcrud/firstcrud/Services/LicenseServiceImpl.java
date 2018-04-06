package com.antonromanov.firstcrud.firstcrud.Services;
// This Project created by Anton Romanov (www.antonromanov.com) 27.02.2018 at 18:22
// Source URL - https://github.com/Zianwar/springboot-crud-demo/blob/master/src/main/java/com/ensat/services/ProductServiceImpl.java


import com.antonromanov.firstcrud.firstcrud.model.License;
import com.antonromanov.firstcrud.firstcrud.repositories.LicenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Product service implement.
 */
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
    public List<License>  getAllbySerialFiltered(String serial){

        List<License> persons = new ArrayList<>();

        //licenseRepository.getAllSerials2("4");


        for(License lic: licenseRepository.getAllSerials2("4")) {
            //       persons.add(new License("1", lic.getLicenseNumber(), 1));
            //
             System.out.println(lic.getSerial());  // Will invoke overrided `toString()` method
               }


 //   filter();

        return persons;
    }

    public void  filter(){
        List<License> persons = new ArrayList<>();

        persons.add(new License("1","FUCK", 1));
        persons.add(new License("2","Tfkmncv", 1));

      //  for(License lic: licenseRepository.getAllbySerial()) {
      //       persons.add(new License("1", lic.getLicenseNumber(), 1));
            //
            // System.out.println(lic.getLicenseNumber());  // Will invoke overrided `toString()` method
     //   }


        //persons.addAll((Collection<? extends License>) licenseRepository.getAllbySerial());

        List<License> resultLic = persons.stream()                // convert list to stream
                .filter(line -> "1".equals(line.getSerial()))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List


        System.out.println(resultLic);
        resultLic.stream().forEach(System.out::println);

        for(License student: resultLic) {
            System.out.println(student.getLicenseNumber());  // Will invoke overrided `toString()` method
        }



    }



}
