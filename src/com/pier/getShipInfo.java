package com.pier;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;

import static com.pier.Main.newestToken;

/**
 * Created by rodero on 25-4-16.
 */
public class getShipInfo {
    public void getShipOfApi(shipInfoObject knownShip) throws Exception  {
        String tokenApi = newestToken.getToken();
        String bash = "#!/bin/bash \n";
        String shell = "curl -X GET --header \"Accept: application/json\" --header \"Authorization: " + tokenApi + " \" \"http://backenddev.teqplay.nl/ship/"+ knownShip.getMmsi() + "\" > ../JSON/ship.json";
        Writer shipInfoShell = new BufferedWriter(new FileWriter("../serverbash/ship.sh"));
        shipInfoShell.write(bash);
        shipInfoShell.write(shell);
        shipInfoShell.close();
        Process processChmodBash = Runtime.getRuntime().exec("chmod u+x ../serverbash/ship.sh");
        Process processMakeBash = Runtime.getRuntime().exec("../serverbash/ship.sh");
        processChmodBash.waitFor();
        processMakeBash.waitFor();
    }

    public shipInfoObject setShipInfoOfApi(shipInfoObject knownShip) throws Exception{
        JSONParser shipParser = new JSONParser();
        Object shipObject = shipParser.parse(new FileReader("../JSON/ship.json"));
        JSONObject shipJsonObject = (JSONObject) shipObject;
        JSONObject locationShipObject = (JSONObject) shipJsonObject.get("location");

        Double xCoordinates = (Double) locationShipObject.get("latitude");
        Double yCoordinates = (Double) locationShipObject.get("longitude");
        Double speed = (Double) shipJsonObject.get("speedOverGround");
        Long lastUpdateShipInfo = (Long) shipJsonObject.get("timeLastUpdate");

        knownShip.setSpeed(speed);
        knownShip.setxCoor(xCoordinates);
        knownShip.setyCoor(yCoordinates);
        knownShip.setLastUpdateTime(lastUpdateShipInfo);

        return knownShip;
    }
}
