
public class Resistor extends Circuit
{
    //no added instance variables, inherits resistance from Circuit
    
    /**
     * Constructor for objects of class Resistor
     */
    public Resistor(double inResistance)
    {
        resistance = inResistance;
    }

    /**
     * Overwrite the Circuit's getResistance
     * 
     * @param  y   none
     * @return     resistance
     */
    public double getResistance()
    {
        // put your code here
        return resistance;
    }
}
