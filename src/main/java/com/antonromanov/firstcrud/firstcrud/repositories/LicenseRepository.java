package com.antonromanov.firstcrud.firstcrud.repositories;

import com.antonromanov.firstcrud.firstcrud.model.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface LicenseRepository extends CrudRepository<License, Integer> {

//    public interface LicenseRepository extends JpaRepository<License, Long> {

  //  }


    @Query(value = "SELECT distinct s.serial FROM License s")
    List<String> getAllSerials();

    @Query(value = "SELECT s.id, s.serial, s.licenseNumber, s.expirationDate, s.daysPaid FROM License s WHERE s.serial =:#{#param} ")
    List<License> getAllSerials2(@Param("param") String param);



    @Query(value = "SELECT s.id, s.serial, s.licenseNumber, s.expirationDate FROM License s")
    List<License> getAll();

    @Query(value = "SELECT s.id, s.serial, s.licenseNumber, s.expirationDate FROM License s  WHERE s.serial =:#{#param}")
    List<License> SerialCheck(@Param("param") String param);


    @Query(value = "SELECT s.id, s.serial, s.licenseNumber, s.expirationDate, s.daysPaid FROM License s WHERE s.serial =:#{#param} AND s.daysPaid = (select max(s.daysPaid) from License s )")
    List<License> getAllbySerial(@Param("param") String param);






 //   Iterable<License> findAll();

}
