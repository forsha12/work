import java.io.*;
import java.util.*;

/**
 * Text Generator will read file input and use the text to generate new text.
 * Limited generated text to 15 words for readability when generating.
 * 
 * @author Paige Forsha 
 * @version 4/22/2020
 */
public class textGenerator

{
     public static void main(String[] args) throws FileNotFoundException
     {
       File file = new File("readIn.txt");
       Scanner scan = new Scanner(file);
       Map<String, ArrayList> dict = new HashMap<String, ArrayList>();
       Scanner UI = new Scanner(System.in);
       String userInput = "n";
       //reading in file
       String txt = new String();
       String word;
       while (scan.hasNext()) 
       {
            word = scan.next();
            txt = new String(txt + " " + word);
       }
     
       int i = 1; 
       String nextWord;
       do 
       {    
           word = txt.substring(i, txt.indexOf(' ', i));
           
           i = txt.indexOf(' ', i) + 1; //update to get to the next word later
           //if word hasn't been "picked up" yet, make an entry
           if (!dict.containsKey(word))
            dict.put(word, new ArrayList<String>());
            
           //get current list of next words for current word
           ArrayList ar = dict.get(word);
          //does the word have a word that follows?
          try 
          {
              nextWord = txt.substring(i, txt.indexOf(' ', i));
          } catch (StringIndexOutOfBoundsException e)
          //when you get to the final word
          {
              nextWord = txt.substring(i,txt.length());
              ar.add(nextWord);
              dict.remove(word);
              dict.put(word, ar);
              word = "xxxxx";
              if (!dict.containsKey(nextWord))
                    dict.put(nextWord, new ArrayList<String>());
          }
          
          //normal chain of events. does not apply to last word
          //adding to the next word array for each word in the text
          if(word != "xxxxx")
          {
               ar.add(nextWord);
               dict.remove(word);
               dict.put(word, ar);
          }
       } while(word != "xxxxx");  
       
       //print dict for testing
        //dict.forEach((key, value) -> System.out.println(key + ":" + value));
        
        
       //at this point, we have now gotten our words and can now "select" them for text generation
       //firstly, we pick a word to start with 
       do{
           Random rand = new Random();
           String[] allWords = dict.keySet().toArray(new String[dict.size()]);
           String currentWord = allWords[rand.nextInt(allWords.length)];
           String result = currentWord;
           String next;
           int x = 0;
           do{
           //gets possibilities
           ArrayList poss = dict.get(currentWord);
           //pick random possibility
           try
           {
               next = (String) poss.get(rand.nextInt(poss.size()));
           }catch (IllegalArgumentException e)
           {
               next = ".";
           }
           
           if(next == ".")
                result = result + next;
           else
            result = result + " " + next;
           currentWord = next;
           x++;
          }while(next != "." && x != 15);
          System.out.println(result);
          System.out.println("Would you like to generate another? y/n");
          userInput = UI.nextLine();
    }while(!userInput.equals("n"));
     } 
    
}
