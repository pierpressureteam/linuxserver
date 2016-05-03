package com.pier;

import java.util.ArrayList;
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
                Co2Calculator ship2 = new Co2Calculator();
                timer.schedule( new TimerTask() {
                    public void run() {
                        try {
                            ArrayList<shipInfoObject> allShips = GetAllShipsFromDatabase.getAllShips();
                            for(int i = 0; i < allShips.size(); i++) {
                                ship.getShipOfApi(allShips.get(i));
                                //ship2.Calculate();
                                //ship.setShipInfoOfApi();
                            }
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }
                }, 0, 60*1000);
            }

    }

