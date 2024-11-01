/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.Scanner;

public class Validation {
    
    private final Scanner sc = new Scanner(System.in);     
    
    public int getIntInput(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    System.err.println("Only permits integer in range " + min + " to " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter an integer.");
            }
        }
    }
    
    public double getDoubleInput(String message, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                double n = Double.parseDouble(sc.nextLine());
                if (n < min || n > max) {
                    System.err.println("Only permits digit in range " + min + " to " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a digit.");
            }
        }
    }
    
    public double checkDouble(String msg, double min, double max) {
    String input;
    double result;
    while (true) {
        System.out.print(msg);
        input = sc.nextLine().trim();
        
        if (input.isEmpty()) {
            System.err.println("Input must not be empty");
            continue;
        }

        try {
            result = evaluateExpression(input);
            
            // Check if result is within range
            if (result < min || result > max) {
                System.out.println("Only double type in range " + min + " to " + max);
            } else {
                break;
            }
        } catch (NumberFormatException e) {
            System.err.println("Only real number permitted. or a/b (b != 0), a+b, a*b, a^b, a-b");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
    return result;
}

private double evaluateExpression(String input) {
    // Remove all spaces from input
    input = input.replaceAll("\\s+", "");
    
    //
        // Check for different operations
        if (input.contains("^")) {
            return handleExponent(input);
        } else if (input.contains("*")) {
            return handleMultiplication(input);
        } else if (input.contains("/")) {
            return handleDivision(input);
        } else if (input.contains("+")) {
            return handleAddition(input);
        } else if (input.contains("-")) { // Check from index 1 to avoid negative numbers
            return handleSubtraction(input);
        } else {
            return Double.parseDouble(input);
        }
//    } catch (Exception e) {
//        throw new IllegalArgumentException("Invalid expression format: a+b, a-b, a*b, a/b (b is not 0), a^b");
//    }
}

private double handleExponent(String input) {
    String[] parts = input.split("\\^");
    if (parts.length != 2) {
        throw new IllegalArgumentException("Invalid exponent format. Use format 'number^number'");
    }
    double base = Double.parseDouble(parts[0]);
    double exponent = Double.parseDouble(parts[1]);
    return Math.pow(base, exponent);
}

private double handleMultiplication(String input) {
    String[] parts = input.split("\\*");
    if (parts.length != 2) {
        throw new IllegalArgumentException("Invalid multiplication format. Use format 'number*number'");
    }
    double num1 = Double.parseDouble(parts[0]);
    double num2 = Double.parseDouble(parts[1]);
    return num1 * num2;
}

private double handleDivision(String input) {
    String[] parts = input.split("/");
    if (parts.length != 2) {
        throw new IllegalArgumentException("Invalid division format. Use format 'number/number' and Dominator != 0");
    }
    double numerator = Double.parseDouble(parts[0]);
    double denominator = Double.parseDouble(parts[1]);
    if (denominator == 0) {
        throw new IllegalArgumentException("Cannot divide by zero");
    }
    return numerator / denominator;
}

private double handleAddition(String input) {
    String[] parts = input.split("\\+");
    if (parts.length != 2) {
        throw new IllegalArgumentException("Invalid addition format. Use format 'number+number'");
    }
    double num1 = Double.parseDouble(parts[0]);
    double num2 = Double.parseDouble(parts[1]);
    return num1 + num2;
}

private double handleSubtraction(String input) {
    // Find the position of minus sign (ignoring first character for negative numbers)
    int minusPos = input.indexOf('-', 1);
    if (minusPos == -1) {
        return Double.parseDouble(input); // Just a negative number
    }
    
    String num1 = input.substring(0, minusPos);
    String num2 = input.substring(minusPos + 1);
    return Double.parseDouble(num1) - Double.parseDouble(num2);
}
    
    public String getOperator(String mess) {
        while(true) {
            System.out.print(mess);
            String s = sc.nextLine();
            if(s.isEmpty()) {
                System.err.println("Input can not be empty.");
            }
            else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")
                    || s.equals("=") || s.equals("^")) {
                return s;
            }
            else {
                System.err.println("Please Enter Valid Operator: (+,-,*,/,^,=).");
            }
        }
    }
}
