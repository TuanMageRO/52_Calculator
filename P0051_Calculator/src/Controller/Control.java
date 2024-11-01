/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BMI;
import Model.SimpleCalculator;
import View.userInterface;

/**
 *
 * @author HP
 */
public class Control {
    private final Model.BMI bmiC = new BMI();
    private final Model.SimpleCalculator simC = new SimpleCalculator();
    private final userInterface ui = new userInterface();
    
    public void run() {
        while(true) {
            int choice = ui.menu();
            switch (choice) {
                case 1:
                    simC.calculator();
                    break;
                case 2:
                    bmiC.calculator();
                    break;
                case 3:
                    System.out.println("Exit...");
                    return;
            }
        }
    }
}
