package com.antonromanov.firstcrud.firstcrud.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "license_control")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "serial")
    private String serial;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "days_paid")
    private int daysPaid;

    public License() {
    }

   public License(String serial, String licenseNumber, int daysPaid) {
        this.serial = serial;
        this.licenseNumber = licenseNumber;
        this.expirationDate = null;
        this.daysPaid = daysPaid;
    }


    public License(String serial, String licenseNumber, Date expirationDate, int daysPaid) {
        this.serial = serial;
        this.licenseNumber = licenseNumber;
        this.expirationDate = null;
        this.daysPaid = daysPaid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String name) {
        this.serial = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String phone) {
        this.licenseNumber = phone;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date dateHired) {
        this.expirationDate = dateHired;
    }

    public int getDaysPaid() {
        return daysPaid;
    }

    public void setDaysPaid(int dateFired) {
        this.daysPaid = dateFired;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        License license = (License) o;

        if (id != license.id) return false;
        if (serial != null ? !serial.equals(license.serial) : license.serial != null) return false;
        if (licenseNumber != null ? !licenseNumber.equals(license.licenseNumber) : license.licenseNumber != null) return false;
        if (expirationDate != null ? !expirationDate.equals(license.expirationDate) : license.expirationDate != null) return false;
       // if (daysPaid != null ? !daysPaid.equals(license.daysPaid) : license.daysPaid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (serial != null ? serial.hashCode() : 0);
        result = 31 * result + (licenseNumber != null ? licenseNumber.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
       // result = 31 * result + (daysPaid != null ? daysPaid.hashCode() : 0);
        return result;
    }
}
