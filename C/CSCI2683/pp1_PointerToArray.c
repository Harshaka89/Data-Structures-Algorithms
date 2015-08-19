/*
  NAME: AARON COVINGTON
  CLASS: CSCI 2683
  DATE: 8/19/2015
  PROJECT: Programming Project 1
  DESCRIPTION: Write a C program that allows the user to enter 10 integers from the keyboard
  into an array.  The 10 numbers should then be printed on the screen. This output must be 
  accomplished using pointers without any subscripts. ex. myArray[1] = temp;
*/
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  int myArray[10]; //Declare my array
	int* myPtr = myArray; //initialize pointer to array
	int length = sizeof(myArray)/sizeof(int); //find length of array
	int temp; //Declare variable that will temporarily hold input
	int i; //variable for my loop, had to declare outside since .c file

	for(i = 0; i < length; i++){ //loop through array
		printf("Enter number %d: ", i+1); //prompt user for input
		fflush(stdout); //Had to do an fflush to get my printf and scanf to work properly
		scanf("%d", &temp); //take user input
		*myPtr = temp; //assigns value in temp to first slot in myArray
		myPtr++; //increment pointer by 1 to go to next slot in the array
	}
	myPtr = myArray; //reset pointer to first slot in the array
	printf("\n");
	for(i = 0; i < length; i++){ //This loops through the array and prints each element
		printf("%d ", *myPtr);
		myPtr++;
	}
	printf("\n");
  return 0;
}
