#include "stdafx.h"
#include <cstdlib>
#include <iostream>
#include<string>

using namespace std;

class MyStack{
public:
	int size; int buffer;
	char* myStack;

	MyStack(){
		size = 0;
		myStack = new char[50];
		buffer = 50;
	}

	void push(char data){
		
		if(size + 1 == buffer){
			resize();
		}
		myStack[size++] = data;
	}
	char pop(){
		if(isEmpty() == true){
			exit(0);
		}
		char data = myStack[size-1];
		size--;
		return data;
	}
	int peek(){
		return myStack[size-1];
	}

	bool isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	void printStack(){
		for(int i = 0; i < size; i++){
			printf("%c ", myStack[i]);
		}
		printf("\n");
	}

	int Size(){
		return size;
	}

	void resize(){
		char* temp = new char[2*buffer];
		for(int i = 0; i < size; i++){
			temp[i] = myStack[i];
		}
		delete[] myStack;
		myStack = temp;
		buffer *= 2;
	}

	string isPalindrome(string myString){
		string test = "";
		string original = "";
		for(int i = 0; i < myString.length(); i++){
			if(isalnum(myString[i]) != 0){
				push(tolower(myString[i]));
			}
		}
		original.append(myStack, size);

		//created size2 to hold size since when I call pop it will decrement
		int size2 = size;  
		char* result = new char[2*size];
		for(int i = 0; i < size2; i++){
			result[i] = pop();
		}
		test.append(result, size2);

		if(original.compare(test) == 0){
			return "\"" + myString + "\" is a palindrome!\n";
		}
		return "\""+ myString + "\" is not a palindrome!\n";
	}
};

int main(int argc, char *argv[])
{
	MyStack tStack;
	//tStack.printStack();
	cout<<tStack.isPalindrome("Madam, I'm not a palindrome");
	return 0;
}
