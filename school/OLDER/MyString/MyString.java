
/**
 * The MyString class is supposed to be a class that has extreme similarity to the String class.
 * It only has one field, an array of characters. It is immutable.
 * Has 3 constructors (one copy constructor).
 * Has multiple methods to manipulate.
 * 
 * @author Paige Forsha 
 * @version 3/23/17
 */
public class MyString
{
    
    private char[] arr;

    /**
     * A constructor utilized when a user sends in a String
     */
    public MyString(String start)
    {
       arr = start.toCharArray();
    }
    
    /**
     * A constructor that is used when a user sends in a character array
     */
    public MyString(char[] inArr)
    {
        this.arr = new char[inArr.length];
        for(int k = 0; k < arr.length; k++)
        {
            this.arr[k] = inArr[k];
        }
    }
    
    /**
     * The copy constructor
     */
    public MyString(MyString other)
    {
         for(int k = 0; k < this.arr.length; k++)
        {
            other.arr[k] = this.arr[k];
        }
    }
    
    /**
     * charAt gets a character at a specific index.
     * 
     * @param int index of character
     * @return character at that index
     */
    public char charAt(int index)
    {
        return arr[index];
    }
    
    /**
     * author's note: based completely off of what i UNDERSTAND to be the way the String class
     * defines this method?
     * 
     * FIRST: checks to see if the MyStrings are equivalent by using the .equals. returns 0
     *          if they are the same
     * SECOND: Goes one by one, checking the characters in the MyStrings. If one differs
     *          from the other, the result of subtracting the Unicode value for the first
     *          MyString's character from the second is what is returned.
     * THIRD: If all the characters match with the two objects but one MyString is longer than
     *          the other, the return is a subtraction of the first's length minus the second's.
     *          
     * @param another MyString
     * @return an int representing either 1) 0 [both are the same]
     *                                    2) subtraction between two different character's Unicode value
     *                                    3) subtraction of the lengths of the two
     */
    public int compareTo(MyString other)
    {
      if (this.equals(other)) //uses my written equals method
            return 0; //returns zero if they are identical
            
      for(int k = 0; k < this.arr.length && k < other.arr.length; k++) //checks one by one for non-matches
      {
        if(this.arr[k] != other.arr[k])
            return this.arr[k] - other.arr[k]; //returns difference between values (like in the String class)
      }
      
      return this.arr.length - other.arr.length;
      
    }
    
    
    /**
     * This method is the same as the compareTo method, except this one ignores cases.
     * 
     * @param another MyString
     * @return 0 if they're the same, OR subtraction of unicodes values of differing characters,
     *         OR subtraction of lengths ((IN THAT ORDER, they're checked))     
     */
    public int compareToIgnoreCase(MyString other)
    {
       MyString thisIC = this.toUpperCase();
       MyString otherIC = other.toUpperCase(); //creating two new MyStrings based off the originals
       
        if (thisIC.equals(otherIC)) //uses my written equals method
            return 0; //returns zero if they are identical
            
      for(int k = 0; k < thisIC.arr.length && k < otherIC.arr.length; k++) //checks one by one for non-matches
      {
        if(thisIC.arr[k] != otherIC.arr[k])
            return thisIC.arr[k] - otherIC.arr[k]; //returns difference between values (like in the String class)
      }
      
      return thisIC.arr.length - otherIC.arr.length;
    }
    
    /**
     * This method puts to MyStrings together, usually to create a sentence.
     * 
     * @param another MyString
     * @return a brand new MyString which is the "sum" of the two
     */
    public MyString concat(MyString other)
    {
        char [] result = new char[this.arr.length + other.arr.length];
        
        for(int k = 0; k < this.arr.length; k++) //first chunk of the new sequence is given values
        {
            result[k] = this.arr[k];
        }
        
        for(int k = this.arr.length; k < result.length; k++) //the rest of the sequence gets values
        {
            result[k] = other.arr[k-this.arr.length];
        }
        
        return new MyString(result);
    }
    
    /**
     * Checks to see if a MyString ends in a particular suffix.
     * 
     * @param a MyString (the suffix)
     * @return true if it ends in the sent in suffix, false if not
     */
    public boolean endsWith(MyString suffix)
    {
        int i = this.arr.length - 1; //for checking the first MyString backwards
        for(int k = suffix.arr.length - 1; k >= 0; k--)
        {
            
            if(suffix.arr[k] != this.arr[i]) //if something doesn't match, the return is false
                return false;
            i--;//counts down to check 'this' array    
        }    
        return true; //if everything checks out
    }
    
    /**
     * Will see if the two MyStrings are the same.
     * 
     * @param another MyString
     * @return true if they match, false if not
     */
    public boolean equals(MyString other)
    {
        if (this.arr.length != other.arr.length) //compares lengths first
            return false;
            
        for(int k = 0; k < this.arr.length; k++) //goes one by one and checks characters
        {
            if (this.arr[k] != other.arr[k])
                return false;
        }
        
        return true;
    }
    
