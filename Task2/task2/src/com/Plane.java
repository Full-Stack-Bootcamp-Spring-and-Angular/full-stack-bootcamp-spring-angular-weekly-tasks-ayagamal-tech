package com;

public class Plane implements vehicle {

    private DatabaseOperations databaseOperations;

    //setter method for setter injection
    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    @Override
    public void storevehicle() {
        databaseOperations.storeVehicleIntoDatabase("plane");
    }
}