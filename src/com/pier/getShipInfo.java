package com.pier;

import java.io.*;

import static com.pier.Main.newestToken;

/**
 * Created by rodero on 25-4-16.
 */
public class getShipInfo {
    public void getShipOfApi() throws Exception  {
        String tokenApi = newestToken.getToken();
        String bash = "#!/bin/bash \n";
        String shell = "curl -X GET --header \"Accept: application/json\" --header \"Authorization: " + tokenApi + " \" \"http://backenddev.teqplay.nl/ship/244660136\" > ../JSON/ship.json";
        Writer shipInfoShell = new BufferedWriter(new FileWriter("../serverbash/ship.sh"));
        shipInfoShell.write(bash);
        shipInfoShell.write(shell);
        shipInfoShell.close();
        Process processChmodBash = Runtime.getRuntime().exec("chmod u+x ../serverbash/ship.sh");
        Process processMakeBash = Runtime.getRuntime().exec("../serverbash/ship.sh");
        processMakeBash.waitFor();


        // Grab output and print to display
        BufferedReader reader = new BufferedReader(new InputStreamReader(processMakeBash.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
