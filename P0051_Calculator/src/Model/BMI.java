/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Utility.Validation;

/**
 *
 * @author HP
 */
public class BMI {
    private final Validation val = new Validation();
    
    public void calculator() {
        double w = val.getDoubleInput("Enter Weight(kg): ", 0, Double.MAX_VALUE);
        double h = val.getDoubleInput("Enter Height(cm): ", 0, Double.MAX_VALUE);
        double bmi = w/Math.pow(h/100, 2);
        System.out.printf("BMI Number: %.2f\n", bmi);
        System.out.println("BMI Status: " + Status(bmi));
    }
    
    private String Status(double bmi) {
        if(bmi < 19) return "Under-Standard";
        if(bmi < 25 && bmi >=19 ) return "Standard";
        if(bmi >= 25 && bmi <30 ) return "Overweight";
        if(bmi >= 30 && bmi < 40) return "Fat - should lose weight";
        else return "Very fat - should lose weight immediately";
    }
}
