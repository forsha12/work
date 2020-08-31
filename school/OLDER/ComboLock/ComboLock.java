/**
   A class to simulate a combination lock.
*/
public class ComboLock
{
   
    //********* you will need to create appropriate instance variables here
   private int currentNumber = 0; //current value lock dial is set to
   private int [] combination = new int[3]; //for the constructor method, holds the unlock combination
   private int currentState = 0; //holds the current position we're working on for the combination
   private boolean[] element = {false, false, false}; //for verification of what is put in, for unlocking
   private boolean open = false; //holds whether or not it can be unlocked
   /**
      Initializes the combination of the lock.
      
   */
   //**** COMPLETE THIS CONSTRUCTOR - input should be 3 number combination
   //**** You may need to set other instance variables other than the 
   //**** arguments here
   //You should verify that the secret number are in the range 0-39 (inclusive)
   //if the values given are not in that range, clamp them.
   //i.e. the call new ComboLock(0, -20, 45) would create a combination of
   // 0, 0, 39  (the -20 gets clamped to 0 because it was less than 0)
   // (the 45 gets clamped to 39 because it was > 39).
   public ComboLock(int secret1, int secret2, int secret3)
   {
          if (combination[0] < 0) //checking to make sure the values are in the 0-39 range
              combination[0] = 0; //fixes anything that is under 0
          else if (combination[0] > 39)
              combination[0] = 39; //fixes anything over 39
          else
              combination[0] = secret1; //sets first number to first input if in range
          
          if (combination[1] < 0) //repeat for second number
              combination[1] = 0; 
          else if (combination[1] > 39)
              combination[1] = 39; 
          else
              combination[1] = secret2; 
      
          if (combination[2] < 0) //repeat for third number
              combination[2] = 0; 
          else if (combination[2] > 39)
              combination[2] = 39; 
          else
              combination[2] = secret3; 
   }
   
   /**
      Resets the state of the lock so that it can be opened again.
   */
   //********* COMPLETE THIS METHOD
   public void reset()
   {
       currentState = 0; //sets the combination back to the beginning before you did anything
       for(int k = 0; k < element.length; k++)
       {
           element[k] = false;
       }   //resets the trackers of validity for unlock
   }

   /**
      Turns lock left given number of ticks.
      @param ticks number of ticks to turn left
   */
   //*********COMPLETE THIS METHOD
   //you can assume that ticks will be a valid value between 0-40 
   //note that 40 ticks in either direction should return us back to the 
   //number we started on
   public void turnLeft(int ticks)
   {
       currentNumber = (currentNumber + ticks) % 40; //this makes 40 move it 0, adds this to the current number
       if (currentNumber == combination[currentState]) 
       {
           element[currentState] = true;
       }
       if (currentState < 2)
            currentState++;
       
   }

   /**
      Turns lock right given number of ticks
      @param ticks number of ticks to turn right
   */
   //*********COMPLETE THIS METHOD
   //you can assume that ticks will be a valid value between 0-40 
   //note that 40 ticks in either direction should return us back to the 
   //number we started on
   public void turnRight(int ticks)
   {
       currentNumber = (currentNumber + (40 - ticks % 40)) % 40; //turning right, subtraction here
       if (currentNumber == combination[currentState])
       {
           element[currentState] = true;
       }
       if (currentState < 2)
           currentState++; 
       
   }

   /**
      Returns true if the lock can be opened now
      @return true if lock is in open state
   */
   //**** COMPLETE THIS METHOD
   public boolean open()
   {
       if (element[0] && element[1] && element[2]) //if the current numbers matched the combination
       {
           open = true;
       }
       
       return open; 
   }
   /**
   Returns current value dial is pointing at
   @return value dial is pointing at currently
    */
   public int getCurrentNumber() {
       return currentNumber;
   }
   
}
