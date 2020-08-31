import java.util.Scanner;
/**
 * This program will take in user input to get a page size and a virtual address.
 * Using this input, it will tell the user the page number the address is in and the offset.
 * 
 * SP19.CPSC.2800.22971
 * @author Paige Forsha 
 * @version 3/4/19
 */
public class Paging
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int size;
        long address;
        do{
            System.out.print("Please enter the system page size (between 512 and 16384 inclusive and has to be a power of 2): ");
            size = in.nextInt();
        }while(!pageIsValid(size)); //asks user until valid input given
        
        do{
            System.out.print("Please enter the virtual address (must be between 0 and 4294967295, inclusive): ");
            address = in.nextLong();
        }while(!addressIsValid(address));
        
        System.out.println("This address is in virtual page: ");
        System.out.println(pageNumber(size, address));
        System.out.println("At offset: ");
        System.out.print(offset(size, address));
    }
    
    

    /**
     * This method gets the page number based off of the page size and virtual address.
     * 
     * @param      a page size inSize, a virtual address inAddress
     * @return     the division of inAddress and inSize
     */
    public static int pageNumber(int inSize, long inAddress)
    {
        int pageNum;
        pageNum = (int) inAddress / inSize;
        return pageNum;
    }
    
        /**
     * This method gets the offset based off of the page size and virtual address.
     * 
     * @param      a page size inSize, a virtual address inAddress
     * @return     the modulus of inAddress and inSize
     */
    public static int offset(int inSize, long inAddress)
    {
        int pageNum;
        pageNum = (int) inAddress % inSize;
        return pageNum;
    }
    
    /**
     * This method checks to see if the input for page number is valid.
     * Number must be between 512 and 16384 inclusive and has to be a power of 2. 
     * 
     * @param  a page number inNumber
     * @return boolean isValid
     */
    private static boolean pageIsValid(int inNum)
    {
        boolean isValid = true;
        int dec = inNum; //going to be used to decrement to check for power of 2
        
        if (inNum < 512 || inNum > 16384)
            isValid = false;
       
        while(dec <= 512 && dec % 2 == 0) 
        {
            dec /= dec;
            if (dec % 2 == 1)
                isValid = false;
        }
        
        return isValid;
    }
    
    /**
     * This method checks the validity of the user input for virtual address.
     * The number must be between 0 and 4294967295, inclusive. 
     * 
     * @param a virutal address inNum
     * @return boolean isValid
     */
    private static boolean addressIsValid(long inNum)
    {
        boolean isValid = true;
        
        if (inNum < 0 || inNum > (Math.pow(2, 31)-1))
            isValid = false;
        
        return isValid;
    }
}
