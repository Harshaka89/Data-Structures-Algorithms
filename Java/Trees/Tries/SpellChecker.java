/*
 * AUTHOR:  Aaron Covington
 * TITLE: Unit 11 Project 23.8.  SpellChecker
 * DATE STARTED: 03/29/16
 * DATE LAST REVISITED: 04/03/16
 * CLASS: CS3363R
 * DESCRIPTION: Design an algorithm for a spelling checker that has the following methods
 * void add(String word);  &&  boolean check(String word);
 * Store the collection of correctly spelled words in a 26-ary tree (which is a trie).  Each node in this tree has a child corresponding to a letter in the alphabet.
 * Each node also indicates whether the word represented by the path between the root and the node is spelled correctly.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker {
	public class Node{ //Nested Node class
		private Node[] children;
		private String data;
		/*Constructors*/
		public Node(String data){
			this.data = data;
			children = new Node[26]; //Each node has an array of 26 node pointers
		}
		public Node(){
			this("");
		}
		//Checks if there is a child at the given index, returns true/false
		public boolean containsChild(int index){
			return children[index] != null;
		}
		//Getter Methods
		public Node getChild(int index){
			return children[index];
		}
		public String getData(){
			return data;
		}
		//Setter Methods
		public void setData(String data){
			this.data = data;
		}
		public void setChild(Node newNode, int index){
			children[index] = newNode;
		}
	}
	
	Node root;
	//SpellChecker constructor
	public SpellChecker(){
		root = new Node(); //initialize root node
	}
	//Returns the index of a given character
	public int getIndex(Character c){
		return (int)c - 'a';
	}
	//Method to add a word to the trie
	public void add(String word){
		Node current = root;
		for(int i = 0; i < word.length(); i++){ //Iterate over each character in the word
			Character temp = word.charAt(i);
			int index = getIndex(temp); //Grab the index of each character
			if(!current.containsChild(index)){ //If no child at given index
				current.setChild(new Node(), index); //Create a new node at the index
			}
			if(i + 1 == word.length()){ //If we are at the end of the word set the nodes data to the word
				current.setData(word);
			}
			current = current.getChild(index); //go to the next node
		}
	}
	//Verifies if a word is spelled correctly
	public boolean check(String word){
		boolean isWord = false;
		Node current = root;
		for(int i = 0; i < word.length(); i++){
			Character temp = word.charAt(i);
			int index = getIndex(temp);
			if(!current.containsChild(index)){ //If node at index is null break out and return false
				break;
			}
			if(i + 1 == word.length()){ //if we are at the last char in the word
				
				isWord = current.getData().length() > 0; //if the current node is a word instead of "" this will be true
				break; //then we break out of the loop and return true;
			}
			current = current.getChild(index);
		}
		return isWord;
	}
	public static void main(String[] args){
		SpellChecker test = new SpellChecker();
		File file = new File("dictionary.txt");
		Scanner input = new Scanner(System.in);
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){
				test.add(sc.next());
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		
		System.out.println("Enter a word to see if it is spelled correctly");
		String word = input.nextLine();
		if(test.check(word)){
			System.out.println(word + " is spelled correctly!");
		}
		else{
			System.out.println(word + " is not spelled correctly!");
		}
	}
}
