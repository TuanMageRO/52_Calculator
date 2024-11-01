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
public class SimpleCalculator {
    private final Validation val = new Validation();
    private final double dMin = Double.MAX_VALUE*(-1);
    private final double dMax = Double.MAX_VALUE;
    
    public void calculator() {
        double memo = val.checkDouble("Enter number: ", dMin, dMax);
        double n;
        while(true) {
            String ope = val.getOperator("Enter operator: ");
            if(ope.equals("+")) {
                n = val.checkDouble("Enter Number: ", dMin, dMax);
                memo += n;
                System.out.println("Memory = " + memo);
            }
            if(ope.equals("-")) {
                n = val.checkDouble("Enter Number: ", dMin, dMax);
                memo -= n;
                System.out.println("Memory = " + memo);
            }
            
            if(ope.equals("*")) {
                n = val.checkDouble("Enter Number: ", dMin, dMax);
                memo *= n;
                System.out.println("Memory = " + memo);
            }
            
            if(ope.equals("/")) {
                boolean check = true;
                while(check) {
                    n = val.checkDouble("Enter Number: ", dMin, dMax);
                    if(n!= 0) {
                        memo /= n;
                        System.out.println("Memory = " + memo);
                        check = false;
                    }
                    else System.err.println("Can not divide for 0.");
                }
            }
            
            if(ope.equals("^")) {
                n = val.checkDouble("Enter Number: ", dMin, dMax);
                memo = Math.pow(memo, n);
                System.out.println("Memory = " + memo);
            }
            if(ope.equals("=")) {
                System.out.println("Result = " + memo);
                return;
            }
        }
    }
}
