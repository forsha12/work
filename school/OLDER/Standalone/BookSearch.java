/**
 * 
 */

/**
 * @author Paige Forsha
 * @version 12/6/16
 * Program: BookSearch
 * Description: This program allows the user to choose from a menu to do an action 
 * 				concerning a list of books in a book store.
 * 
 * Notes: I spent 40 minutes trying to get the cost column to line up and I could not figure it 
 * 		out. I gave up. Sorry if we were supposed to know that ??
 *
 */
import java.util.Scanner;
public class BookSearch 
{
	public static void main(String[] args) 
	{
		
		String[] bookTitle	= {  "Java Programming", "Starting out with Java",
				"Software Structures", "Design and Analysis of Algorithms", 
				"Computer Graphics", "Artifical Intelligence: A Modern Approach",
				"Probability and Statistics", "Cognitive Science", 
				"Modern Information Retrieval", "Speech and Language Processing"};
		int[]	bookID =	{	1211, 1212,	1333,	1456,	1567,	1642,	1699,	1755,	1800,	1999};	
				
		double[]	bookPrice =	{	73.25, 112.32,	54.00,	67.32,	135.00,	173.22,	120.00,	42.25,	32.11,	
				123.75};
		int choice = 0; //stores user's menu choice 
		Scanner input = new Scanner(System.in);
		int search; //stores user's searched book
		int result; //stores what the searches found and returned
		int copies; //the amount of books the user decides to buy
		double total;
		int [] arr = new int[1000]; // for options 3 and 4, stores an array of random numbers made by createRandomArray()
		
		do 
		{
			printMenu();
			System.out.print("Please enter a number between 1-5: ");
			choice = input.nextInt();
			
			switch(choice) 
			{
			case 1: //linear search
				System.out.println("\n**** LINEAR SEARCH ****\n\n");
				display(bookTitle, bookID, bookPrice);
				
				System.out.print("Please enter the book ID you wish to purchase from the list above: ");
				search = input.nextInt();
				
				result = linearSearch(bookID, search); //runs the method

				if (result == -1)
				{
					System.out.println("The book was not found.\n");
				}
				else 
				{
					System.out.print("How many copies do you wish to purchase? ");
					copies = input.nextInt(); //storing copy amount
					
					total = copies * bookPrice[result]; //calculates total price
					
					System.out.print("\nBook ID: " + search + "\nBook Title: " + bookTitle[result] + "\nNomber of books bought: "
							+ copies + "\nTotal Cost: $" + total + "\n\n"); //prints data
				}
						
				
				break;
			case 2: //binary search
				System.out.println("\n**** BINARY SEARCH ****\n\n");
				display(bookTitle, bookID, bookPrice);
				
				System.out.print("Please enter the book ID you wish to purchase from the list above: ");
				search = input.nextInt();
				
				result = binarySearch(bookID, search);
				
				if (result == -1)
				{
					System.out.println("The book was not found.\n");
				}
				else 
				{
					System.out.print("How many copies do you wish to purchase? ");
					copies = input.nextInt(); //storing copy amount
					
					total = copies * bookPrice[result]; //calculates total price
					
					System.out.print("\nBook ID: " + search + "\nBook Title: " + bookTitle[result] + "\nNomber of books bought: "
							+ copies + "\nTotal Cost: $" + total + "\n\n"); //prints data
				}
				break;
			case 3: //bubble sort
				System.out.println("\n**** BUBBLE SORT ****\n\n");

				arr = fillRandomArray(arr); //fills the array
				
				System.out.println("The unsorted array is: "); 
				
				for(int k = 0; k < arr.length; k++) //printing unsorted array
				{
					System.out.print(arr[k] + " ");
					
				}
				
				bubbleSort(arr); //sends unsorted array to be sorted
				
				System.out.println("\n\nThe sorted array is: "); 
				for(int k = 0; k < arr.length; k++) //printing sorted array
				{
	
					System.out.print(arr[k] + " ");
				}
				System.out.println("\n");
				

				
				
				break;
			case 4: //selection sort
				System.out.println("\n**** SELECTION SORT ****\n\n");
				
				arr = fillRandomArray(arr); //fills the array
				
				System.out.println("The unsorted array is: "); 
				
				for(int k = 0; k < arr.length; k++) //printing unsorted array
				{
					System.out.print(arr[k] + " ");
					
				}
				
				selectionSort(arr); //sends unsorted array to be sorted
				
				System.out.println("\n\nThe sorted array is: "); 
				for(int k = 0; k < arr.length; k++) //printing sorted array
				{
	
					System.out.print(arr[k] + " ");
				}
				System.out.println("\n");

				break;
			case 5: //quit
				System.out.println("\nGoodbye!"); //message to indicate program is over
				break;
			default: //invalid
				System.out.println("\nInvalid Option.\n");
				break;
			}
		} while (choice != 5); //program continues until user enters Quit (5)
		
		
		

		

	}
		
				
	public static void display(String[] s, int[] i, double[] d) //takes in all arrays, prints in chart
	{
		System.out.print("Book ID\t\t\tTitle\t\t\t\t\tCost\n\n"); //labels for columns
		
		for(int k = 0; k < i.length; k++) //all arrays had the same length
			System.out.println(i[k] + "\t\t" +  s[k] + "\t\t\t\t" + d[k] +"\n" );
	}
	
