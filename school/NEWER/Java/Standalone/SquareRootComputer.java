import java.util.Scanner;

/**
 * Greek's method to approximate the square root of a given number.
 */
public class SquareRootComputer {
    public static void main(String[] args) {
        // this is your tester
        // read a value from the user and print the results 
        // along with expected value
        Scanner in = new Scanner(System.in); //for input
        double input; //to hold user input
        
        System.out.print("Enter a number: " );
        input = in.nextDouble();
        
        System.out.printf("The square root of " + input + " is " + "%.5f" + "\n", squareRoot(input));
        System.out.printf("Expected Value: " + "%.5f" + "\n", Math.sqrt(input));
        
        
    }

    public static double squareRoot(double x) {
        return squareRootGuess(x, x-1); //calling helper method
    }

    private static double squareRootGuess(double x, double g) {
        
        double compareValue; //to hold difference between g^2 and x
        double betterGuess; //to hold the better guess
        
        compareValue = Math.abs(x-Math.pow(g,2));
        if (compareValue <= .0001) //base case
            return g;
        else //recursive case
        {
            betterGuess = (g + x/g)/2;
            return squareRootGuess(x, betterGuess);
        }
    
  
    }
}