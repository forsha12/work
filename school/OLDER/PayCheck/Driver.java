
/**
 * Driver class, uses one main method. Creates an instance of PayCheck and asks the user for information
 * to fill its fields with. After collecting the information and calling the appropriate methods from 
 * the PayCheck class, it presents to the user the pay check data. This is done in a loop. The loop ends when 
 * user enters a 'n'.
 * 
 * @author Paige Forsha
 * @version 2/6/17
 */

import java.util.Scanner;
public class Driver
{
    public static void main (String [] args) //main method
    {
        String inLast;
        String inFirst;
        double inRate;
        double inWorked;
        char choice = 'y';
        Scanner numInput = new Scanner(System.in); //for numerical values 
        Scanner input = new Scanner(System.in); //for strings and chars
        PayCheck check = new PayCheck();
        do {
            choice = 'y';
            System.out.println("\nWhat is the last and first name (MUST be in that order)?");
                inLast = input.next();
                inFirst= input.next();  //gets last and first names
           
           System.out.println("\nWhat is the rate of pay?");
                inRate = numInput.nextDouble(); //getting rate of pay
                
           System.out.println("\nHow many hours were worked?");
                inWorked = numInput.nextDouble(); //getting hours worked
                
           check.setLastName(inLast);
           check.setFirstName(inFirst);
           check.setHourlyRate(inRate);
           check.setHoursWorked(inWorked);
           check.getGrossPay();
           check.getNetPay(); //all above, sending data to be validated for the object
            
           System.out.print(check.toString()); //prints data
            
            System.out.println("\nAgain? Hit 'n' to quit.");
            choice = input.next().charAt(0);
    } while (choice != 'n' && choice != 'N'); //until the user inputs a n or N, the loop continues
    
    System.out.print("Goodbye!"); //indicates program ended
}

}
