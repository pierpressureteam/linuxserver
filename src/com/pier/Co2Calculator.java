package com.pier;

/**
 * Created by rodero on 26-4-16.
 */
public class Co2Calculator {
    shipInfoObject calculateKnownShip;
    public shipInfoObject Calculate(shipInfoObject knownShip){
        calculateKnownShip = knownShip;
        if(calculateKnownShip.getSpeed() != 0.0) {
            Double r = Resistance();
            Double tr = TotalResistance(r);
            Double f = Force(tr);
            Double e = Energy(f);
            Double v = Volume(e);
            Double co2answer = Emission(v);
            calculateKnownShip.setCO2(co2answer);
        }else{
            calculateKnownShip.setCO2(0.0);
        }
        return calculateKnownShip;
    }

    public Double Resistance(){
        Double V = calculateKnownShip.getSpeed();
        Double L = calculateKnownShip.getLength();
        Double B = calculateKnownShip.getWith();
        Double D = calculateKnownShip.getDepth();
        Double v = Math.pow(10,-6);
        Double p = 998.0;
        Double S = L * B + 2 * L * Math.exp(D);
        Double R = 0.075/(Math.exp(Math.log(V*L/v)-2))*0.5*p*Math.exp(V)*S;
        return R;
    }

    public Double TotalResistance(Double R){
        Double rt = (R + R) * 1000;
        return rt;
    }

    public Double Force(Double rt){
        Double p = 2 * 1 * rt;
        return p;
    }
    public Double Energy(Double p){
        Double t = 1.0;
        Double E = p * t;
        return E;
    }
    public Double Volume(Double E){
        Double diesel = 0.10;
        Double liter = E * diesel;
        return liter;
    }
    public Double Emission(Double liter){
        Double CO2Math = 3.1;
        Double CO2 = liter * CO2Math;
        return CO2;
    }
}