    /**
     * Will see if the two MyStrings are the same regardless of case.
     * 
     * @param another MyString
     * @return true if they match, false if not.
     */
    public boolean equalsIgnoreCase(MyString other)
    {
        if (this.arr.length != other.arr.length) //checks length first
            return false;
            
        MyString thisIC = this.toUpperCase();
        MyString otherIC = other.toUpperCase(); //creates two new MyStrings based off the two we want to compare
        //doesn't alter the originals in any way!!
        
        for(int k = 0; k < thisIC.arr.length; k++) //goes one by one and checks characters
        {
            if (thisIC.arr[k] != otherIC.arr[k])
                return false;
        }
            
         return true;
    }
    
    /**
     * Finds index of the first occurence of the character sent in.
     * 
     * @param a character to search for
     * @return int representing index (-1 if not found)
     */
    public int indexOf(char ch)
    {
        for(int k = 0; k < arr.length; k++)
        {
            if (arr[k] == ch)
                return k;
        }
        return -1;
    }
    
    /**
     * Finds the index of a character FROM a certain point.
     * 
     * @param a char to be searched, an int--the start point for the search
     * @return int representing position of the character. (-1 if not found)
     */
    public int indexOf(char ch, int fromPoint)
    {
        for(int k = fromPoint; k < arr.length; k++)
        {
            if(arr[k] == ch)
                return k;
        }
        return -1;
    }
    
    /**
     * Finds the last occurence of a character and returns the index of it.
     * 
     * @param char to be found
     * @return int representing position of character
     */
    public int lastIndexOf(char ch)
    {
        
        for(int k = arr.length -1; k >= 0; k--)
        {
            if(arr[k] == ch)
            {
                return k;
            }
        }
        return -1;
    }
    
    /**
     * Finds length of the array of characters
     * 
     * @return int representing length
     */
    public int length()
    {
        return arr.length;
    }
    
    /**
     * Finds each instance of the old character and replaces it with the new one.
     * 
     * @param two chars; oldChar (to be replaced), newChar (to replace the old)
     * @return a NEW MyString that results from the replacement
     */
    public MyString replace(char oldChar, char newChar)
    {
        char[] result = new char[arr.length]; //so the values can be changed 
        
        for(int k = 0; k < arr.length; k++) 
        {
            if (arr[k] == oldChar)
                result[k] = newChar; //only changes the new character array!!
            else
                result[k] = this.arr[k]; //copies over values if they don't need changed
        }
        
        return new MyString(result);
    }
    
    /**
     * Similar to the endsWith method. Checks to see if the MyString begins 
     * with the prefix sent in.
     * 
     * @param MyString (the prefix)
     * @return true if it DOES begin with the prefix, false otherwise
     */
    public boolean startsWithString(MyString prefix)
    {
        for(int k = 0; k < prefix.arr.length && k < this.arr.length; k++)
        {
           if(prefix.arr[k] != this.arr[k])
                return false;
        }
        return true;
    }
    
    /**
     * Gets a portion of the original MyString starting from the sent in index.
     * 
     * @param int beginIndex (where you want to start your substring)
     * #return a new MyString that's the substring of the original
     */
    public MyString substring(int beginIndex)
    {
        char[] result = new char[arr.length - beginIndex]; //so that the array is long enough
        int counter = 0; //so the new array can be filled from the beginning
        for(int k = beginIndex; k < arr.length; k++) //goes through original
        {
            result[counter] = arr[k];
            counter++;
        }
        
        return new MyString(result);
    }
    
    /**
     *Gets a portion of the original MyString. Within the range a user sends in.
     *
     *@param int beginIndex, int endIndex (the start and finish of the substring)
     *@return a new MyString representing the substring made
     *
     */
    public MyString substring(int beginIndex, int endIndex)
    {
        char[] result = new char[(endIndex + 1) - beginIndex]; //gives enough space for the characters
        int counter = 0;
        
        for(int k = beginIndex; k <= endIndex; k++)
        {
            result[counter] = arr[k];
            counter++;
        }
        
        return new MyString(result);
    }
    
    /**
     * Takes in a MyString and makes every letter lowercase.
     * 
     * @return a new MyString that is all lowercase
     */
    public MyString toLowerCase()
    {
    char[] result = new char[arr.length];
        for(int k = 0; k < arr.length; k++)
        {
        if (arr[k] >= 65 && arr[k] <= 90) //65-90 is unicode for all the uppercase letters
            result[k] = (char)(arr[k] + 32); //adding 32 makes them lowercase
        else 
            result[k] = arr[k];
        }
        
        return new MyString(result);
    }
    
    /**
     * Takes in a MyString and makes every letter uppercase.
     * 
     * @return a new MyString that is all uppercase
     */
    public MyString toUpperCase()
    {
        char[] result = new char[arr.length];
        for(int k = 0; k < arr.length; k++)
        {
        if (arr[k] >= 97 && arr[k] <= 122) //97-122 unicode for all lowercase letters
            result[k] = (char)(arr[k] - 32); //subtracting 32 makes them uppercase
        else 
            result[k] = arr[k];
        }
        
        return new MyString(result);
    }
    
    /**
     * The toString method.
     * 
     * @return a String representing the status of the field in the MyString class
     */
    public String toString()
    {
        return new String(arr);
    }
}
