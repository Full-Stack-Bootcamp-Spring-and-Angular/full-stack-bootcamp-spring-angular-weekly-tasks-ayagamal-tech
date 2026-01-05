package com;

public class Car implements vehicle {

    private DatabaseOperations databaseOperations;

    //constructor method for constructor injection
    public Car(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    @Override
    public void storevehicle() {
        databaseOperations.storeVehicleIntoDatabase("car");
    }
}
