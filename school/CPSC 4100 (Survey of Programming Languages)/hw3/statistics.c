#include <stdio.h>
#include <stdlib.h>
/*
Paige Forsha. 2/13/2020.
This program finds the min, max, average, median, and mode of an array of user-given numbers.
The program does not data validate (except in the very beginning), as this was not a requirement in the instructions.
Yes, it would have looked cleaner to put these in functions. It's okay though. 
*/

int main()
{
    int count; //number of numbers
	double* values;
	double temp; //insertion sort 
	int oneBack; //insertion sort 
	double sum = 0; //for average
	double average; //avg
	double median; //median
	int freq = 1; //mode
	double* modes; //mode
	int greatestAmount = 1; //mode
	int modeCount = 0; //mode
	int j; //modes array
	//get count
	do
	{
		printf("Enter the count of numeric values: ");
		scanf("%d", &count);
	}while(count <= 0);  //makes sure they don't give an array of 0 or less
	
	values = (double*)calloc(count, sizeof(double));
	
	/*initialize values with user input*/
	for (int i = 0; i < count; i++) 
	    { 
            printf("Give me number %d: ", i+1);
            scanf("%lf", &values[i]);
        } 
	
	/*insertion sort algorithm*/
	for(int i = 1; i < count; i++)
	{
		temp = values[i];
		oneBack = i - 1;
		while((temp < values[oneBack]) && (oneBack >= 0))
		{
			values[oneBack+1] = values[oneBack];
			oneBack = oneBack - 1;
		}
		values[oneBack+1] = temp;
	}
	
	/*print sorted array*/
	printf("\nYour numbers: ");
	for (int i = 0; i < count; i++) 
	    { 
            printf("%lf, ", values[i]); 
        } 
	printf("\n\nResults: ");
	
	/*MIN AND MAX, easy bc it's sorted least to greatest!!!!!!!!!!!*/
	printf("\nMin: %lf\nMax: %lf", values[0], values[count-1]);
    
    /*AVERAGE calc!!!!!!!!!!!*/
    for (int i = 0; i < count; i++) 
	    { 
            sum += values[i]; 
        }
    average = (sum / ((double)count));
    printf("\nAverage: %lf", average);
    
    /*MEDIAN calc!!!!!!!!!*/
	if(count % 2 == 0) //number of values is even, finds avg of two middle numbers
	{
		median = ((values[count/2] + values[(count-1)/2]) / 2.0);
	}
	else //picks middle number otherwise
	{
		median = values[count / 2];
	}
    printf("\nMedian: %lf", median);
	
	/*MODE calc!!!!!!!!*/
	/*as instructions did not specify if multiple or no modes should be handled,
		this program just finds the lowest mode. if there is no mode, it just returns the minimum.*/ 

	
	//first find highest frequency
	for (int i = 0; i < count; i++)  
	{
		while(values[i] == values[i+1])
		{
				freq++;
				i++;
		}
		if(freq > greatestAmount) //if the frequency of the current is greater than the freq of the previous unique number
		{
			greatestAmount = freq;
		}
		freq = 1;
	}
	freq = 1;  //double ensuring it's 1 at the start
	//now that highest freq is set in stone, find your mode count
	for (int i = 0; i < count; i++)  
	{
		while(values[i] == values[i+1])
		{
				freq++;
				i++;
		}
		if(freq == greatestAmount)
		{
			modeCount++;
		}
		freq = 1;
	}
	
	/*now create array to hold modes for printing, then find modes and print*/
	modes = (double*)calloc(modeCount, sizeof(double));
	j = 0;

	for (int i = 0; i < count; i++) 
	{
		while(values[i] == values[i+1])
		{
			freq++;
			i++;
		}
		if(freq == greatestAmount)  //if this is a mode
		{
			modes[j] = values[i];
			j++;
		}
		freq = 1;
	}
		printf("\nMode(s): ");
		for (int i = 0; i < modeCount; i++) 
	    { 
            printf("%lf, ", modes[i]); 
        } 
	
	
	free(values);
	free(modes);
    return 0;
}
