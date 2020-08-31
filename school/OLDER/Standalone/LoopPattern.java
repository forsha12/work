import java.util.Scanner;
public class LoopPattern {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int limit;
		int numOfLine;
		int i; //counter
		
		System.out.print("Enter an integer to be a limit of the pattern:");
		limit = input.nextInt();
	
		
		// pattern a
		
		  System.out.print("Pattern A:\n");
		  for (i = 1; i <= limit; i++) {
		 
		   
		   for (numOfLine = 1; numOfLine <= i; numOfLine++) {
		    System.out.print(numOfLine + " ");
		   }
		   System.out.println();
		 
		  }
		  
		
		  
		  //pattern b
		  System.out.println("\nPattern B:");
		  for (i = 0; i < limit; i++) {
		 
		   
		   for (numOfLine = 1; numOfLine <= limit - i; numOfLine++) {
		    System.out.print(numOfLine + " ");
		   }
		   System.out.println();
		  }
		
		// pattern c
			
		  System.out.println("\nPattern C:");
		  for (i = 1; i <= limit; i++) {
		 
		   
		   for (numOfLine = i; numOfLine >= 1; numOfLine--) {
		    System.out.print(numOfLine  + " ");
		   }
		   System.out.println();
		 
		  }
	
		  
		  
		  
		  //pattern d
		  System.out.println("\nPattern D:");
		  for (i = 0; i < limit; i++) {
		 
		   
		   for (numOfLine = 1; numOfLine <= limit - i; numOfLine++) {
		    System.out.print(numOfLine + " ");
		   }
		   System.out.println();
		  }
		
		  
		
	}
}
