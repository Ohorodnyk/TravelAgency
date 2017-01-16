package com.softserve.db;

import java.sql.Connection;
import java.sql.Date;
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

    public void findCountOfFreeRooms(String hotel, String date) throws SQLException {
        String query = "SELECT COUNT(booked_rooms.room_id) " + "FROM booked_rooms "
                + "JOIN hotel_rooms on booked_rooms.room_id = hotel_rooms.room_id "
                + "JOIN hotels on hotel_rooms.hotel_id=hotels.hotel_id " + "WHERE hotels.name=? "
                + "AND ? NOT BETWEEN booked_rooms.start_date AND booked_rooms.end_date "
                + "AND ? > booked_rooms.end_date";

        PreparedStatement prst = con.prepareStatement(query);
        prst.setString(1, hotel);
        prst.setDate(2, java.sql.Date.valueOf(date));
        prst.setDate(3, java.sql.Date.valueOf(date));
        ResultSet rs = prst.executeQuery();

        while (rs.next()) {

            int countOfFreeRoms = rs.getInt(1);

            System.out.println("Кількість вільних номерів:" + countOfFreeRoms);

        }

        rs.close();
        prst.close();

    }

    public void findFreeHotels(String city, String date) throws SQLException {
        String query = " SELECT H.name, COUNT(*) "
                + "FROM hotels H JOIN (SELECT cities.city_id FROM cities WHERE cities.name=?) C "
                + "ON H.city_id=C.city_id " + "LEFT JOIN hotel_rooms HR ON H.hotel_id=HR.hotel_id "
                + "LEFT JOIN booked_rooms BR ON HR.room_id=BR.room_id " + "WHERE BR.end_date IS NULL "
                + "OR ? NOT BETWEEN BR.start_date AND BR.end_date " + "group by H.name;";
        PreparedStatement prst = con.prepareStatement(query);
        prst.setString(1, city);
        prst.setDate(2, Date.valueOf(date));
        ResultSet rs = prst.executeQuery();
        while (rs.next()) {
            String hotel = rs.getString(1);
            int roomsCount = rs.getInt(2);
            System.out.println("Готель:" + hotel + " Кімнат:" + roomsCount);
        }
        prst.close();
        rs.close();

    }

    public void countOfVisas(String firstName, String lastName) throws SQLException {
        String query = "SELECT c.first_name, c.last_name, COUNT(v.visa_id) " + "FROM visas v "
                + "JOIN clients c ON v.client_id=c.client_id " + "WHERE ?=c.first_name and ?=c.last_name";
        PreparedStatement prst = con.prepareStatement(query);
        prst.setString(1, firstName);
        prst.setString(2, lastName);
        ResultSet rs = prst.executeQuery();
        while (rs.next()) {
            String fName = rs.getString(1);
            String lName = rs.getString(2);
            int visas = rs.getInt(3);
            System.out.println(fName + " " + lName + " Кількість віз:" + visas);
        }

    }

    public void countOfVisas(String country) throws SQLException {
        String query = "SELECT c.name, COUNT(v.visa_id) " + "FROM countries c "
                + "JOIN visas v ON c.country_id=v.country_id " + "WHERE c.name=?";
        PreparedStatement prst = con.prepareStatement(query);
        prst.setString(1, country);
        ResultSet rs = prst.executeQuery();
        while (rs.next()) {
            int visas = rs.getInt(2);
            System.out.println(rs.getString(1) + " Кількість віз:" + visas);
        }
    }

    public void reserveHotel(String firstName, String lastName, String country, String city, String date)
            throws SQLException {
        String query = "SELECT w.name, v.start_date, v.end_date FROM visas v "
                + "JOIN clients c on v.visa_id=c.client_id " + "JOIN countries w on v.country_id=w.country_id "
                + "WHERE c.first_name=? " + " AND c.last_name=?" + "AND v.end_date >CURDATE() AND w.name=?;";
        PreparedStatement prst = con.prepareStatement(query);
        prst.setString(1, firstName);
        prst.setString(2, lastName);
        prst.setString(3, country);
        ResultSet rs = prst.executeQuery();
        if (!rs.isBeforeFirst()) {
            System.out.println("Клієнт немає візи і не може забронювати готель. ");
            return;
        }

        System.out.println("Інформація про візу клієнта");
        while (rs.next()) {
            Date startDate = rs.getDate(2);
            Date endDate = rs.getDate(3);
            System.out.println(rs.getString(1) + " " + startDate + " " + endDate);
        }
        query = "SELECT H.name, COUNT(*) "
                + "FROM hotels H JOIN (SELECT cities.city_id FROM cities WHERE cities.name=?) C "
                + "ON H.city_id=C.city_id " + "LEFT JOIN hotel_rooms HR ON H.hotel_id=HR.hotel_id "
                + "LEFT JOIN booked_rooms BR ON HR.room_id=BR.room_id " + "WHERE BR.end_date IS NULL "
                + "OR ? NOT BETWEEN BR.start_date AND BR.end_date " + "group by H.name;";
        prst = con.prepareStatement(query);
        prst.setString(1, city);
        prst.setDate(2, java.sql.Date.valueOf(date));
        rs = prst.executeQuery();
        if (!rs.isBeforeFirst()) {
            System.out.println("Нажаль немає вільних готелей у даному місті.");
            return;
        }
        System.out.println("Клієнт  може забронювати такі готелі:");
        while (rs.next()) {

            int countOfRooms = rs.getInt(2);
            System.out.println(rs.getString(1) + " Кількість вільних кімнат:" + countOfRooms);
        }

    }

    public void showClientStatistics(String firstName, String lastName) throws SQLException {
        String query = "SELECT DISTINCT w.name " + " FROM clients c "
                + "JOIN client_tours ct on c.client_id=ct.client_id " + "JOIN tours t on ct.client_tour_id=t.tour_id "
                + " JOIN countries w on t.country_id=w.country_id " + "WHERE ?=c.first_name and ?=c.last_name;";
        PreparedStatement prst = con.prepareStatement(query);
        prst.setString(1, firstName);
        prst.setString(2, lastName);
        ResultSet rs = prst.executeQuery();
        System.out.println("Країни, які відвідував:");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        query = "SELECT DISTINCT w.name , v.start_date, v.end_date " + "FROM clients c "
                + "JOIN visas v on c.client_id=v.client_id " + "JOIN countries w on v.country_id=w.country_id "
                + "WHERE ?=c.first_name and ?=c.last_name;";
        prst = con.prepareStatement(query);
        prst.setString(1, firstName);
        prst.setString(2, lastName);
        rs = prst.executeQuery();
        System.out.println("Візи:");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getDate(2) + " " + rs.getDate(3));
        }

    }

    public void showHotelStatistics(String hotel) throws SQLException {
        String query = "SELECT COUNT(DISTINCT (ct.client_id)) FROM booked_rooms br "
                + "JOIN client_tours ct ON br.client_tour_id=ct.client_tour_id "
                + "JOIN hotel_rooms r on br.room_id=r.room_id " + "JOIN hotels h on r.hotel_id=h.hotel_id "
                + "WHERE h.name=?";
        PreparedStatement prst = con.prepareStatement(query);
        prst.setString(1, hotel);
        ResultSet rs = prst.executeQuery();
        while (rs.next()) {
            System.out.println("Кількість клієнтів:" + rs.getInt(1));
        }
        query = "SELECT AVG( DATEDIFF(br.end_date, br.start_date) )FROM booked_rooms br "
                + "JOIN client_tours ct ON br.client_tour_id=ct.client_tour_id "
                + "JOIN hotel_rooms r on br.room_id=r.room_id " + "JOIN hotels h on r.hotel_id=h.hotel_id "
                + "WHERE h.name=?";
        prst = con.prepareStatement(query);
        prst.setString(1, hotel);
        rs = prst.executeQuery();
        while (rs.next()) {
            System.out.println("Середній час бронювання:" + rs.getInt(1) + "днів");
        }

    }

    public void closeConnection() throws SQLException {
        if (con != null)
            con.close();
    }

}
