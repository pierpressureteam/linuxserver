package com.pier;

/**
 * Created by rodero on 25-4-16.
 */

public class ApiLogin {


    public static void loginApi() throws Exception {
        // Run command and wait till it's done
        Process p = Runtime.getRuntime().exec("../serverbash/loginApi.sh");
        p.waitFor();
    }
}
