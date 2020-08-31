/*
 * Author: Paige Forsha
 * Date: 10/4/16
 * Program: Distance
 * Description: This program asks a user for two coordinates  for one point,
 * 				and then two more for a second point. It then takes these values and calculates
 * 				the distance between the two points. It prints this result for the user.
 */
import java.util.Scanner;
public class Distance {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //scanner created
		double x1;
		double y1; //two coordinates for the first point
		double x2;
		double y2; //two coordinates for the second point
		double distance; //to hold value for distance for printed statement at the end
		
		System.out.println("This program will find the distance between two points. \n Enter the first x coordinate: " );
		x1 = input.nextDouble(); //asks user for first x coordinate and stores it
		
		System.out.println("Now the y coordinate: ");
		y1 = input.nextDouble(); //asks user for first y coordinate and stores it
		
		System.out.println("Please enter the x coordinate for the second point: ");
		x2 = input.nextDouble(); //asks user for second x coordinate and stores it
		
		System.out.println("Now the y coordinate: ");
		y2 = input.nextDouble(); //asks user for second y coordinate and stores it
		
		distance = Math.sqrt((Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2))); //finds the distance
		
		System.out.println("The distance between the points (" + x1 + "," +  y1 + ") and (" + x2 + "," +  y2 + ") is " + distance);
		//restates user input and tells them the distance between the two points
	}

}
