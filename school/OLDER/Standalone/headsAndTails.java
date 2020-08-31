import java.util.Scanner;
public class headsAndTails 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int state;  //holds user input
		String binary; //to hold the binary value of the integer given
		char[][] arr = new char [3][3]; //the matrix to be printed
		int count = 0; //for counting up the amount of characters in the binary string 
						//^^ and storing the binary string into the matrix
		do 
		{
			System.out.print("Enter an integer representing the state of the coins:");
			state = input.nextInt();
		} while (state < 0 && state > 511); //validates user input
		
		binary = Integer.toBinaryString(state); //stores the binary value of "state" into a string
		 
		
		while(binary.length() != 9) //adds zeros to the beginning of the binary string Until there are 9 characters
			binary = "0" + binary;
			
		
		binary = binary.replace('1','T'); //replacing values
		binary = binary.replace('0', 'H'); //replacing values in string
		
		
		
		
		
		for (int k = 0; k < arr.length; k++ ) //storing the binary string values into an array
		{
			for (int i = 0; i< arr[k].length; i++) 
			{
				
				arr[k][i] = binary.charAt(count);
				count++;
			}
		}
		
		for (int k = 0; k < arr.length; k++ )  //printing the array
		{
			for (int i = 0; i< arr[k].length; i++) 
			{
				
				System.out.print(arr[k][i] + " ");
				
			}
			System.out.println();
		}

		
		
	}

}
