/*
   NAME: AARON COVINGTON
   CLASS: CSCI 2683
   DATE: 9/9/2015
   PROJECT: Programming Project 4
   DESCRIPTION:  Given a queue of integers, write an algorithm that, using only the queue
   ADT, calculates and prints the sum and the average of the integers in the queue.
   NOTE: I used the C++ STL library because we are allowed and encouraged to do so.  I ignored
   the part of the problem description "... without changing the contents of the queue" as instructed
   via email.
*/
#include <cstdlib>
#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
    queue<int> tQueue; //create instance of queue ADT
    tQueue.push(4); //The C++ STL queue uses push and pop instead of enqueue and dequeue
    tQueue.push(8);
    tQueue.push(15);
    tQueue.push(16);
    tQueue.push(23);
    tQueue.push(42);
    int sum = 0, avg = 0, count = tQueue.size();
    for(int i = 0; i < count; i++){ //Loops through the elements in the queue
        sum += tQueue.front(); //keeps track of sum of each element in the queue
        tQueue.pop(); //pops off top element to move to next element in queue for next pass through
    }
    avg = sum/count; //calculates the avg and stores in variable avg
    cout<<"Sum: "<<sum<<endl; //print results
    cout<<"Average: "<<avg<<endl;
    system("PAUSE");
    return EXIT_SUCCESS;
}
