package com.softserve.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        
       
        System.out.println("-------- MySQL JDBC Connection  ------------");
        Connection connection = null;
        Statement st=null;
        ResultSet rs=null;
        PreparedStatement prst = null;
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
        
        System.out.println("_________________________________");
        
        String selectCities = "SELECT cities.name,countries.name"
                              +" FROM cities "
                              +" LEFT JOIN countries on cities.country_id=countries.country_id";
        
        st= connection.createStatement();
        rs = st.executeQuery(selectCities);
        
        while (rs.next()) {

            String city = rs.getString(1);
            String country= rs.getString(2);
            System.out.println("Місто:"+city+" Країна:"+country);

        }
        
        System.out.println("_________________________________");
        
        String findHotelsByName="SELECT cities.name, hotels.name, hotels.rooms_count"
                                + " FROM hotels "
                                + " JOIN cities on hotels.city_id=cities.city_id"
                                + " WHERE cities.name=?;";
        
        prst = connection.prepareStatement(findHotelsByName);
        prst.setString(1,"Краків");
     // execute select SQL stetement
        rs = prst.executeQuery();
        while(rs.next())
        {
            String city= rs.getString(1);
            String hotel= rs.getString(2);
            int roomsCount= rs.getInt(3);
            System.out.println("Місто:"+city+" Готель:"+hotel+" Кімнат:"+roomsCount);
            
        }
        
        System.out.println("_________________________________");
        
        String countOfFreeRooms= "SELECT COUNT(booked_rooms.room_id) "
                                 +"FROM booked_rooms "
                                 +"JOIN hotel_rooms on booked_rooms.room_id = hotel_rooms.room_id "
                                 +"JOIN hotels on hotel_rooms.hotel_id=hotels.hotel_id "
                                 +"WHERE hotels.name=? "
                                 +"AND ? NOT BETWEEN booked_rooms.start_date AND booked_rooms.end_date "
                                 +"AND ? > booked_rooms.end_date";
        
        
        prst = connection.prepareStatement(countOfFreeRooms);
        prst.setString(1,"Hotel Metropol"); 
        prst.setDate(2, java.sql.Date.valueOf("2017-02-20"));
        prst.setDate(3, java.sql.Date.valueOf("2017-02-20"));
        rs = prst.executeQuery();
        
        while (rs.next()) {

            int countOfFreeRoms = rs.getInt(1);
            
            System.out.println("Кількість вільних номерів:"+countOfFreeRoms);

        }
        
        
        
        System.out.println("_________________________________");
        
        
        String  freeHotels=" SELECT H.name, COUNT(*) "
                           +"FROM hotels H JOIN (SELECT cities.city_id FROM cities WHERE cities.name=?) C "
                           +"ON H.city_id=C.city_id "
                           +"LEFT JOIN hotel_rooms HR ON H.hotel_id=HR.hotel_id "
                           +"LEFT JOIN booked_rooms BR ON HR.room_id=BR.room_id "
                           +"WHERE BR.end_date IS NULL "
                           +"OR ? NOT BETWEEN BR.start_date AND BR.end_date "
                           +"group by H.name;";
        
        prst = connection.prepareStatement(freeHotels);
        prst.setString(1,"Варшава"); 
        prst.setDate(2, java.sql.Date.valueOf("2017-02-20"));
        rs = prst.executeQuery();
        
        while(rs.next())
        {
           
            String hotel= rs.getString(1);
            int roomsCount= rs.getInt(2);
            System.out.println("Готель:"+hotel+" Кімнат:"+roomsCount);
            
        }
        
        
        System.out.println("_________________________________"); 
        
        String countOfVisa= "SELECT c.first_name, c.last_name, COUNT(v.visa_id) "
                            +"FROM visas v "
                            +"JOIN clients c ON v.client_id=c.client_id "
                            +"WHERE ?=c.first_name and ?=c.last_name";
        
        prst = connection.prepareStatement(countOfVisa);
        prst.setString(1,"Іван"); 
        prst.setString(2,"Петренко");
        rs = prst.executeQuery();
        
        
        while(rs.next())
        {
           
            String firstName= rs.getString(1);
            String lastName= rs.getString(2);
            int visas= rs.getInt(3);
            System.out.println(firstName +" "+lastName +" Кількість віз:"+visas);
            
        }
        
        
        System.out.println("_________________________________"); 
        
        
        countOfVisa= "SELECT c.name, COUNT(v.visa_id) "
                     +"FROM countries c "
                     +"JOIN visas v ON c.country_id=v.country_id "
                     +"WHERE c.name=?";
        
        
        prst = connection.prepareStatement(countOfVisa);
        prst.setString(1,"Польща"); 
        rs = prst.executeQuery();
        
        
        while(rs.next())
        {
           
            String country= rs.getString(1);
            int visas= rs.getInt(2);
            System.out.println(country+" Кількість віз:"+visas);
            
        }
        
        
        
        
        System.out.println("_________________________________"); 
        
        
        String getVisaByClient= "SELECT w.name, v.start_date, v.end_date FROM visas v "
                                +"JOIN clients c on v.visa_id=c.client_id "
                                +"JOIN countries w on v.country_id=w.country_id "
                                + "WHERE c.first_name=? "
                                +" AND c.last_name=?"
                                +"AND v.end_date >CURDATE() AND w.name=?;";
        
        prst = connection.prepareStatement(getVisaByClient);
        prst.setString(1,"Іван"); 
        prst.setString(2, "Петренко");
        prst.setString(3, "Польща");
        rs = prst.executeQuery();
        
        
        
        
        if(!rs.isBeforeFirst())
            System.out.println("Клієнт не має візи і не може забронювати готель ");
        else
        {   
            
            System.out.println("Інформація про візу клієнта");
            while(rs.next())
            {
                String country= rs.getString(1);
                java.sql.Date startDate = rs.getDate(2);
                java.sql.Date endDate = rs.getDate(3);
                System.out.println(country+" "+startDate +" "+endDate);
            }
            System.out.println("Клієнт  може забронювати готель ");
            
            
            String hotels="SELECT H.name, COUNT(*) "
                         +"FROM hotels H JOIN (SELECT cities.city_id FROM cities WHERE cities.name=?) C "
                         +"ON H.city_id=C.city_id "
                         +"LEFT JOIN hotel_rooms HR ON H.hotel_id=HR.hotel_id "
                         +"LEFT JOIN booked_rooms BR ON HR.room_id=BR.room_id "
                         +"WHERE BR.end_date IS NULL "
                         +"OR ? NOT BETWEEN BR.start_date AND BR.end_date "
                         +"group by H.name;";
            
            prst = connection.prepareStatement(hotels);
            prst.setString(1,"Варшава"); 
            prst.setDate(2,java.sql.Date.valueOf("2017-02-20"));
            rs = prst.executeQuery();
            
            if(!rs.isBeforeFirst())
                System.out.println("Нажаль немає вільних готелей у даному місті");
            
            else
            {
                while(rs.next())
                {
                    String hotel=rs.getString(1);
                    int countOfRooms= rs.getInt(2);
                    System.out.println(hotel +" "+countOfRooms);
                }
                
            }
            
            
        }
        
        System.out.println("_________________________________");
        
        
        String visitedCountries="SELECT DISTINCT w.name "
                                +" FROM clients c "
                                +"JOIN client_tours ct on c.client_id=ct.client_id "
                                +"JOIN tours t on ct.client_tour_id=t.tour_id "
                                +" JOIN countries w on t.country_id=w.country_id "
                                +"WHERE ?=c.first_name and ?=c.last_name;";
        
        prst = connection.prepareStatement(visitedCountries);
        prst.setString(1,"Іван"); 
        prst.setString(2,"Петренко");
        rs = prst.executeQuery();
        System.out.println("Країни");
        
        while(rs.next())
        {
            System.out.println(rs.getString(1));
        }
        
               
        
        
        
        
        
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        
        
        
        if (st != null) {
            st.close();
        }
        
        
        if (prst != null) {
            prst.close();
        }
        

        if (connection != null) {
            connection.close();
        }
        
      }

    private static void selectCities() throws SQLException {

    }

}
