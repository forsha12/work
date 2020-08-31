/**
 * 
 */

/**
 * @author Paige Forsha
 * @vers 10/19/16
 * Description: Part 1: Takes users numbers and determines whether they are prime until user inputs a "-1", prints answer for user
 * Part 2: Takes a max number from the user and tests if all numbers from 1 to the max are prime. Prints results for each
 *
 */
import java.util.Scanner;
public class PrimeNumbers {


	public static void main(String[] args) {
		int divisor; // divisors
		int number; // the number the user enters
		boolean isPrime = true; //to be able to print if it's prime or not, used in if statements
		Scanner input = new Scanner(System.in); //scanner
		int count; //for part 2 range
		
		//part 1
		System.out.println("Part 1: \nEnter number to see if it is a prime number. Enter -1 to exit: ");
		number = input.nextInt();
		
		while (number != -1) { 
		for (divisor = 2; divisor <= number / 2; divisor++) {
			          if (number % divisor == 0) {
			        	isPrime = false;  
			            System.out.println(number + " is not a prime.");	
			          	break; 
			          	}	//tests for prime numbers		          
			          	
			        }
		if (isPrime == true) {
				System.out.println(number + " is a prime."); //prints when number is prime
		}
		number = input.nextInt(); // asks user for another number
		isPrime = true; //sets isPrime back to true for testing
	}
		
	System.out.println("Part 2: \nEnter a max number to find all prime numbers between 1 and that number: ");
	number = input.nextInt(); //part 2 begins, gets max from user
	
	for (count = 1; count <= number; count++)	{
		for (divisor = 2; divisor <= count / 2; divisor++) {
	          if (count % divisor == 0) {
	        	isPrime = false;  
	            System.out.println(count + " is not a prime.");	
	          	break;
	          	}	//tests numbers up to max 		          
	          	
	        }
		if (isPrime == true) {
			System.out.println(count + " is a prime."); //if isPrime doesn't get changed to false, prints
		}
		isPrime = true; //resets variable
}
System.out.println("\nGoodbye!");		
	}

} 

