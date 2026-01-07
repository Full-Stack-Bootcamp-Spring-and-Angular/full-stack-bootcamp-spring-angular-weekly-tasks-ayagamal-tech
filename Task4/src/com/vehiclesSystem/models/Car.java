package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter @Setter @ToString
public class Car implements Vehicle{
    private String id;
    private String model;
    private String type = String.valueOf(Type.car);

    private DatabaseOperations dbOps;

    @Autowired // Constructor Injection
    public Car(DatabaseOperations dbOps) {
        this.dbOps = dbOps;
    }

    public Car(String id, String model, String type) {
        this.id = id;
        this.model = model;
        this.type = String.valueOf(type);
    }


    public void save() {
        dbOps.saveVehicle((Vehicle) this);
    }
}