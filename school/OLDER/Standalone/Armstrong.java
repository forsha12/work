/**
 * 
 */

/**
 * Author: Paige Forsha
 * Date:   10/2/16
 * Program: Armstrong
 * Purpose: To determine if a number is an Armstrong number or not
 * Description: This programs prompts a user to either pick a number with 1 to 4 digits or decide to let the program 
 * generate a random number between 1-9999. It takes the number and then tests to see if that number is an Armstrong number. 
 * It tests this by taking each digit to the power of the number of digits and adding all of those results together. 
 * If the sum is equal to the original number, the number is an Armstrong number. The program will print a statement to the console that tells the
 * user whether or not the number was an Armstrong number.
 */
import java.util.Scanner;
public class Armstrong {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //scanner created
		String userDecision; //variable to store user's input that can either be a number or the letter 'r' for random
		int num; //this is the number that will be tested
		String number; //holds same value as int num. this was created to be able to use the number in a switch statement to test how many digits the number has.
		int digit1;
		int digit2;
		int digit3;
		int digit4; //variables for all possible digits
		int sum = 0; //final product of test, will be compared to original number for results (used in switch statement, which is why it is set to 0 here)
		
		System.out.println("This program will determine whether or not a number is an Armstrong number. \n Enter your own number between 1 and 9999 or enter 'r' for a random number." );
		userDecision = input.nextLine(); //takes user input and stores it in userDecision
		
		if (userDecision.equals("r")) {
			num = (int)(Math.random() * 9999 + 1); //sets num to a random number between 1-9999
			System.out.println("Your number is " + num + ".");
		}
		else {
			num = Integer.parseInt(userDecision);  //sets num to the user's inputted number
		}	
		
		number = num + ""; //gives num's value to a string so that it may be tested in a switch statement
		

		switch (number.length()) { //tests for different amounts of digits BECAUSE each scenario will run slightly different equations
		
		case 1: //if there is ONE digit
			sum = (int)Math.pow(num, 1); //finds "sum" of the number to the power of 1
			break;
			
		case 2: //if TWO digits
			digit1 = Integer.parseInt(number.substring(0,1));
			digit2 = Integer.parseInt(number.substring(1,2)); //sets values for digits using string "number"
			sum = (int)(Math.pow(digit1, 2) + Math.pow(digit2, 2)); //adds digits to the power of number of digits, assigns to "sum" variable
			break;
			
		case 3: //if THREE digits
			digit1 = Integer.parseInt(number.substring(0,1));
			digit2 = Integer.parseInt(number.substring(1,2));
			digit3 = Integer.parseInt(number.substring(2,3)); //sets values for the digits using the string "number" 
			sum = (int)(Math.pow(digit1, 3) + Math.pow(digit2, 3) + Math.pow(digit3, 3)); //adds digits to the power of number of digits, assigns to "sum" variable
			break;
			
		case 4: //if FOUR digits
			digit1 = Integer.parseInt(number.substring(0,1));
			digit2 = Integer.parseInt(number.substring(1,2));
			digit3 = Integer.parseInt(number.substring(2,3));
			digit4 = Integer.parseInt(number.substring(3,4)); //sets values for digits using string "number"
			sum = (int)(Math.pow(digit1, 4) + Math.pow(digit2, 4) + Math.pow(digit3, 4) + Math.pow(digit4, 4)); //adds digits to the power of number of digits, assigns to "sum" variable
			break;
			
		default:
			System.out.print("Your number is NOT between 1 and 9999. Run the program again.");
			break;
		}
		
		if (sum == num) //tests if the sum is equal to the original number given. prints statements according to results.
			System.out.println("Your number is an Armstrong number.");
		else 
			System.out.println("Your number is not an Armstrong number.");
		
		System.out.println("Goodbye! Thanks for using the program."); //goodbye statement
	}

}
