package com.pier;
import java.sql.*;

/**
 * Created by rodero on 25-4-16.
 */
public class InsertShipLocation extends DatabaseConnection{
    public static void insertLocation(shipInfoObject knownShip) {
// create a mysql database connection
        try{
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, username, password);
        // the mysql insert statement
        String query = " insert into aisinformation (current_time_ais, x_coordinates, y_coordinates, speed, ships_mmsi, co2_submission)"
                + " values (?, ?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setLong (1, knownShip.getLastUpdateTime());
        preparedStmt.setDouble (2, knownShip.getxCoor());
        preparedStmt.setDouble (3, knownShip.getyCoor());
        preparedStmt.setDouble(4, knownShip.getSpeed());
            preparedStmt.setInt(5, knownShip.getMmsi());
            preparedStmt.setDouble(6,knownShip.getCO2());


        // execute the preparedstatement
        preparedStmt.execute();

        conn.close();
    }
    catch (Exception e)
    {
        System.err.println("Got an exception!");
        System.err.println(e.getMessage());
    }
    }
}

