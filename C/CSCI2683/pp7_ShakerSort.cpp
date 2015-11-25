/*
   NAME: AARON COVINGTON
   CLASS: CSCI 2683
   DATE: 11/25/2015
   PROJECT: Programming Project 7
   DESCRIPTION:  Implement Shaker Sort
*/

#include "stdafx.h"
#include <cstdlib>
#include <iostream>
#include <string>
using namespace std;

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

int main(int argc, char *argv[]) {
    int list[] = {8, 23, 4, 16, 42, 15};
    int N = sizeof(list)/sizeof(int);
    shaker_sort(list, N);
	for(int i = 0; i < N; i++){
		cout<<list[i]<<" ";
	}
	cout<<endl;
    return 0;
}
