package com.pier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by rodero on 3-5-16.
 */
public class GetAllShipsFromDatabase extends DatabaseConnection {
    public static ArrayList<shipInfoObject> getAllShips() {
        try {
            int shipCount = 0;
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, username, password);

            String query = "SELECT mmsi,typename,typebigname,shiplength,shipwith,shipdepth,capacity FROM ships,shiptype WHERE shiptype_typename = typename;";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList <shipInfoObject> allShips = new ArrayList();
            while(rs.next())
            {
                allShips.add(new shipInfoObject());
                int mmsi = rs.getInt("mmsi");
                double length = rs.getDouble("shiplength");
                double depth = rs.getDouble("shipdepth");
                double with = rs.getDouble("shipwith");
                double capacity = rs.getDouble("capacity");
                allShips.get(shipCount).setMmsi(mmsi);
                allShips.get(shipCount).setLength(length);
                allShips.get(shipCount).setWith(with);
                allShips.get(shipCount).setDepth(depth);
                allShips.get(shipCount).setCapacity(capacity);
                shipCount++;
            }
            return allShips;
        }catch(Exception e){
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(e);
        }
        return null;
    }
}
