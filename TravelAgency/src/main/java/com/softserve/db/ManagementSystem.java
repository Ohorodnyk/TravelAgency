package com.softserve.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagementSystem {

    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/travel_agency";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private static ManagementSystem instance;
    private static Connection con = null;

    private ManagementSystem() {
    }

    public static ManagementSystem getInstance() {
        if (instance == null) {
            try {
                instance = new ManagementSystem();
                con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void findCountriesAndCities() throws SQLException {
        String query = "SELECT cities.name,countries.name" + " FROM cities "
                + " LEFT JOIN countries on cities.country_id=countries.country_id";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            String city = rs.getString(1);
            String country = rs.getString(2);
            System.out.println("Місто:" + city + " Країна:" + country);
        }
        rs.close();
        st.close();

    }

    public void findHotels(String cityName) throws SQLException {
        String query = "SELECT cities.name, hotels.name, hotels.rooms_count" + " FROM hotels "
                + " JOIN cities on hotels.city_id=cities.city_id" + " WHERE cities.name=?;";
        PreparedStatement prst = con.prepareStatement(query);
        prst.setString(1, cityName);
        ResultSet rs = prst.executeQuery();
        while (rs.next()) {
            String city = rs.getString(1);
            String hotel = rs.getString(2);
            int roomsCount = rs.getInt(3);
            System.out.println("Місто:" + city + " Готель:" + hotel + " Кімнат:" + roomsCount);
        }
        
    }

    public void closeConnection() throws SQLException {
        if (con != null)
            con.close();
    }

}
