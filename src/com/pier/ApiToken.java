package com.pier;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;


public class ApiToken {
    private String token;

    public String getToken(){
        return token;
    }

    public void setToken() throws Exception{
            JSONParser tokenParser = new JSONParser();
            Object tokenObject = tokenParser.parse(new FileReader("../JSON/apiLogin.json"));
            JSONObject tokenJsonObject = (JSONObject) tokenObject;
            String tokenReal = (String) tokenJsonObject.get("token");
            System.out.println(tokenReal);
            token = tokenReal;
        }
    }

