/*
  NAME: AARON COVINGTON
  CLASS: CSCI 2683
  DATE: 8/25/2015
  PROJECT: Programming Project 3
  DESCRIPTION: Write a function to test if a string is a palindrome using a stack.
	You can push characters in the stack one by one.  When you reach the end of the
	string, you can pop the characters and form a new string.  If the two strings are
	exactly the same, the string is a palindrome.  Note that palindromes ignore
	spacing, punctuation, and capitalization.  Test your program with the following
	test cases: "Go dog", "Madam, I'm Adam", "Madam, I'm not a palindrome".
*/

#include "stdafx.h"
#include <cstdlib>
#include <iostream>
#include <string>

using namespace std;

class MyStack{
private:
	int size; int buffer;
	char* myStack;
public:
	//Constructor
	MyStack(){
		size = 0; //number of items in stack
		myStack = new char[50]; //my stack array
		buffer = 50; //buffer that keeps track of size of array
	}

	//function for adding item to the stack
	void push(char data){
		if(size + 1 == buffer){ //if stack is full call resize to create larger array
			resize();
		}
		myStack[size++] = data; //add data item to the stack and then increment size
	}

	//pops off last item in stack since it is LIFO and returns it
	char pop(){
		if(isEmpty() == true){ //check if empty, if it is, exit the program
			exit(0);
		}
		char data = myStack[size-1]; //save last item in the stack 
		size--; //decrement size of stack
		return data; //return item
	}

	//peek not needed for assignment but is part of standard stack implementation
	int peek(){
		return myStack[size-1];
	}

	//checks if stack is empty
	bool isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	//loops through and prints every item in the stack
	void printStack(){
		for(int i = 0; i < size; i++){
			printf("%c ", myStack[i]);
		}
		printf("\n");
	}

	//returns the size of the stack
	int Size(){
		return size;
	}

	//creates a new array and copies elements of old array to it
	void resize(){
		char* temp = new char[2*buffer]; //Allocate new array with twice the space
		for(int i = 0; i < size; i++){ //copy old array items to new array
			temp[i] = myStack[i];
		}
		delete[] myStack; //delete old array
		myStack = temp; //point myStack variable to the address of new array
		buffer *= 2; //multiply buffer by two to keep track of size of array
	}

	//Checks if string passed in is a palindrome or not
	string isPalindrome(string myString){
		string test = ""; //holds new string after items have been popped off stack
		string original = ""; //holds formatted alphanumeric string in the stack
		for(int i = 0; i < myString.length(); i++){ //loops through passed in string
			if(isalnum(myString[i]) != 0){ //checks if alphanumeric
				push(tolower(myString[i])); //if alphanumeric add it to the stack
			}
		}
		original.append(myStack, size); //Add alls chars in stack to string

		//created size2 to hold size since when I call pop it will decrement
		int size2 = size; //second var to hold size before its decremented with pop 
		char* result = new char[2*size]; //temp array to hold results we pop off stack
		for(int i = 0; i < size2; i++){
			result[i] = pop();
		}
		test.append(result, size2); //add the reversed string we popped off to variable

		if(original.compare(test) == 0){ //compare the string in stack with reversed
			return "\"" + myString + "\" is a palindrome!\n";
		}
		return "\""+ myString + "\" is not a palindrome!\n";
	}
};

int main(int argc, char *argv[])
{
	MyStack tStack; //instantiate object
	//test cases
	cout<<tStack.isPalindrome("Go dog")<<endl;
	cout<<tStack.isPalindrome("Madam, I'm Adam")<<endl;
	cout<<tStack.isPalindrome("Madam, I'm not a palindrome")<<endl;
	return 0;
}
