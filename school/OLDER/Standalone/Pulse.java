/**
 * 
 */

/**
 * Program: Pulse
 * Author: Paige Forsha
 * Date: 9/11/16
 * Purpose: This program takes the user's age and finds the training zone for the maximum aerobic effect during exercise.
 *          Once it gets the users age, it subtracts that number for 220. It will then find 72% and 87% of that number to find the low and high range of the training zone.
 *          It will then print a statement to the console informing the user of the results.
 *
 */
import java.util.Scanner;
public class Pulse {

	public static void main(String[] args) {
		int age;
		double trainingZone;
		double lowRange;
		double highRange;   //declares variables to be used in the program
		Scanner input; 
		
		input = new Scanner(System.in);  //creates a scanner to retrieve user's age
		
		System.out.println("To find your training range of your pulse rate, enter your age:"); //prompts user for their age
		
		age = input.nextInt();  //stores user's age in variable
		
		trainingZone = 220 - age;  //finds the initial training zone
		
		lowRange = trainingZone * .72;
		highRange = trainingZone * .87;  //finds the low and high range of the training zone
		
		System.out.println("The low range of your training zone will be " + lowRange + ", and the high range will be " + highRange + ".");
		//prints statement for user
		
		
	}

}
