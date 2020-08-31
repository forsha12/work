import java.util.ArrayList;
public class Parallel extends Circuit
{
    
    //need to add ArrayList of resistors
    private ArrayList<Circuit> resistors;

    /**
     * Constructor for objects of class Parallel
     */
    public Parallel()
    {
        resistors = new ArrayList<>();
    }

    /**
     * adds new resistor to the list
     * 
     * @param a resistor
     */
    public void add(Circuit x)
    {
        resistors.add(x); 
    }
    
    /**
     * Parallel formula is 1/Rp = 1/R1 + 1/R2 + 1/R3
     * 
     * @param      none
     * @return     resistance of all resistors in parallel
     */
    public double getResistance()
    {
        for(int k = 0; k < resistors.size(); k++) //adds up all the 1/Rx
        {
            resistance += 1/(resistors.get(k)).getResistance();
        }
        resistance = ( 1 / resistance); //final step to the parallel resistance formula
        
        return resistance;
    }
}
