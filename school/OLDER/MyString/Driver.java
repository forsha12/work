
/**
 *
 * A method not meant to be used by people other than those who are trying to 
 * make sure the MyString class works. Change the hard code to get different results. 
 *
 * 
 * @author Paige Forsha
 * @version 3/24/17
 */
public class Driver
{
    // change strings and MyStrings, along with some parameters for full testing
    // ((which is what i did))
    //make sure to alter your print statement with the parameters!!!!!
    
    public static void main (String[] args)
    {
    MyString one = new MyString("This is a test!");
    MyString two = new MyString("This is a TEST!");
  
    MyString three = new MyString("oh, it's okay!");
    
    String str = "This is a test!";
    String str2 = "This is a TEST!";
    String str3 = "It's okay!"; //for comparing my results with the REAL compareTo methods
    
    System.out.print("First MyString: " + one.toString() + "\nSecond: " + two + "\nThird: "
    + three);
    
    System.out.print("\n\nFirst char in MyString one: \n\t" + one.charAt(0)+ "\n");
    System.out.println();
    
    System.out.print("Concat of first and second: \n\t" + one.concat(two).toString()+ "\n");
    System.out.println();
    
    System.out.print("Does the first end with the third? \n\t" + one.endsWith(three)+ "\n");
    System.out.println();
    
    System.out.print("Does the first equal the third? \n\t" + one.equals(three)+ "\n");
    System.out.println();
    
    System.out.print("The index of 'i' in the first is: \n\t" + one.indexOf('i')+ "\n");
    System.out.println();
    
    System.out.print("The index of 'i' in the first from index 3 is: \n\t" + one.indexOf('i', 3)+ "\n");
    System.out.println(); 
    
    System.out.print("The last index of 'o' in the third is: \n\t" + three.lastIndexOf('o')+ "\n");
    System.out.println();
    
    System.out.print("The length of the first is: \n\t" + one.length()+ "\n");
    System.out.println();
    
    System.out.print("If we replace all 't' with 'X' in the first, we get: \n\t" + one.replace('t','X')+ "\n");
    System.out.println();
    
    System.out.print("Does the first start with the third? \n\t" + one.startsWithString(three)+ "\n");
    System.out.println();
    
    System.out.print("Substring of first, starting at index 5: \n\t" + one.substring(5)+ "\n");
    System.out.println();
    
    System.out.print("Substring of first, starting at index 4, end at index 6 : \n\t" + one.substring(4,6)+ "\n");
    System.out.println(); 

    System.out.print("Third in uppercase: \n\t" + three.toUpperCase().toString()+ "\n");
    System.out.println(); 
    
    System.out.print("Second in lowercase: \n\t" + two.toLowerCase().toString()+ "\n");
    System.out.println(); 
    
    System.out.print("Ignoring cases, does first equal second? \n\t" + one.equalsIgnoreCase(two)+ "\n");
    System.out.println();
    
    System.out.print("STRING'S compareTo(1st vs 2nd): \n\t" + str.compareTo(str2)+ "\n");
    System.out.println();
    
    System.out.print("My compareTo(1st vs 2nd): \n\t" + one.compareTo(two)+ "\n");
    System.out.println();
    
    System.out.print("STRING'S compareToIgnoreCase(1st vs 2nd): \n\t" + str.compareToIgnoreCase(str2)+ "\n");
    System.out.println();
    
    System.out.print("My compareToIgnoreCase(1st vs 2nd): \n\t" + one.compareToIgnoreCase(two) + "\n");
    System.out.println();
    }
}