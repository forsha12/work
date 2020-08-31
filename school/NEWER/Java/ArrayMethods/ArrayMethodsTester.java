import java.util.Arrays;
import java.util.Random;


public class ArrayMethodsTester {

    //helper method to print an array
    public static void printArray(int[] values) {
        System.out.println(Arrays.toString(values));
    }
    public static void main(String[] args) {

        //In your main method you should test your array methods
        //Create an array of size 10
        int[] a = new int[10]; //array of size 10
        int [] b = new int[5]; //odd array for testing removeMiddle
        //**** Fill the array with random values (use a loop, and a
        //Random object)
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) 
        {
            a[i] = rnd.nextInt(10);
          }
        
          for (int i = 0; i < b.length; i++) //filling array b for later
        {
            b[i] = rnd.nextInt(10);
          }
          
        //Now print the array to show initial values
        System.out.println("Initial Array:");
        //note the usage of the "toString()" method here to print the array
        System.out.println(Arrays.toString(a));
        //Could replace the previous line with this:
        //printArray(testValues);
        //blank line
        System.out.println();


        //Test methods below this line.

        

        //Test of swapFirstAndLast()
        System.out.println("Before call to swapFirstAndLast():");
        printArray(a);
        //swap first and last element
        //this method modifies the array referenced by "testValues"
        ArrayMethods.swapFirstAndLast(a);
        System.out.println("After call to swapFirstAndLast():");
        printArray(a); //printing the same array but it has changed
        System.out.println();
        
        System.out.println("Before call to shiftRight():"); //before call
        printArray(a);
        ArrayMethods.shiftRight(a);
        System.out.println("After call to shiftRight():"); 
        printArray(a); //printing the same array but it has changed
        System.out.println();
        
        System.out.println("Before call to setEvensToZero():"); //before call
        printArray(a);
        ArrayMethods.setEvensToZero(a);
        System.out.println("After call to setEvensToZero():"); 
        printArray(a); //printing the same array but it has changed
        System.out.println();
        
        System.out.println("RESETTING ARRAY. New array created:"); 
        for (int i = 0; i < a.length; i++) //making a new array so its easier to test. setEvensToZero makes it difficult
        {
            a[i] = rnd.nextInt(10);
          }
        printArray(a);
        System.out.println();
        
        System.out.println("Before call to largerOfAdjacents():"); //before call
        printArray(a);
        ArrayMethods.largerOfAdjacents(a);
        System.out.println("After call to largerOfAdjacents():"); 
        printArray(a); //printing the same array but it has changed
        System.out.println();
        
        System.out.println("RESETTING ARRAY. New array created:"); 
        for (int i = 0; i < a.length; i++) //making a new array so its easier to test. largerOfAdjacents makes it difficult
        {
            a[i] = rnd.nextInt(20);
          }
        printArray(a);
        System.out.println();
        
        
        System.out.println("Before call to removeMiddle():"); //before call
        printArray(a);
        System.out.println("This is an odd array with the middle removed: ");
        printArray(ArrayMethods.removeMiddle(a));
        System.out.println();
        
        System.out.println("Before call to removeMiddle():"); //before call
        printArray(b);
        System.out.println("This is an even array with the middle removed: ");
        printArray(ArrayMethods.removeMiddle(b));
        System.out.println();
        
        System.out.println("Before call to moveEvensToFront():"); //before call
        printArray(a);
        ArrayMethods.moveEvensToFront(a);
        System.out.println("After call to moveEvensToFront():"); 
        printArray(a); //printing the same array but it has changed
        System.out.println();
        
        System.out.println("Array being tested in ret2ndLargest():"); //before call
        printArray(a);
        System.out.println("This is the second largest value: " + ArrayMethods.ret2ndLargest(a));
        System.out.println();
        
        
        System.out.println("Array being tested in isSorted():"); //before call
        printArray(a);
        System.out.println("This array is sorted. True or False? \n" + ArrayMethods.isSorted(a));
        System.out.println();
        
        System.out.println("Array being tested in isSorted():"); //before call
        Arrays.sort(a); //for a sorted test
        printArray(a);
        System.out.println("This array is sorted. True or False? \n" + ArrayMethods.isSorted(a));
        System.out.println();
        
        //resetting a
        System.out.println("RESETTING ARRAY. New array created:");
        for (int i = 0; i < a.length; i++) //making a new array so its easier to test. setEvensToZero makes it difficult
        {
            a[i] = rnd.nextInt(10);
          }
        printArray(a);
        System.out.println();
        
        System.out.println("Array being tested in hasAdjDuplicates():"); //before call
        printArray(a);
        System.out.println("This array has adjacent duplicates. True or False? \n" + ArrayMethods.hasAdjDuplicates(a));
        System.out.println();
        
        System.out.println("Array being tested in hasDuplicates():"); //before call
        printArray(a);
        System.out.println("This array has duplicates. True or False? \n" + ArrayMethods.hasDuplicates(a));
        System.out.println();

        


        




    }

}
