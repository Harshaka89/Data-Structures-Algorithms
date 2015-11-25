/*
   NAME: AARON COVINGTON
   CLASS: CSCI 2683
   DATE: 9/18/2015
   PROJECT: Programming Project 5
   DESCRIPTION:  Write an algorithm that reads a list of integers from the keyboard, creates a list of them
   using linked list implementation and prints the result.
*/
#include "stdafx.h"
#include <cstdlib>
#include <iostream>
#include <string>
using namespace std;
class Node{
public:
    int data;
    Node* next;
    Node(int value){
        next = NULL;
        data = value;
    }
};
class MyLinkedList {
public:
    Node* head;
    int size;
    MyLinkedList(){
        size = 0;
    }
    void addToHead(int value){ //adds a node to the head of a list
        Node* newNode = new Node(value);
        if(head == NULL){
            head = newNode;
        }
        newNode->next = head;
        head = newNode;
        size++;
    }
    void printList(){ //loops through the list printing value in each node
        if(isEmpty() == true){
            return;
        }
        Node* current = head;
        for(int i = 0; i < size; i++){
            cout<<current->data<<" ";
            current = current->next;
        }
        cout<<endl;
    }
    bool isEmpty(){ //Checks if list is empty
        if(size == 0){
            cout<<"List is empty!"<<endl;
            return true;
        }
        return false;
    }
};
int main(int argc, char *argv[]) {
    MyLinkedList myList;
    int choice;
    int num;
    do{
        cout<<"1: Add Number To List"<<endl;
        cout<<"2: Print List"<<endl;
        cout<<"3: Exit"<<endl;
        cout<<endl;
        cin>>choice;
        switch(choice){
        case 1:
            cout<<"Enter a number: ";
            cin>>num;
            myList.addToHead(num);
            break;
        case 2:
            cout<<endl<<endl<<"LIST: ";
            myList.printList();
            cout<<endl;
            break;
        case 3:
            break;
        }
    }while(choice != 3);
}
