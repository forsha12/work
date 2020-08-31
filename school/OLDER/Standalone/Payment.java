/**
 * 
 */

/**
 * Program: Payment
 * Author: Paige Forsha
 * Date: 9/11/16
 * Purpose: This program is used to find out more information on a user's loan. 
 * It asks for the users annual interest rate, number of payments, and total loan amount.
 * It converts annual interest rate to monthly interest rate. It finds the monthly payment amount using the information it is given.
 * It will also find the amount paid by the user and the amount of interest that the user paid.
 * After it finds out the information, it prints the user's loan amount, monthly interest rate, total amount paid back, and interest paid to the console for the user.
 * 
 *
 */
import java.util.Scanner;
public class Payment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double annualInterestRate;
		double monthlyInterestRate;
		double monthlyPayment;
		int numberOfPayments;
		double loanAmount;
		double amountPaidBack;
		double interestPaid;  //declaring all variables needed for later use
		
		Scanner annual;
		Scanner loan;
		Scanner numOfPayments; //creates scanners for user's information
		
		System.out.println("We are going to find out information about your loan."); //lets user know what's going on in the program
		
		annual = new Scanner(System.in);
		System.out.println("Please enter your annual interest rate as a percentage (leave out the percentage sign): "); //asks user for interest rate, making sure to let them know how to enter the data
		
		annualInterestRate = annual.nextDouble();  //takes user input and stores it for annual interest rate
		
		monthlyInterestRate = (annualInterestRate / 12.0) / 100.0;  //takes user's annual interest rate and converts it to monthly, then makes it into a decimal that the program can use
		
		loan = new Scanner(System.in);
		System.out.println("Please enter your loan amount: "); //prompts user for total loan amount
		
		loanAmount = loan.nextDouble();  //takes user input and stores it loan amount
		
		numOfPayments = new Scanner(System.in);
		System.out.println("Please enter your number of payments: "); // gets user to enter number of payments
		
		numberOfPayments = numOfPayments.nextInt();  //takes user input and stores in for number of payments
		
		monthlyPayment = ((monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments)) / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1)) * loanAmount;  // finds users monthly payment
		
		amountPaidBack = monthlyPayment * numberOfPayments;  //finds total amount paid back
		
		interestPaid = amountPaidBack - loanAmount;  //finds amount of interest paid by the user
		
		System.out.println("Loan Amount: " + loanAmount + " ");
		System.out.println("Monthly Interest Rate: " + monthlyInterestRate * 100 + "%");
		System.out.println("Number of Payments: " + numberOfPayments + " ");
		System.out.println("Monthly Payment: " + monthlyPayment + " " );
		System.out.println("Amount Paid Back: " + amountPaidBack + " ");
		System.out.println("Interest Paid: " + interestPaid + " ");    //prints all information clearly for the user
		
		
		
		
	}

}
