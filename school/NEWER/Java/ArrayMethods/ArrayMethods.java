import java.util.Arrays;
import java.util.Random;

/**
 * Paige Forsha
 * 
 * ArrayMethods
 */

public class ArrayMethods {

    //***NOTE that these methods will change the array itself


    //part a, fill in this method
    public static void swapFirstAndLast(int[] values) {
        // save the first element to a temp var
        int temp = values[0];
        //move the last element to the first position
        values[0] = values[values.length-1];
        // now put the saved first element into the last position
        values[values.length-1] = temp;


    }

    //part b, fill in this method
    public static void shiftRight(int[] values) {
        int temp [] = new int [values.length];
        
        for (int i = 0; i < values.length; i++) //make a copy of values
        {
            temp [i] = values[i];
        }
        
        for (int i = 0; i < values.length; i++)
        {
            if (i == 0) //for when the last value needs to be moved to the front
            {
                values[0] = temp[values.length-1];
            }
            else //shifting values right
            {
                values[i] = temp[i-1]; 
            }
        }
   
    }

    //part c, set all even elements to 0.
    public static void setEvensToZero(int[] values) {
        
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] % 2 == 0) //if the number is even, set to zero
            {
                values[i] = 0;
            }
        }
    }

    //part d, replace each element except the first and last by larger of two 
    //around it
    public static void largerOfAdjacents(int[] values) {
        for (int i = 1; i <values.length-1; i++) //goes through each element except the first and last
        {
            //values[i+1] and values[i-1] are looked at, and values[i] is changed to the larger one of the two
            if (values[i+1] > values[i-1]) //when the right one is greater
            {
                values[i] = values[i+1];
            }
            else if (values[i-1] > values[i+1]) //when left value is greater
            {
                values[i] = values[i-1];
            }
            else //when both sides are the same, it doesn't matter which it is changed to
            {
                values[i] = values[i+1];
            }
        }
    }

    //part e, remove middle el if odd length, else remove middle two els.
    public static int[] removeMiddle(int[] values) {
        //replace the following line with your answer
        //this line needed to compile
        int[] shorterArray; //needed for when the middle value is going to be deleted
        int middleIndex = values.length / 2; //gives a index to work with for deleting the middle
        int shorterArrayIndex = 0; //used for counting what index we're on when adding to the new array
        if (values.length % 2 == 0) //if it is even length
        {
            shorterArray = new int[values.length - 2]; //because we're deleting 2 numbers
            
            for (int i = 0; i < values.length; i++) //goes through values
            {
                if (!(i == middleIndex || i == middleIndex-1)) 
                //this will pass over the two middle numbers. EX: length of 8. middleIndex = 4,. position 3 and 4 are the middle
                {
                    shorterArray[shorterArrayIndex] = values[i]; 
                    shorterArrayIndex++; //moves the index position up any time a number is added to the array
                }
                
            }
            
        }
        else //odd lengths
        {
            shorterArray = new int[values.length - 1]; //because we're deleting 1 number
            
            for (int i = 0; i < values.length; i++) //goes through values
            {
                if (!(i == middleIndex)) //when it's not the middle index 
                {
                    shorterArray[shorterArrayIndex] = values[i]; 
                    shorterArrayIndex++; //moves the index position up any time a number is added to the array
                }
                
                
            }
            
        }
        return shorterArray;
    }

    //part f - move all evens to front
    public static void moveEvensToFront(int[] values) {
       int[] tempEvens = new int[values.length];
       int[] tempOdds = new int[values.length]; //for sorting
       int tempEvensIndexCounter = 0;
       int tempOddsIndexCounter = 0;
       
       int counterForFill = 0; //just for adding the odds to the end
       for (int i = 0; i < values.length; i++) //goes through each and sorts evens and odds
       {
           if (values[i] % 2 == 0) //if number is even, put it in a temp array
           {
               tempEvens[tempEvensIndexCounter] = values[i];
               tempEvensIndexCounter++;
           }
           else //if number is odd, put it in a separate array from the evens
           {
               tempOdds[tempOddsIndexCounter] = values[i];
               tempOddsIndexCounter++;
           }
        }
        
        
       for(int e = 0; e < values.length; e++) //puts in all the evens
       {
          values[e] = tempEvens[e];
       }
       for(int n = tempEvensIndexCounter; n < values.length; n++) //fills in rhe odds
       {
           values[n] = tempOdds[counterForFill];
           counterForFill++;
           
       }
        
        
    }

    //part g - return second largest element in array
    public static int ret2ndLargest(int[] values) {
        
        int largest = values[0];
        int secondLargest = 0;
        
        for(int i = 1; i < values.length; i++)
        {
            if (values[i] > largest)
            {
                secondLargest = largest; //moves the previously largest number to the second largest number spot
                largest = values[i];
            }
        }
        return secondLargest; 
    }

    //part H - returns true if array is sorted in increasing order 
    public static boolean isSorted(int[] values) {
        boolean isSorted = true; //default is true here, as we are testing to disprove it is sorted
        int largest = values[0];
        int smallest = values[0]; //both are for checking the end points
        
        for(int i = 1; i < values.length; i++) //finding the largest value
        {
            if (values[i] > largest) 
            {
                largest = values[i];
            }
        }
        if (values[values.length-1] != largest) 
        //if the largest is NOT at the last position, it's not sorted
        {
            isSorted = false;
        }
        
        for(int i = 1; i < values.length; i++) //finding the smallest value
        {
            if (values[i] < smallest) 
            {
                smallest = values[i];
            }
        }
        if (values[0] != smallest) 
        //if the smallest is NOT in the first position, it's not sorted
        {
            isSorted = false;
        }
        
        for (int i = 1; i < values.length-1; i++) //checking the middle values now
        {
            if (!(values[i-1] <= values[i] && values[i] <= values[i+1])) 
            //if the numbers aren't least to greatest, then it isn't sorted. accounts for duplicates
            {
                isSorted = false;
            }
        }
        
        return isSorted; 
    }

    //PART I - return true if array contains 2 adjacent duplicate values

    public static boolean hasAdjDuplicates(int[] values) {
        boolean hasAdjDups = false; //sets the default answer, a no
        for (int i = 1; i <values.length-1; i++) //starts from second number, goes through the middles
        //this way it won't break the code
        {
            if (values[i] == values[i+1] || values[i] == values[i-1]) //if the value matches the value to the left or right
            {
                hasAdjDups = true; //updates to say Yes, there is adjacent duplicates here
            }
        }
        return hasAdjDups; //dummy return value
    }


    //PART J - return true if array contains 2 duplicate values
    //duplicates need not be adjacent to return true

    public static boolean hasDuplicates(int[] values) {
        boolean hasDups = false; //setting a default value
        int counter = 1; //for the starting value of the search for duplicates
        for(int i = 0; i < values.length; i++) //going to check FOR every value
        {
                for(int k = counter; k < values.length; k++) //checking THROUGH every value, starting from the second
                {
                    if (values[i] == values[k]) //if value we're looking at matches the one we're looking for
                    {
                        hasDups = true;
                    }
                }
                counter++; //to avoid comparing values[2] with value[2] and so on when going into the nested for loop
        }
        
        return hasDups; 
    }
}
