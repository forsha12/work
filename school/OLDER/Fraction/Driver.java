
import java.util.Scanner;
/**
 * interactive tester class for Fraction method
 * 
 * @author Paige Forsha 
 * @version 3/21
 */
public class Driver
{
    public static void main (String [] args)
    {
        
        Scanner input = new Scanner(System.in);
        Fraction myFraction;
        Fraction theOtherFraction;
        char choice = 'n'; //to continue testing fractions without having to run the program over and over
        
        int numerator;
        int denominator; //for sending in because Fraction is immutable
        
        System.out.println("This will run your two fractions through every method. \nThe methods that only deal with one fraction will use your first fraction. \nInput like \"4 7\".");
        
        do{
        
            System.out.print("\nFirst fraction? ");
            numerator = input.nextInt();
            denominator = input.nextInt();
            
            myFraction = new Fraction(numerator, denominator); //makes first fraction
            
            System.out.print("\nSecond fraction? ");
            numerator = input.nextInt();
            denominator = input.nextInt();
            
            theOtherFraction = new Fraction(numerator, denominator); //second fraction made
            
            System.out.print("\n\noriginal fraction: " + myFraction.toString() + " other fraction: " + theOtherFraction.toString()); 
             
            /* tests all below
             * 
             */
    
            System.out.print("\nadd: " +myFraction.add(theOtherFraction).toString());
    
            System.out.print("\nsubtract: " +myFraction.subtract(theOtherFraction).toString());
            
            System.out.print("\nmultiply: " + myFraction.multiply(theOtherFraction).toString());
            
            System.out.print("\ndivide: " + myFraction.divide(theOtherFraction).toString());
            
            System.out.print("\ncompare to: " + myFraction.compareTo(theOtherFraction));
            
            System.out.print("\nequal? " + myFraction.equals(theOtherFraction));
            
            System.out.print("\nas double: " + myFraction.toDouble());
            
            System.out.print("\nrandom fraction : " + Fraction.random().toString());
            
            System.out.print("\na copy of original: " + myFraction.copy().toString());
            
            System.out.print("\n\nAgain? Enter 'y' for more.");
            choice = input.next().charAt(0);
         }while(choice == 'y');
    }
    
     
 
}
