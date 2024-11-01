
package View;

import Utility.Validation;

/**
 *
 * @author HP
 */
public class userInterface {
    private final Validation val = new Validation();
    
    public int menu() {
        System.out.println("=======Calculator Program=======");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exist");
        int n = val.getIntInput("Enter your choice: ", 1, 3);
        return n;
    }
    
}
