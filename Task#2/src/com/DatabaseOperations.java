package com;

public class DatabaseOperations {
    private String url;
    private String username;
    private String password;


    void storeVehicleIntoDatabase(String vehicleName){
        System.out.println(String.format("Connecting to database with url=%s , username=%s , password = %s", url, username, password));
        System.out.println(String.format("Storing vehicle %s into database .......", vehicleName));
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
