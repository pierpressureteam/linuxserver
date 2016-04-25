package com.pier;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static ApiToken newestToken = new ApiToken();

            public static void main(String[] args) throws Exception {
                ApiLogin.loginApi();
                newestToken.setToken();
                checkTimeShipInformation();
            }

            private static void checkTimeShipInformation() throws Exception{
                Timer timer = new Timer();
                getShipInfo hoi = new getShipInfo();
                timer.schedule( new TimerTask() {
                    public void run() {
                        try {
                            hoi.getShipOfApi();
                            hoi.setShipInfoOfApi();
                            System.out.println("Succes");
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }
                }, 0, 60*1000);
            }

    }

