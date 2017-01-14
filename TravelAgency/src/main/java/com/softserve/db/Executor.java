package com.softserve.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Executor {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://hostname:3306/travel_agency";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) throws SQLException {
        
       
        System.out.println("-------- MySQL JDBC Connection Testing ------------");
        Connection connection = null;
        Statement st=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }
        
        
        try {
            connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/travel_agency","root", "root");     
            

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

       

        System.out.println("MySQL JDBC Driver Registered!");
        
        String selectTableSQL = "SELECT cities.name 'Назва Міста', countries.name 'Назва Каїни'"
                                +" FROM cities "
                                +" LEFT JOIN countries on cities.country_id=countries.country_id";
        
        st= connection.createStatement();
        rs = st.executeQuery(selectTableSQL);
        
        while (rs.next()) {

            String city = rs.getString(1);
            String country= rs.getString(2);
            System.out.println(city+" "+country);

        }
        
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        
      }

    private static void selectCities() throws SQLException {

    }

}
