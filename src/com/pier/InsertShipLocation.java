package com.pier;
import java.sql.*;

/**
 * Created by rodero on 25-4-16.
 */
public class InsertShipLocation extends DatabaseConnection{
    public static void insertLocation(shipInfoObject checkShip) {
// create a mysql database connection
        try{
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, username, password);
        // the mysql insert statement
        String query = " insert into aisinformation (current_time_ais, x_coordinates, y_coordinates, speed, ships_mmsi)"
                + " values (?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setLong (1, checkShip.getLastUpdateTime());
        preparedStmt.setDouble (2, checkShip.getxCoor());
        preparedStmt.setDouble (3, checkShip.getyCoor());
        preparedStmt.setDouble(4, checkShip.getSpeed());
            preparedStmt.setInt(5, checkShip.getMmsi());


        // execute the preparedstatement
        preparedStmt.execute();
            System.out.println("Succes");

        conn.close();
    }
    catch (Exception e)
    {
        System.err.println("Got an exception!");
        System.err.println(e.getMessage());
    }
    }
}

