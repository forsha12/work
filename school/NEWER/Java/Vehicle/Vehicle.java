
/**
 * superclass
 * 
 * @author Paige Forsha
 * @version 10/4/2018
 */
public class Vehicle implements Efficiency
{
    // instance variables - replace the example below with your own
    public double efficiency;

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle(double ef)
    {
       efficiency = ef;
    }

    public void printMessage()
    {
        System.out.print("I am a Vehicle! VROOM!!!");
    }
    
    public String getName()
    {
        return this.getClass().getSimpleName();
    }
    
    public double getEfficiency()
    {
        return efficiency;
    }
}
