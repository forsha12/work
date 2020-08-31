#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
Paige Forsha. 2/13/2020.
This program will print a text wall that is x by y characters long in size, x and y being command line input.
The program does not data validate, as this was not a requirement in the instructions.
The program creates a null terminated string of random characters with some newline characters in there to make it a square.
*/

int main(int argc, char** argv)
{
	char* pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-+="; //75 characters to choose from
	int width, height, size, select;
	width = atoi(argv[1]);  //get your command line input
	height = atoi(argv[2]);
	size = ((width+1)*height+1);
	int count = 0;
	
	char* square = (char*)calloc(size, sizeof(char));
	
	srand(time(0)); //seeds random
	
	//make your string
	for(int i = 0; i < size; i++)
	{
		if(i == (size - 1)) //adding the null character to null terminate
		{
			square[i] = '\0';
		}
		else if(count == width) //making it appear the rectangle shape
		{
			square[i] = '\n';
			count = 0;
		}
		else //random character
		{
			select = rand() % 75; //chooses from our characters
			square[i] = pool[select];
			count++;
		}
	}
		//prints
		printf("%s", square);
		
		//free
		free(square);
}