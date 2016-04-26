package com.pier;

/**
 * Created by rodero on 26-4-16.
 */
public class Co2Calculator {
    public void Calculate(){
        Double answer1 = Resistance();
        Double answer2 = Force(answer1);
        Double answer3 = Energy(answer2);
        Double answer4 = Volume(answer3);
        Double answer5 = Emission(answer4);
        System.out.println("CO2:" + answer5);
    }

    public Double Resistance(){
        Double V = 10.0;
        Double L = 89.0;
        Double v = Math.pow(10,-6);
        Double p = 998.0;
        Double S = 1.0;
        Double R = 0.075/Math.exp(Math.log10((V*L/v)-2))*0.5*p*Math.exp(V)*S;
        return R;
    }
    public Double Force(Double R){
        Double p = 2 * 1 * R;
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
