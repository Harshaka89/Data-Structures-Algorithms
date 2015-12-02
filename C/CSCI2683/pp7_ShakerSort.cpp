/*
   NAME: AARON COVINGTON
   CLASS: CSCI 2683
   DATE: 12/02/2015
   PROJECT: Programming Project 7
   DESCRIPTION:  Implement Shaker Sort
*/

#include "stdafx.h"
#include <cstdlib>
#include <iostream>
#include <string>
#include <time.h>
using namespace std;
//Shaker sort algorithm to sort the list
void shaker_sort(int list[], int N){
	int temp = 0;
	for(int i = 1; i < N; i++){
		for(int j = i - 1; j < N-1; j++){
			if(list[j] > list[j+1]){
				temp = list[j];
				list[j] = list[j+1];
				list[j+1] = temp;
			}
		}
		for(int j = N-i-1; j >= i; j--){
			if(list[j] < list[j-1]){
				temp = list[j];
				list[j] = list[j-1];
				list[j-1] = temp;
			}
		}
	}
}

//This method initializes the array with 50 random integers
void set(int list[], int N){
    int temp = 0;
    srand(time(NULL));
    for(int i = 0; i < N; i ++){
        list[i] = rand() % 100000; //Random number between 0 and 100000
    }
}

//This method loops through the list and prints each element.
void print(int list[], int N){ 
    for(int i = 0; i < N; i++){ 
		cout<<list[i]<<" ";
	}
}

int main(int argc, char *argv[]) {
    const int N = 50;
    int list[N];
    set(list, N); //Initialize list
    shaker_sort(list, N); //Sort list
	print(list, N); //print results
	cout<<endl;
    return 0;
}
