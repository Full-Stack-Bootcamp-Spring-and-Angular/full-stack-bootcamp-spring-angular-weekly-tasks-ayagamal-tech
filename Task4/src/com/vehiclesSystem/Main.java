package com.vehiclesSystem;
import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.*;
import lombok.ToString;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Spring Container, DB object
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        DatabaseOperations databaseOperations = new DatabaseOperations();

        // Connection to Database(vehiclesSystem)
        Connection con = DatabaseOperations.getConnection();
        if(con == null){ // Failed Connection
            System.out.println("Connection Failed!");
        }
        else{ System.out.println("Connection successed!");}


        // store into list (memory)
        List<Vehicle> vehicleList = new ArrayList<>();
        Car myCar = new Car("13", "Tesla", String.format(String.valueOf(Type.car)));
        vehicleList.add((Vehicle) myCar);
        databaseOperations.saveVehicle((Vehicle) myCar);

        databaseOperations.getAllVehicles();

        databaseOperations.searchById("1");
        
        databaseOperations.deleteVehicle("11");

        databaseOperations.getAllVehicles();

        //Close Container
        context.close();
    }
}