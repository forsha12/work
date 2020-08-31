
/**
 * Parent class for circuits. Resistance always is 0 for objects of this class.
 * 
 * @author Paige Forsha 
 * @version 9/21/2018
 */
public class Circuit
{
    public double resistance;

    /**
     * Constructor for objects of class Circuit
     */
    public Circuit()
    {
        // initialise instance variables
        resistance = 0;
    }

    /**
     * @param      none
     * @return     resistance of 0
     */
    public double getResistance()
    {
        return 0;
    }
}
