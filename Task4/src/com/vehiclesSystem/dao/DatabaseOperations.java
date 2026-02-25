package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.models.Vehicle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;



@Component
public class DatabaseOperations {
/*
    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;
*/
    void storeVehicleIntoDatabase(Vehicle vehicle){
        //System.out.println(String.format("Connecting to database with url=%s , username=%s , password = %s", url, username, password));
        System.out.println(String.format("Storing vehicle [Model: %s, ID: %s] into database...", vehicle.getModel(), vehicle.getId()));
    }

    /* Connection */
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "vehiclesSystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection connection; // ensure to import Connection from Java.SQL

    // init method
    @PostConstruct
    public static Connection getConnection(){
        try {
            System.out.println(">> Connecting to Database...");
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME), USERNAME, PASSWORD);
        }
        catch (SQLException se){
            se.printStackTrace(); // print error message
        }
        return connection;
    }


    // save and store vehicle into database
    public void saveVehicle(Vehicle vehicle){
        Connection con = DatabaseOperations.getConnection();
        if(con == null){
            return; // void
        }
        else{
            String query = "INSERT INTO vehicles (id, model, type) VALUES (?,?,?)";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, vehicle.getId());
                preparedStatement.setString(2, vehicle.getModel());
                preparedStatement.setString(3, vehicle.getType());

                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            catch (SQLException se){
                se.printStackTrace(); // print error message
            }
        }
    }

    // Update
    public void updateVehicle(Vehicle vehicle) {
        Connection con = DatabaseOperations.getConnection();
        if (con == null) {
            return;
        } else {
            String query = "UPDATE vehicles SET model = ?, type = ? WHERE id = ?";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, vehicle.getModel());
                preparedStatement.setString(2, vehicle.getType());
                preparedStatement.setString(3, vehicle.getId());

                preparedStatement.executeUpdate();
                System.out.println("Vehicle updated successfully!");
                preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    // Delete
    public void deleteVehicle(String id) {
        Connection con = DatabaseOperations.getConnection();
        if (con == null) {
            return;
        } else {
            String query = "DELETE FROM vehicles WHERE id = ?";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, id);

                preparedStatement.executeUpdate();
                System.out.println("Vehicle with ID " + id + " deleted successfully!");
                preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    // Search By ID
    public Vehicle searchById(String id) {
        Connection con = DatabaseOperations.getConnection();
        Vehicle vehicle = null;

        if (con == null) {
            return null;
        } else {
            String query = "SELECT * FROM vehicles WHERE id = ?";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, id);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    String model = rs.getString("model");
                    String type = rs.getString("type");
                    vehicle = new com.vehiclesSystem.models.Car(id, model, type);
                }
                rs.close();
                preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return vehicle;
    }

    // Get All Vehicles
    public java.util.List<Vehicle> getAllVehicles() {
        Connection con = DatabaseOperations.getConnection();
        java.util.List<Vehicle> list = new java.util.ArrayList<>();

        if (con == null) {
            return list;
        } else {
            String query = "SELECT * FROM vehicles";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("id");
                    String model = rs.getString("model");
                    String type = rs.getString("type");

                    list.add(new com.vehiclesSystem.models.Car(id, model, type));
                }
                rs.close();
                preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return list;
    }

    // destroy Method
    @PreDestroy
    public void disconnect() {
        try {
            System.out.println(">> Closing Connection...");
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println(">> Connection Closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}