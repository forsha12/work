import java.util.Random;
public class Tester
{
    public static void main (String[] args)
    {
        final int NUM_VEHICLES = 10;
        Vehicle[] vehicles = new Vehicle[NUM_VEHICLES];
        Random rand = new Random();
        int select;
        double ef; 
        Vehicle below;
        
        for(int k = 0; k < NUM_VEHICLES; k++) //filling array
        {
           select = rand.nextInt(3); // [0, 3) doesn't include 3
           ef = rand.nextDouble() * 100; 
           if (select == 0)
                vehicles[k] = new Vehicle(ef);
           else if (select == 1)
                vehicles[k] = new Car(ef);
           else
                vehicles[k] = new Boat(ef);
        }
        
        for(int k = 0; k < NUM_VEHICLES; k++)
        {
            vehicles[k].printMessage();
            System.out.println();
        } 
        /*this is polymorphism because there's 3 different printMessages, but because of inheritance
         * we can call every element in the array to do this, and the virtual machine will 
         * select the correct printMessage for each element in the vehicles array
        */
        System.out.println();
        for(int k = 0; k < NUM_VEHICLES; k++) //printing out name of class and result
        {
            System.out.printf(vehicles[k].getClass().getSimpleName() + ": " + "%.4f" + "\n", vehicles[k].getEfficiency());
        }
        System.out.println();
        below = (Vehicle) getFirstBelowT(vehicles, 20);
        
        if (below == null)
            System.out.print("No vehicles had an efficiency less than 20.");
        else
            System.out.printf("The first object with efficiency less than 20 was \n" + below.getClass().getSimpleName()
                + " with efficiency of " + "%.4f" + "." , below.getEfficiency());
    }
    
    static Efficiency getFirstBelowT(Efficiency[] arr, double threshold)
    {
        Efficiency firstBelow = null;
        boolean isBelow = false;
        
        for(int k =0; k < arr.length; k++) //runs thru all elements
        {
           if(isBelow == false) //will only mark the first below threshold
           {
              if (arr[k].getEfficiency() < threshold)
              {
                  isBelow = true; //making sure ONLY the first is recorded
                  firstBelow = arr[k];
              }
           }
           
        }
        return firstBelow;
    }
}

