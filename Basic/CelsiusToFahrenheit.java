package com.yadavrahulo4.java_problems.Basic;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        int celsius_Temp=20;
        /*formula to convert Celsius to Fahrenheit is { F=(9/5*C)+32 } Where F is Fahrenheit & C is Celsius.*/
        int fahrenheit_Temp= (celsius_Temp*9/5)+32;
        System.out.println(celsius_Temp+"°C is equivalent to "+fahrenheit_Temp+"°F .");
    }
}
