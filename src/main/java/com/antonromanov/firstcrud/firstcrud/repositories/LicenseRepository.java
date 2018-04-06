package com.antonromanov.firstcrud.firstcrud.repositories;

import com.antonromanov.firstcrud.firstcrud.model.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.sql.Date;
import java.util.Calendar;



import java.util.List;


public interface LicenseRepository extends CrudRepository<License, Integer> {

//    public interface LicenseRepository extends JpaRepository<License, Long> {

  //  }


    @Query(value = "SELECT distinct s.serial FROM License s")
    List<String> getAllSerials();

    @Query(value = "SELECT s.id, s.serial, s.licenseNumber, s.expirationDate FROM License s")
    List<License> getAll();

    @Query(value = "SELECT s.serial, s.licenseNumber, s.expirationDate, s.daysPaid FROM License s WHERE s.serial =:#{#param} AND CURRENT_DATE() < (select max(s.daysPaid) from License s )")
    List<License> getAllbySerial(@Param("param") String param);


    //@Query(value = "SELECT s.id, s.serial, s.licenseNumber, s.expirationDate, s.daysPaid FROM License s WHERE s.serial =:#{#param}")
    @Query(value = "select s from License s WHERE s.serial =:#{#param}")
    //@Query(value = "select s.serial, s.licenseNumber, s.expirationDate, s.daysPaid from License s WHERE s.serial =:#{#param}")
    List<License> getAllbySerial2(@Param("param") String param);


    //SELECT * FROM sout69.license_control s WHERE s.expiration_date = (SELECT MAX(st.expiration_date) FROM sout69.license_control st where st.serial="1");

    //@Query(value = "select s from License s WHERE s.serial =:#{#param}")
    //@Query(value = "select s from License s WHERE s.serial =:#{#param} and s.expirationDate = (select max(st.expirationDate) from License st where s.id=st.id)")
    @Query(value = "select s from License s WHERE s.expirationDate = (select max(st.expirationDate) from License st where st.serial=:#{#param})")
    List<License> getAllbySerial3(@Param("param") String param);
    //List<License> getAllbySerial3(@Param("param") String param);


    //FROM License s WHERE s.serial =:#{#param} AND CURRENT_DATE() < (select max(s.daysPaid) from License s )")



    @Query(value = "SELECT s.id, s.serial, s.licenseNumber, s.expirationDate FROM License s  WHERE s.serial =:#{#param}")
    List<License> SerialCheck(@Param("param") String param);





 //   Iterable<License> findAll();

}
