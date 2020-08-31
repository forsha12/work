import java.util.ArrayList;

/**
 * This class generates substrings of a string.
 */
public class SubstringGenerator {
    public static ArrayList<String> getSubstrings(String word) {
        //this is the value you will return
         ArrayList<String> result = new ArrayList<String>();
        
        //come up with a base case first
        if (word.length() == 0) //empty string base case
        {
            result.add(word);
            return result;
        }
        else         // Below here is the recursive case
        {
              String shorter = word.substring(1);  // Form a simpler word by removing the first character
              result = getSubstrings(shorter);
                      // Generate all substrings of the simpler word
                       // This is where you will make a recursive call
                       // You can store the result from this temporary call in 
                       // your results ArrayList
              
               // Add all strings that start with word.charAt(0)
               // You will need a loop here
              for(String s : result)
              {
                  String char0 = Character.toString(word.charAt(0));
                  if(s.startsWith(char0))
                    result.add(s);       
              }
           return result; 
        } 
        
        /*how to do it without recursiion*/
//         result.add("");
//         for (int i = 0; i < word.length(); i++) 
          //{
//            for (int j = i+1; j <= word.length(); j++) 
            //{
//               result.add(word.substring(i,j));
//            }
//          }
        
 //       return result;
    }
}