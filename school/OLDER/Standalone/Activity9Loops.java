
/**
 * @author Paige Forsha, Alexander Roy, William Cottle, Michael Watson, Epiphany Wilcox
 * @version 10/20/16
 * Description: The first part simply prints pairs of numbers that add to zero, 
 * like so: 0 100
 * 			1 99 ... and so on.
 * 
 * The second part takes the user's input for a value of a numerator and a denominator. 
 * It takes those values and creates a fraction. 
 * It then simplifies the fraction and prints it to the console.
 * Name: Activity9Loops. 
 *
 */

import java.util.Scanner;
public class Activity9Loops 
{

	public static void main(String[] args) 
	{
		int k;
		int j;
		
		System.out.println("Part 1:\n");
		for (k = 0, j = 100; k <= 100; k++, j--) 
			{
			System.out.print(k + " " + j + "\n"); //prints the pairs
			} //loops until k gets to 0, j will also reach 0 by that point
			
		System.out.println("-------------\nPart 2:\n"); //divides up the program
		
		
		int numerator = 0;
		int denominator = 0;
		int smallest = 0;
		int largest = 0; 
		int num;
		int dom; //these two are just for the print statement at the end
		Scanner input = new Scanner(System.in); //variables
		
		System.out.print("Enter the numerator (enter -1 to exit): "); 
		numerator = input.nextInt(); //gets numerator
		num = numerator;
		System.out.print("Enter the denominator: ");
		denominator = input.nextInt(); //gets denominator
		dom = denominator;
		
		while (numerator != -1) //this loop will not run if numerator = -1
		{
			if (numerator < denominator) 
			{
			smallest = numerator;
			}
			else 
			{
			smallest = denominator;	
			}
			//determines the smallest value
			while(numerator % smallest != 0 || denominator % smallest != 0) 
			{ 
				smallest--;
			} //decrements smallest to find GCD
			
			numerator = numerator/smallest;
			denominator = denominator/smallest; //setsthe num and dom for the simple form
			
			if (smallest == 1) 
			{
				System.out.print(num + "/" + dom + " is in simple form\n\n");
			} //for whenever it is already simplified
			else
			{
				System.out.print(num + "/" + dom + " is simplified to " + numerator + "/" + denominator + "\n\n");
			} //all other cases
			
			
			System.out.print("Enter the numerator (enter -1 to exit): "); 
			numerator = input.nextInt();
			num = numerator;
			System.out.print("Enter the denominator: ");
			denominator = input.nextInt();
			dom = denominator;//updates info
			
			
		}
		System.out.println("Goodbye!");
	}

}



