package com.pier;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by rodero on 25-4-16.
 */
public class ApiLogin {


    public static void loginApi() throws Exception {
        // Run command and wait till it's done
        Process p = Runtime.getRuntime().exec("../serverbash/loginApi.sh");
        p.waitFor();

        // Grab output and print to display
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
