/*
   NAME: AARON COVINGTON
   CLASS: CSCI 2683
   DATE: 12/02/2015
   PROJECT: Programming Project 14
   DESCRIPTION:  Implement Linear Search and print statistics.
*/
#include "stdafx.h"
#include <cstdlib>
#include <iostream>
#include <string>
#include <time.h>
using namespace std;

void set(int list[], int N){
    int temp = 0;
    srand(time(NULL));
    for(int i = 0; i < N; i ++){
        list[i] = rand() % 200 + 1; //Random number between 0 and 100000
    }
}
void search(int list[], int N, float &searches, float &success, int target){

    for(int i = 0; i < N; i++){
        searches++;
        if(list[i] == target){
            success++;
            return;
        }
    }
}
int main(int argc, char *argv[]) {
    const int N = 100;
    int list[N];
    float searches = 0;
    float success = 0;
    float percent = 0;
    float average = 0;
    int target;
    set(list, N); //Initialize list
    for(int i = 0; i < 100; i++){
        target = rand() % 200 + 1;
        search(list, N, searches, success, target);
    }
    percent = success/searches * 100.0;
    average = searches/100;
    cout<<"Total Searches Completed: "<<searches<<endl<<"Total Successful Searches: "<<success<<endl;
    cout<<"Percentage of Successful Searches: "<<percent<<endl<<"Average Tests Per Search: "<<average<<endl<<endl;
	cout<<endl;
    return 0;
}
