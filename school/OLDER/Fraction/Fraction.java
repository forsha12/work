import java.util.Random;
/**
 * Fraction Class
 * Holds two integers to act as a numerator and denominator.
 * Multiple methods within to manipulate fractions.
 * 
 * 
 * @author Paige Forsha 
 * @version 3/21/17
 */
public class Fraction
{
    // instance variables - replace the example below with your own
    private int num;
    private int denom; 
    

   /**
    * No args constructor
    * setting all to zero except denominator because it CAN'T equal zero. (it'll be 1 here)
    */
    public Fraction()
    {
       num = 0;
       denom = 1;
   
    }

   /**
    * Constructor that takes args.
    */
   public Fraction(int inNum, int inDenom)
   {
       num = inNum;
       if (inDenom != 0) //denominators will never equal zero
       {
           denom = inDenom;
       }
    }
    
    /**
     * Adds two fractions together.
     * 
     * @param a Fraction
     * @return a Fraction that is the sum of two fractions
     */
    public Fraction add(Fraction f)
    {
        int newNum;
        int newDenom;
        int gcd; 
        newDenom = this.denom * f.denom; //the new denominator found 
        newNum = (this.num * f.denom) + (f.num * this.denom); //adds numerators after making them equal to what they'd be if the denominators were equal
        
        gcd = gcd(newNum, newDenom);
        
        newNum /= gcd;
        newDenom /= gcd; //simplifying
        
        return new Fraction (newNum, newDenom);
    }
    
     /**
     * Subtracts two fractions.
     * 
     * @param a Fraction
     * @return a Fraction that is the difference between the two fractions
     */
    public Fraction subtract(Fraction f)
    {
        int newNum;
        int newDenom;
        int gcd; 
        
        newDenom = this.denom * f.denom; //need same denominator
        newNum = (this.num * f.denom) - (f.num * this.denom); //subtracts numerators as if the fractions had the same denominators
        
        gcd = gcd(newNum, newDenom);
        
        newNum /= gcd;
        newDenom /= gcd; //simplfying
        
        return new Fraction (newNum, newDenom);
    }
    
    /**
     * Takes two fractions and multiples them, 
     * 
     * @param a Fraction
     * @return a new Fraction which is the product
     */
    public Fraction multiply(Fraction f)
    {
        int newNum;
        int newDenom;
        int gcd;
        newNum = this.num * f.num;
        newDenom = this.denom * f.denom; //multiplying across
        
        gcd = gcd(newNum, newDenom);
        
        newNum /= gcd;
        newDenom /= gcd; //simplify
        
        return new Fraction (newNum, newDenom);
    }
    
    
    /**
     * Takes two fractions and divides.
     * 
     * @param a Fraction
     * @return new Fraction that is the result of dividing the two fractions.
     */
    
    public Fraction divide(Fraction f)
    {
        int newNum;
        int newDenom;
        int gcd;
        
        newNum = this.num * f.denom;
        newDenom = this.denom * f.num; //flip second fraction and divide across
        
        gcd = gcd(newNum, newDenom); 
        
        newNum /= gcd;
        newDenom /= gcd; //simplfying
        
        return new Fraction (newNum, newDenom);
    }
    
    
    /**
     * Compares two fractions.
     * >>>>> HOW? Compares numerators as if they were part of two different fractions that had equal denominators.
     * 
     * @param a fraction
     * @return an int describing Less than, Equal to, or Greater than. -1, 0, 1.
     */
    public int compareTo(Fraction f)
    {
        int result;
        int newFNum;
        int newThisNum;
        
        newThisNum = this.num * f.denom; 
        newFNum = f.num * this.denom; //replicating multiplying criss-cross, getting two integers as a result
        
        if (newThisNum > newFNum)  //comparing those two integers to compare the fractions
            result = 1;
        else if (newThisNum == newFNum)
            result = 0;
        else 
            result = -1;
        
        return result;
    }
    
    /**
     * Finds a number the greatest number that numerator and denominator are divisible by so that 
     * the numbers can be reduced for the proper simplified fraction output.
     * 
     * @param two ints, the numerator and denominator of a fraction
     * @return a int that is the greatest common denominator
     */
    private int gcd(int n, int d) 
    {
        int gcd = 1; // the lowest the gcd can be is 1
        
        
       
            
        
            for (int k = 2; k <= n && k <= d; k++) //
            {   
                if (n % k == 0 && d % k == 0)
                        gcd = k;
            }
        
        return gcd;
     }
         
           
    /**
     * Gives the answer to "Are these two fractions equal?". 
     * 
     * @param a Fraction
     * @return true or false depending on the values of the two Fractions
     */
    public boolean equals(Fraction f)
    {
        int gcd; //to reduce the fractions
        
        
        gcd = gcd(this.num, this.denom); 
        
        this.num /= gcd;
        this.denom /= gcd; //reducing first fraction
        
        gcd = gcd(f.num, f.denom); 
        
        f.num /= gcd;
        f.denom /= gcd; //reducing second fraction
        
        if (this.num == f.num && this.denom == f.denom)  //compares the two after simplified
            return true;
        else 
            return false;
        
    } 
    
    /**
     * Changes fraction to a decimal.
     * 
     * @param none
     * @return a double equivalent to the fraction
     */
    public double toDouble()
    {
        return (double)this.num / (double)this.denom;
    }
    
   
    
    /**
     * Makes a copy object of the original
     * 
     * @param none
     * @return a new Fraction that has the exact same values as the original
     */
    public Fraction copy()
    {
        return new Fraction (this.num, this.denom);
    }
    
    /**
     * Generates a random fraction that is greater than 0 and less than 1.
     * Picks integers out of 1 - 10 because no specific range was given other than the one described above
     * 
     * @param none
     * @return a new Fraction
     */
    public static Fraction random()
    {
      int newNum;
      int newDenom;
      
      newDenom = (int)(Math.random() * 10) + 1;
      
      do{
          newNum = (int)(Math.random() * 10) + 1;
        }
      while(newNum >= newDenom);
     
        return new Fraction(newNum, newDenom);
    }
    
    /**
     * ToString
     * Gives the status of the Fraction object. Also fixes the layout with negatives before printing.
     * 
     * @param none
     * @return a String representing the Fraction
     */
   public String toString()
   {
       if (denom < 0) //fixes the negative on the bottom
       {
           num *= -1;
           denom *= -1;
       }
       
       return num + "/" + denom;
    }
    
  
     
}
