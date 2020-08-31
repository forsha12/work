
/**
 * Class PayCheck is an object that will be utilized in the Driver class so that one may calculate the 
 * information found on paychecks. This includes storing last and first names, gross pay, net pay, and several
 * tax rates.
 * 
 * @author Paige Forsha 
 * @version 2/6/17
 */
public class PayCheck
{
    // instance variables 
    private double hourlyRate;
    private double hoursWorked;
    private double grossPay;
    private double netPay;
    private String lastName;
    private String firstName;
    private final double FEDERAL_TAX_RATE;
    private final double STATE_TAX_RATE;
    private final double FICA_RATE;

    /**
     * No args constructor, setting the numerics to 0, the names to "unknown"
     * and the tax constants to their appropriate amounts
     */
    public PayCheck()
    {
       hourlyRate = 0;
       hoursWorked = 0;
       grossPay = 0;
       netPay = 0;
       lastName = "unknown";
       firstName = "unknown";
       FEDERAL_TAX_RATE = .15;
       STATE_TAX_RATE = .09;
       FICA_RATE = .07;
    }
    
    /**
     * constructor that takes args, it allows the user to set the number of each and every field. (overloaded)
     */
    public PayCheck(double hourlyRate, double hoursWorked, double grossPay, double netPay, double lastName, double firstName, double fedTax, double stateTax, double fica) 
    {
        hourlyRate = hourlyRate;
        hoursWorked = hoursWorked;
        grossPay = grossPay;
        netPay = netPay;
        lastName = lastName;
        firstName = firstName;
        FEDERAL_TAX_RATE = fedTax;
        STATE_TAX_RATE = stateTax;
        FICA_RATE = fica;
    }

    /**
     * setLastName()
     * This method allows the user to change the last name.
     * 
     * @param  lName
     * @return     no return
     */
    public void setLastName(String lName)
    {
        lastName = lName;
    }
    
       /**
     * setFirstName()
     * This method allows the user to change the first name.
     * 
     * @param  fName
     * @return     no return
     */
    public void setFirstName(String fName)
    {
        firstName = fName;
    }
    
    /** 
     * setHourlyRate()
     * This method allows the user to set the hourly rate of pay. Test to see if parameter is in the range
     * of greater than 5 and less than 100. Does not change the rate of pay if it is not valid.
     * 
     * @param rate
     * @return none
     */
    public void setHourlyRate(double rate)
    {
       if (rate > 5 && rate < 100) //cant be under 5 or over 100 (non-inclusive)
        hourlyRate = rate;
    }
    
    /**
     * setHoursWorked()
     * This method allows the user to change the hours worked for an employee. Tests to see given value
     * is between 0 and 80. Does not change the hours worked if it is not within range.
     * 
     * @param hours
     * @return none
     */
    public void setHoursWorked(double hours)
    {
        if (hours > 0 && hours < 80)
            hoursWorked = hours;
    }
    
    /**
     * getLastName()
     * Retrieves last name from data.
     * 
     * @param none
     * @return String lastName
     */
    
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * getFirstName()
     * Retrieves first name from data.
     * 
     * @param none
     * @return String firstName
     */
    
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * getHourlyRate()
     * Retrieves hourly rate from data.
     * 
     * @param none
     * @return double hourlyRate
     */
    
    public double getHourlyRate()
    {
        return hourlyRate;
    }
    
     /**
     * getHoursWorked()
     * Retrieves hours worked from data.
     * 
     * @param none
     * @return double hoursWorked
     */
    
    public double getHoursWorked()
    {
        return hoursWorked;
    }
    
    /**
     * getGrossPay()
     * Uses the hourlyRate and hoursWorked and multiplies them to get the gross pay. This is the pay before
     * tax is taken from it.
     * 
     * @param 
     * @return double grossPay
     */
    public double getGrossPay()
    {
        grossPay = hourlyRate * hoursWorked;
        return grossPay;
    }
    
     /**
     * getNetPay()
     * Method used to find the net pay (the pay after tax has been taken away). Takes the gross pay 
     * and subtracts the percentages that the taxes will take, leaving what the employee will actually 
     * receive, the net pay. 
     * 
     * @param none
     * @return double netPay
     */
    public double getNetPay()
    {
        netPay = grossPay - ((grossPay * FEDERAL_TAX_RATE) + (grossPay * STATE_TAX_RATE) + (grossPay * FICA_RATE));
        return netPay;
    }
    
    /**
     * toString()
     * Will return a textual representation of the state of the object. 
     * Used for printing when the Driver is ran.
     * 
     * @param none
     * 
     * @return String, state of object
     */
    
    public String toString()
    {
        return "\nLast Name: " + lastName + "\nFirst Name: " + firstName + "\nGross Pay: $" + grossPay
        + "\nFederal Tax: " + FEDERAL_TAX_RATE + "\nState Tax: " + STATE_TAX_RATE + "\nFICA: " + FICA_RATE
        + "\nNet Pay: $" + netPay;
        
    }
}
