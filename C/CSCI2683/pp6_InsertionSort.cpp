/*
   NAME: AARON COVINGTON
   CLASS: CSCI 2683
   DATE: 11/24/2015
   PROJECT: Programming Project 6
   DESCRIPTION:  Write an algorithm that reads a list of integers from the keyboard, creates a list of them
   using linked list implementation and prints the result.
*/

#include "stdafx.h"
#include <cstdlib>
#include <iostream>
#include <string>
using namespace std;

void insertionSort(int list[], int last, int &swapCount){
    int min = 0;
    for(int i = 1; i < last; i++){
        min = list[i];
        int j = i;
        while(j > 0 && min < list[j-1]){
            list[j] = list[j-1];
            j--;
            swapCount++;
        }
        list[j] = min;
    }
}
int main(int argc, char *argv[]) {
    int list[] = {8, 15, 4, 16, 42, 23};
    int N = sizeof(list)/sizeof(int);
    int swapCount = 0;
    insertionSort(list, N, swapCount); 
    for(int i = 0; i < N; i++){
        cout<<list[i]<<" ";
    }
    cout<<endl<<"Total Moves: "<<swapCount<<endl;
    return 0;
}
