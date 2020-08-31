/**
 * 
 */

/**
 * @author Paige Forsha
 * @version 11/17/16
 * Description: This program creates a magic square. NOTE: It probably will look like an 
 * 				infinite loop, but it's not. It just takes a while for it to generate a Magic Square.
 *  
 * Pseudocode: The first part of this program prints the definition of a magic square. It then asks the user to
 * 				enter "start" to begin. This prompt loops until the user enters "start". 
 * 
 * 				The next part of the program is in a do-while loop, and it will repeat until
 * 				it finds a magic square. 
 * 
 * 				It calls fillMatrix first. This method generates 9 random numbers to fill the square array. 
 * 				It calls isUnique to test each number BEFORE adding it to the array. isUnique tests to 
 * 				see if an integer value is already found in an array.
 * 
 * 				Once an array with 9 unique numbers is generated, it prints this array (named square) 
 * 				to the console using the method displayMagicSquare. After displaying the square, the 
 * 				program prints 3 statements that give the user information about the square. These 
 * 				statements call these methods: sumRows, sumColumns, and sumDiagonals.
 * 
 * 				These three methods are very similar. Each adds up the elements in each row or column
 * 				or diagonal. After it does so, it checks to see if these sums are equal. In this program, 
 * 				everything should add up to 15. If all rows/columns/diagonals equal 15, the method returns 
 * 				that value. If they do not, it returns -1. 
 * 
 * 				The program then calls the method isMagicSquare to test whether or not the randomly
 * 				generated square is a Magic Square. This method checks to see if sumRows, sumColumns,
 * 				and sumDiagonals are equal. If they are equal, the square is a Magic Square, and the 
 * 				method returns true. If they are not, the square isn't magic, and the method returns false.
 * 				
 * 				All of the elements in the square array will then be set back to zero by use of the emptyMatrix method.
 * 				
 * 				The block of the do-while loop ends here, and if isMagicSquare returned true, the program will end.
 *
 */
import java.util.Scanner;
public class MagicSquare 
{
	public static void main(String[] args) 
	{
		int[][] square = new int[3][3]; //creates array that will be tested to see if it's a magic square
		Scanner input = new Scanner(System.in); //creates scanner for user input
		String start; //stores what the user inputs at the beginning
		boolean isMagic; //holds the value of isMagicSquare so i don't have to type as much
		
		System.out.println("A Magic Square is a matrix in which all rows, columns,\nand diagonals, when summing its integer elements, are equal.");
		do 
		{
			System.out.println("\nEnter start to begin the search!");
			start = input.nextLine();
		} while (!(start.equals("start"))); //makes sure the user enters "start" before proceeding 
		
		
		
		do 
		{
			
		fillMatrix(square);
		displayMagicSquare(square); //prints the square
		System.out.println("\nSum of Rows: " + sumRows(square));
		System.out.println("Sum of Columns: " + sumColumns(square));
		System.out.println("Sum of Diagonals: " + sumDiagonals(square)); //prints the data on that square
		
		isMagic = isMagicSquare(square);
		if (isMagic == true) //decides what statement is printed depending on whether it's a magic square or not
			System.out.println("Matrix is a Magic Square!!");
		else
			System.out.println("Matrix is not a Magic Square.\n");
	
		emptyMatrix(square); //resets elements so the code works
		} while (!isMagic); //keeps searching for a magic square until it finds one
		
		
		input.close(); //input closed
	}

static int sumRows(int[][]arr) 
{
	
	int row0Sum = 0; //for row 0
	int row1Sum = 0; //for row 1
	int row2Sum = 0; //for row 2
	int rowSum; //only used for return
	
	for(int k = 0; k < arr.length; k++) 
		row0Sum += arr[k][0];
	
	for(int k = 0; k < arr.length; k++) 
		row1Sum += arr[k][1];
	
	for(int k = 0; k < arr.length; k++) 
		row2Sum += arr[k][2];
	//each above checks for the individual rows
	
	if (!(row0Sum == row1Sum && row0Sum == row2Sum)) //if not all are equal, rowSum is set to -1 
		rowSum = -1;
	else 
		rowSum = row0Sum;
	
	return rowSum;
}
	
static int sumColumns(int[][]arr) 
{
	
	int col0Sum = 0; //for column 0
	int col1Sum = 0; //for column 1
	int col2Sum = 0; //for column 2
	int columnSum; //for return statement
	
	for(int k = 0; k < arr[0].length; k++) 
		col0Sum += arr[0][k];
	
	for(int k = 0; k < arr[1].length; k++) 
		col1Sum += arr[1][k];
	
	for(int k = 0; k < arr[2].length; k++) 
		col2Sum += arr[2][k];
	//each above checks for the individual columns
	
	if (!(col0Sum == col1Sum && col0Sum == col2Sum)) //if not all are equal, column sum is set to -1
		columnSum = -1;
	else 
		columnSum = col0Sum; 
	
	return columnSum;
}	

static int sumDiagonals(int[][] arr)
{
	int sumDiagT = 0; //holds value for the sum of the values in the diagonal that starts from the top (left to right)
	int sumDiagB = 0; //holds value for the sum of the values in the diagonal that starts from the bottom (left to right)
	int sumDiagonal; //only used for return
	
	sumDiagT = arr[0][0] + arr[1][1] + arr[2][2]; //adds first diagonal
	sumDiagB = arr[2][0] + arr[1][1] + arr[0][2]; //adds second diagonal
	
	if (sumDiagT == sumDiagB) //if the two equal, sumDiagonal is the sum of the diagonal. if not, it's -1
		sumDiagonal = sumDiagT;
	else 
		sumDiagonal = -1;
	
	return sumDiagonal;	
}

static boolean isUnique(int[][] arr, int num)
{
	boolean isUnique = true;
	
	for(int k = 0; k < arr.length; k++)
	{
		for(int i = 0; i < arr[k].length; i++) //goes through all and compares 
		{
			
			if (arr[k][i] == num)
				isUnique = false;
		}
		 
	}
	
	return isUnique;
}


static void displayMagicSquare(int arr[][]) 
{
	for(int k = 0; k < arr.length; k++)
	{
		for(int i = 0; i < arr[k].length; i++) 
		{
			System.out.print(arr[k][i] + "\t"); //prints all values
		}
		
		System.out.println(); //makes a new line for each row
	}
}

static int[][] fillMatrix(int[][] arr) 
{
	boolean unique; //holds value gotten by isUnique
	int number; //made to test value BEFORE adding it to the square to avoid infinite loops. >:(
	for(int k = 0; k < arr.length; k++)
	{
		for(int i = 0; i < arr[k].length; i++) //looping through all values
		{
			 
			do  //testing to make sure the value is unique
			{
				
				number = (int)((Math.random() * 9) + 1);
				
				unique = isUnique(arr, number);
				
				arr[k][i] = number; //giving each element a random 1-9 value
				
			} while (!unique); //repeats this until a value is unique
			
		}	
	}
	
	
	return arr; //gives back the same array, but with new elements
}

static int[][] emptyMatrix(int[][] arr) //resets all elements in square to 0
{
	for(int k = 0; k < arr.length; k++)
	{
		for(int i = 0; i < arr[k].length; i++) 
		{
			arr[k][i] = 0;
		}
		
	}
	return arr;
}

static boolean isMagicSquare(int[][] arr)
{
	boolean isMagic = false;
	
	 if (sumRows(arr) == sumColumns(arr) && sumRows(arr) == sumDiagonals(arr) && sumDiagonals(arr) > 0)
	 {
		isMagic = true; 
	 }
	
	return isMagic;
}

}
