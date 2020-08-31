/**
 * A class to run tests on the Circuit class and subclasses
 * @author Horstman
 * @version 02/06/2014
 *  
 */

public class CircuitDemo
{	/**
	method that implements tests for Circuit class and sublclasses
	@param args - Not Used.
 	*/
	
   public static void main(String[] args)
   {
      Parallel circuit1 = new Parallel();
      circuit1.add(new Resistor(100));
      Serial circuit2 = new Serial();
      circuit2.add(new Resistor(100));
      circuit2.add(new Resistor(200));
      circuit1.add(circuit2);
      System.out.println("Combined resistance: " + circuit1.getResistance());
      System.out.println("Expected: 75.0");
      
      Serial circuit3 = new Serial();
      circuit3.add(new Resistor(100));
      circuit3.add(new Resistor(100));
      circuit3.add(new Resistor(50));
      System.out.println("Combined resistance: " + circuit3.getResistance());
      System.out.println("Expected: 250.0");
      
      Serial circuit4 = new Serial();
      circuit4.add(new Resistor(300));
      circuit4.add(new Resistor(5));
      circuit4.add(new Resistor(60));
      System.out.println("Combined resistance: " + circuit4.getResistance());
      System.out.println("Expected: 365.0");
      
      Serial circuit5 = new Serial();
      circuit5.add(new Resistor(10));
      circuit5.add(new Resistor(20));
      circuit5.add(new Resistor(44));
      System.out.println("Combined resistance: " + circuit5.getResistance());
      System.out.println("Expected: 74.0");
      
      Resistor r1 = new Resistor(30);
      System.out.println("Resistance: " + r1.getResistance());
      System.out.println("Expected: 30.0");
      
      Circuit c1 = new Circuit();
      System.out.println("Resistance: " + c1.getResistance());
      System.out.println("Expected: 0.0");
      
      Parallel circuit7 = new Parallel();
      circuit7.add(new Resistor(20));
      circuit7.add(new Resistor(80));
      System.out.println("Combined resistance: " + circuit7.getResistance());
      System.out.println("Expected: 16.0");
      
      Parallel circuit8 = new Parallel();
      circuit8.add(new Resistor(20));
      circuit8.add(new Resistor(80));
      circuit8.add(new Resistor(16));
      circuit8.add(new Resistor(35));
      System.out.println("Combined resistance: " + circuit8.getResistance());
      System.out.println("Expected: roughly 6.511628");
      
      Parallel circuit9 = new Parallel();
      circuit9.add(new Resistor(10));
      circuit9.add(new Resistor(10));
      circuit9.add(new Resistor(5));
      circuit9.add(new Resistor(100));
      System.out.println("Combined resistance: " + circuit9.getResistance());
      System.out.println("Expected: roughly 2.43902");
      
      
   }
}
