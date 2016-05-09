package com.pier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by rodero on 9-5-16.
 */
public class GetLastTimeAIS extends DatabaseConnection {
    public Boolean getLastTime(shipInfoObject knownShip) {
        Boolean checkIsEmpty = true;
        try {
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, username, password);

            String query = "SELECT ships_mmsi,current_time_ais FROM aisinformation WHERE current_time_ais = " + knownShip.getLastUpdateTime();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            checkIsEmpty = rs.next();

        }catch (Exception e){
            //noinspection ThrowablePrintedToSystemOut,ThrowablePrintedToSystemOut
            System.out.println(e);
            checkIsEmpty = true;
        }
        return checkIsEmpty;
    }
}
