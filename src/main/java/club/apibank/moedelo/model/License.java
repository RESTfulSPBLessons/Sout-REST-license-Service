package club.apibank.moedelo.model;


import java.sql.Date;


public class License {

    
    private int id;

    
    private String serial;


    public License() {
    }

   public License(String serial) {
        this.serial = serial;
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

}
