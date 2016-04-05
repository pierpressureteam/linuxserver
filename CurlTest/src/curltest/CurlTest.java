/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStreamReader;

/**
 *
 * @author Roy van den Heuvel
 */
public class CurlTest {

    public static void main(String[] args) {
        String s = null;

        
        Process p;
        try {
            p = Runtime.getRuntime().exec("curl -X GET --header 'Accept: application/json' --header 'Authorization: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJocm80IiwiaXNzIjoiMTI3LjAuMC4xIiwiZXhwIjoxNDYwNDQ1MDEyLCJpYXQiOjE0NTk4NDAyMTJ9.zYjyv2aNsRfVLiogC9Stwrxuzfw8E3QwDmjfdmlFirs' 'http://backenddev.teqplay.nl/auth/whoami'");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            
            System.out.println("Here is the standard output of the command:\n");

            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                
                System.out.println("Here is the standard error of the command (if any):\n");

                while ((s = stdError.readLine()) != null) {
                    System.out.println(s);
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
