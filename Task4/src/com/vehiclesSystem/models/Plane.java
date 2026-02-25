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
public class Plane implements Vehicle{
    private String id;
    private String model;
    private String type = String.valueOf(Type.plane);

    private DatabaseOperations dbOps;

    @Autowired // Setter Injection
    public void setDbOps(DatabaseOperations dbOps) {
        this.dbOps = dbOps;
    }

    /*public void save() {
        dbOps.saveVehicle(this.model, this.type);
    }
    */
}