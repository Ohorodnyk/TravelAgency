package com.softserve.db;

import java.sql.SQLException;

public class Executor {

    public static void main(String[] args) throws SQLException {

        ManagementSystem system = ManagementSystem.getInstance();
        System.out.println("Query1:");
        system.findCountriesAndCities();
        System.out.println("Query2:");
        system.findHotels("Краків");
        System.out.println("Query3:");
        system.findCountOfFreeRooms("Hotel Metropol", "2017-02-20");
        System.out.println("Query4:");
        system.findFreeHotels("Варшава", "2017-02-20");
        System.out.println("Query5:");
        system.countOfVisas("Іван", "Петренко");
        System.out.println("Query6:");
        system.countOfVisas("Польща");
        System.out.println("Query7:");
        system.reserveHotel("Іван", "Петренко", "Польща", "Варшава", "2017-02-20");
        System.out.println("Query8:");
        system.showClientStatistics("Іван", "Петренко");
        System.out.println("Query10:");
        system.showHotelStatistics("Hotel Metropol");
        system.closeConnection();

    }

}
