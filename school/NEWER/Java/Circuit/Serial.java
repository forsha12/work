import java.util.ArrayList;
public class Serial extends Circuit
{
    //need to add ArrayList of resistors
    private ArrayList<Circuit> resistors;

    /**
     * Constructor for objects of class Serial
     */
    public Serial()
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
     * Serial formula is R1 + R2 + R3 + ...
     * 
     * @param      none
     * @return     all the resistances of each resistor added together
     */
    public double getResistance()
    {
        for(int k = 0; k < resistors.size(); k++) //adds up each resistor
        {
            resistance += (resistors.get(k)).getResistance();
        }
        
        return resistance;
    }
}
