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
                                allShips.set(i,ship.setShipInfoOfApi(allShips.get(i)));
                                allShips.set(i,ship2.Calculate(allShips.get(i)));
                                checkIfShipAndTimeExist(allShips.get(i));
                            }
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }
                }, 0, 60*1000);
            }


            private static void checkIfShipAndTimeExist(shipInfoObject knownShip){
                GetLastTimeAIS checkTime = new GetLastTimeAIS();
                Boolean checkTimeIfExist = checkTime.getLastTime(knownShip);

                if(!checkTimeIfExist && knownShip.getSpeed() != 0.0) {
                    InsertShipLocation.insertLocation(knownShip);
                    System.out.println(knownShip.getMmsi() + ": it is inserted, Succes. CO2: " + knownShip.getCO2());
                }else{
                    System.out.println(knownShip.getMmsi() + ": it is already inserted, Failed. CO2: " + knownShip.getCO2());
                }

            }
    }

