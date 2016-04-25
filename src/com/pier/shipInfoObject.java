package com.pier;

/**
 * Created by rodero on 25-4-16.
 */
public class shipInfoObject {
    private int mmsi = 244660136;
    private double speed;
    private double xCoor;
    private double yCoor;
    private Long lastUpdateTime;

    public void setMmsi(int mmsiSetter){
        mmsi = mmsiSetter;
    }

    public void setSpeed(double speedSetter){
        speed = speedSetter;
    }

    public void setxCoor(double xCoorSetter){
        xCoor = xCoorSetter;
    }

    public void setyCoor(double yCoorSetter){
        yCoor = yCoorSetter;
    }

    public void setLastUpdateTime(Long lastUpdateTimeSetter){
        lastUpdateTime = lastUpdateTimeSetter;
    }

    public int getMmsi(){
        return mmsi;
    }

    public double getSpeed(){
        return speed;
    }

    public double getxCoor() {
        return xCoor;
    }

    public double getyCoor() {
        return yCoor;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }
}
