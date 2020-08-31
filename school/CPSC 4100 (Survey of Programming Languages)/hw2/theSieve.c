#include <stdio.h>
#include <stdlib.h>

#define MAXVALUE 100
/*
Paige Forsha. 1/29/2020.
This program uses the Sieve of Eratosthenes to find prime numbers. 
This program also tells the user how many prime factors a non-prime number has.
*/

//this function will just create the numbers to be tested. 2 through MAXVALUE
void build_sieve(int* sieve, int max)
{
	
	for(int i = 0; i < max+1; i++)
	{
		sieve[i] = i;
	}
		
}

int main()
{
	int size = MAXVALUE + 1;
	//size of the array will be one more than the max value because of zero
	
	int* values = (int*)calloc((size), sizeof(int)); //create array 
	int* factors = (int*)calloc((size), sizeof(int)); //we want these initialized to zero. calloc does this
	
	
	build_sieve(values, MAXVALUE);  //array populated. now to cross things out
	
	//below: algorithm to "cross out" our non-primes. it makes them -1 to indicate a non-prime.
	//every time a non-prime is found, it is crossed off Again. this counts up the element in the factors array that
	//corresponds to the values array. allowing the algorithm to check over these again allows for the prime factors to be counted
	for(int i = 2; i <= MAXVALUE; i++)
	{
		if(values[i] != -1)
		{
			for(int k = 2*i; k <= MAXVALUE; k+=i)
			{
				values[k] = -1;
				factors[k]++;
			}	
		}
	}
	

	build_sieve(values, MAXVALUE); //just for printing purposes, reset. primes tracked by zeros in factors array 
	
	//print starts at 2. 0 and 1 not important
	for(int i= 2; i < size; i++)
	{
		printf("%d: %d\n", values[i], factors[i]);
	}
	
	free(factors);
	free(values);
}