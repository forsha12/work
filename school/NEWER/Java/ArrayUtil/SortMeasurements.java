import java.util.Arrays;
/**
 * Comparing run time of 3 different sort methods.
 * 
 * @author Paige Forsha 
 * @version 11/16/18
 */
public class SortMeasurements extends ArrayUtil 
{
   public static void main(String[] args)
   {
       //100 elements
       int[] arr1sel = ArrayUtil.randomIntArray(100, 100000);
       int[] arr1merge = ArrayUtil.randomIntArray(100, 100000);
       int[] arr1sort = ArrayUtil.randomIntArray(100, 100000);
       //1000
       int[] arr2sel = ArrayUtil.randomIntArray(1000, 100000);
       int[] arr2merge = ArrayUtil.randomIntArray(1000, 100000);
       int[] arr2sort = ArrayUtil.randomIntArray(1000, 100000);
       //and so on
       int[] arr3sel = ArrayUtil.randomIntArray(50000, 100000);
       int[] arr3merge = ArrayUtil.randomIntArray(50000, 100000);
       int[] arr3sort = ArrayUtil.randomIntArray(50000, 100000);
       
       int[] arr4sel = ArrayUtil.randomIntArray(75000, 100000);
       int[] arr4merge = ArrayUtil.randomIntArray(75000, 100000);
       int[] arr4sort = ArrayUtil.randomIntArray(75000, 100000);
       
       int[] arr5sel = ArrayUtil.randomIntArray(100000, 100000);
       int[] arr5merge = ArrayUtil.randomIntArray(100000, 100000);
       int[] arr5sort = ArrayUtil.randomIntArray(100000, 100000);
       
       int[] arr6sel = ArrayUtil.randomIntArray(120000, 100000);
       int[] arr6merge =  ArrayUtil.randomIntArray(120000, 100000);
       int[] arr6sort =  ArrayUtil.randomIntArray(120000, 100000);
       
       int[] arr7sel = ArrayUtil.randomIntArray(150000, 100000);
       int[] arr7merge =  ArrayUtil.randomIntArray(150000, 100000);
       int[] arr7sort =  ArrayUtil.randomIntArray(150000, 100000);
       
       //above is all arrays that will be tested
       
       StopWatch timer = new StopWatch(); //created stopwatch
       
       /**selection sorting**/
       timer.start();
       SelectionSorter.sort(arr1sel);
       timer.stop();
       System.out.println("SELECTION SORT. \n100 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       SelectionSorter.sort(arr2sel);
       timer.stop();
       System.out.println("1,000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       SelectionSorter.sort(arr3sel);
       timer.stop();
       System.out.println("50000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       SelectionSorter.sort(arr4sel);
       timer.stop();
       System.out.println("75000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       SelectionSorter.sort(arr5sel);
       timer.stop();
       System.out.println("100000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       SelectionSorter.sort(arr6sel);
       timer.stop();
       System.out.println("120000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       SelectionSorter.sort(arr7sel);
       timer.stop();
       System.out.println("150000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       /**merge sorting**/
       timer.start();
       MergeSorter.sort(arr1merge);
       timer.stop();
       System.out.println("MERGE SORT. \n100 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       MergeSorter.sort(arr2merge);
       timer.stop();
       System.out.println("1,000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       MergeSorter.sort(arr3merge);
       timer.stop();
       System.out.println("50000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       MergeSorter.sort(arr4merge);
       timer.stop();
       System.out.println("75000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       MergeSorter.sort(arr5merge);
       timer.stop();
       System.out.println("100000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       MergeSorter.sort(arr6merge);
       timer.stop();
       System.out.println("120000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       MergeSorter.sort(arr7merge);
       timer.stop();
       System.out.println("150000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       /**Arrays.sort**/
       timer.start();
       Arrays.sort(arr1sort);
       timer.stop();
       System.out.println("ARRAYS.SORT. \n100 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       Arrays.sort(arr2sort);
       timer.stop();
       System.out.println("1,000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       Arrays.sort(arr3sort);
       timer.stop();
       System.out.println("50000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       Arrays.sort(arr4sort);
       timer.stop();
       System.out.println("75000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       Arrays.sort(arr5sort);
       timer.stop();
       System.out.println("100000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       Arrays.sort(arr6sort);
       timer.stop();
       System.out.println("120000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
       
       timer.start();
       Arrays.sort(arr7sort);
       timer.stop();
       System.out.println("150000 elements -- " + timer.getElapsedTime() + " milliseconds");
       timer.reset();
   }
}