	public static void printMenu() //prints menu
	{
		System.out.println("1. Linear Search\n\n2. Binary Search\n\n3. Bubble Sort\n\n4. Selection Sort\n\n5. Quit\n");
	}
	
	public static int linearSearch(int[] id, int searched) //linear searching
	{
		boolean found = false;
		int position = -1; //the position of the ID is set to -1
		
		for(int k = 0; k < id.length && !found; k++) 
		{
			if (id[k] == searched) //if the search is found
			{
				found = true;
				position = k; //position is reset to k
			}
		}
		return position; //returns where the ID was found
	}
	
	public static int binarySearch(int[] id, int searched) //binary searching
	{
		boolean found = false;
		int position = -1; //the position of the ID is set to -1
		
		
		int low = 0;
		int high = id.length - 1;
		int mid;
		
		
		while (high >= low)
		{
			mid = (low + high) / 2;
			if (searched == id[mid]) //once the number at midpoint IS the searched, position is reset to that subscript
			{
				position = mid;	 
				found = true;
				  
			}
			if (searched < id[mid]) //changes the high num to the num right below the mid IF the search is lower than the mid
			{
			high = mid - 1;
			}
			
			else //if the search is not found, low is reset
				{
				low = mid + 1;
				}
			
			
		}	    
			  
		return position; //returns where the ID was found
	}
	
	public static int [] fillRandomArray(int [] arr) //fills array
	{
		for (int k = 0; k < arr.length; k ++)
			arr[k] = (int)((Math.random() * 500) + 1);
		
		return arr;
	}
	
	public static int [] bubbleSort(int [] arr) //bubble sorting
	{
	    int temp = 0;
	       
	    for(int k=0; k < arr.length; k++) //compares elements next to each other
	    {
		    for(int j=1; j < (arr.length-k); j++)
			    {                  
			    if(arr[j-1] > arr[j]) //swapping elements
			    {                          
				    temp = arr[j-1];
				    arr[j-1] = arr[j];
				    arr[j] = temp;
			    }  
		    }
	    }
		return arr;	
	}
	
	public static int [] selectionSort(int [] arr) //selection sorting
	{
		int min; //for sorting
		int minIndex; //for sorting
		
		for (int k = 0; k < arr.length - 1; k++) //each pass moves the smallest number to its proper position
		{
			min = arr[k];
			minIndex = k;
			   
			for (int j = k + 1; j < arr.length; j++) 
			{
				if (min > arr[j]) //locating smallest num
				{
					min = arr[j];
					minIndex = j;
				}
			}
			  
			if (minIndex != k) //swapping positions
			{
			arr[minIndex] = arr[k];
			arr[k] = min;
			}
			
		}
		return arr; //sends back the sorted array
	}
	

}
