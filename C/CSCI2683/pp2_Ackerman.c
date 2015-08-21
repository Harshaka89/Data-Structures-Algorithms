/*
  NAME: AARON COVINGTON
  CLASS: CSCI 2683
  DATE: 8/21/2015
  PROJECT: Programming Project 2
  DESCRIPTION: Write a recursive C function that calculates Ackerman's number.
  	  Verify your algorithm by using it to calculate the following test cases:
  	  Ackerman(2,5), Ackerman(0,3), and Ackerman(3,0).
 */
#include <stdio.h>
#include <stdlib.h>

int Ackerman(int m, int n);

int main(int argc, char *argv[])
{
  //testing and printing results
  printf("%d\n", Ackerman(2,5));
  printf("%d\n", Ackerman(0,3));
  printf("%d\n", Ackerman(3,0));
  fflush(stdout); 
  system("PAUSE");
  return 0;
}

int Ackerman(int m, int n){
	if(m == 0){
		return n+1; //if m = 0; n+1
	}
	else if(n == 0 && m > 0){
		return Ackerman(m-1, 1); //if n=0 and m>0; Ackerman(m-1,1)
	}
	else { //otherwise Ackerman(m-1, Ackerman(m,n-1)
		return Ackerman(m-1, Ackerman(m,n-1));
	}
}
