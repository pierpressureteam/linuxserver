package com.pier;

public class Main {
    static ApiToken newestToken = new ApiToken();

            public static void main(String[] args) throws Exception {
                ApiLogin.loginApi();
                newestToken.setToken();
            }

    }

