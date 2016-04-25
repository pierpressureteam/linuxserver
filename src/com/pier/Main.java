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
                getShipInfo ship = new getShipInfo();
                timer.schedule( new TimerTask() {
                    public void run() {
                        try {
                            ship.getShipOfApi();
                            ship.setShipInfoOfApi();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }
                }, 0, 60*1000);
            }

    }

