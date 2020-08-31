/**
 * 
 */

/**
 * @author Paige Forsha
 * 9/6/16
 * 
 * This program prompts the user to give a speed in kilometers. 
 * It then converts the user input to miles.
 * It prints a statement to the console to explain the conversion.
 * 
 * 
 * 
 */
import java.util.Scanner;
public class KilometersToMiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double miles, kilometers; 
		Scanner input; 
		
		input = new Scanner(System.in);
		
		System.out.println("Enter a speed in kilometers:"); //prompts user input
		kilometers = input.nextDouble();
		input.close(); //closing Scanner
		
		miles = kilometers * 0.621; //takes user input and converts it to miles
		
		
		System.out.println(kilometers + "km equals " + miles + " in miles."); 
		
	}

}
