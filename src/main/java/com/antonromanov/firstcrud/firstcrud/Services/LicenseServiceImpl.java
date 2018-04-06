package com.antonromanov.firstcrud.firstcrud.Services;
// This Project created by Anton Romanov (www.antonromanov.com) 27.02.2018 at 18:22
// Source URL - https://github.com/Zianwar/springboot-crud-demo/blob/master/src/main/java/com/ensat/services/ProductServiceImpl.java


import com.antonromanov.firstcrud.firstcrud.model.License;
import com.antonromanov.firstcrud.firstcrud.repositories.LicenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    public Boolean serialExistsCheck(String serial){


        for (License element : licenseRepository.getAllbySerial2(serial) ) {
            System.out.println(element.getSerial() + " - " + element.getExpirationDate());
        }


        Iterable<License> values = licenseRepository.getAllbySerial2(serial);
        long size = values.spliterator().getExactSizeIfKnown();

        System.out.println("[ktw = " + size);

        if (size==0){
            return false;
        } else{

            return true;

        }


    }

    @Override
    public Iterable<License>  getAllbySerialFiltered(String serial){


        for (License element : licenseRepository.getAllbySerial3(serial) ) {
            System.out.println("СУКА =    " + element.getSerial() + " - " + element.getExpirationDate());

            System.out.println(DateCompare(element.getExpirationDate()));

        }



if (DateCompare(licenseRepository.getAllbySerial3(serial).get(0).getExpirationDate())){

    System.out.println("Вернули. Все ок");
            return licenseRepository.getAllbySerial3(serial);

        } else {

    System.out.println("Вернули ноль. Лицуха просрочена");
    return null;
        }


    }

    private boolean DateCompare(Date date){

        Date today = new Date();
        Boolean result = false;

      //  DateTimeFormatter currentdate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      //  DateTimeFormatter dbdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   //     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            if (today.compareTo(date) > 0) {
            System.out.println("today is after date");
            result = false;
        } else if (today.compareTo(date) < 0) {
            System.out.println("today is before sql date");
            result = true;
        } else if (today.compareTo(date) == 0) {
            System.out.println("Date1 is equal to Date2");
            result = false;
        }



return result;

    }
}
