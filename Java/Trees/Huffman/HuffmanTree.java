/*
 * AUTHOR:  Aaron Covington
 * TITLE: Unit 11 Project 24.9.  Huffman Encoding/Decoding
 * DATE STARTED: 03/29/16
 * DATE LAST REVISITED: 04/03/16
 * CLASS: CS3363R
 * DESCRIPTION: Write a program that reads a text file of alphabetic data, creates a Huffman tree, and uses the tree
 * to compress the file.  Your program should then take the compressed file and using your tree, decode it.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;


public class HuffmanTree {
	public class Node implements Comparable<Node>{
		char data;
		int frequency;
		Node left, right;
		Node(char data, int frequency){
			this.data = data;
			this.frequency = frequency;
		}
		@Override
		public int compareTo(Node anotherNode) {
			return this.frequency - anotherNode.frequency;
		}
	}
	HashMap<Character, String> charToCode = new HashMap<Character, String>();
	HashMap<String, Character> codeToChar = new HashMap<String, Character>();
	HashMap<Character, Integer> freqMap;
	TreeSet<Character> charSet;
	/*Creates the Huffman Tree*/
	public Node getTree(HashMap<Character, Integer> map, TreeSet<Character> set){
		freqMap = map;
		charSet = set;
		Node left, right, top;
		int N = set.size(); //Store size of set
		Queue<Node> queue = new PriorityQueue<Node>();
		for(int i = 0 ; i < N; i++){ //Iterate over each character in the set
			Character c = set.pollFirst();
			queue.add(new Node(c, map.get(c))); //Add characters and frequencies to priorityQueue (minheap)
		}
		while(queue.size() > 1){ //While there is more than one element in the queue
			left = queue.poll();  //Pop off the two smallest frequency Nodes 
			right = queue.poll();
			top = new Node('~', left.frequency + right.frequency); //Creates internal node;  '~' is a value for internal nodes that arent used
			top.left = left; //Set the two smallest frequency nodes as left and right children of the internal node
			top.right = right;
			queue.add(top); //Add the top node to the priorityqueue
		}
		return queue.poll(); //returns the root node of the tree
		
	}
	/*Creates our translation table using two hashmaps*/
	public void createTable(Node root){
		createTable(root, "");
	}
	public void createTable(Node current, String temp){
		if(current == null){
			return;
		}
		createTable(current.left, temp + "0"); //recursive calls to create the binary codes
		createTable(current.right, temp + "1");
		if(current.data != '~'){ //skip internal nodes
			charToCode.put(current.data, temp); //Maps characters to binary code
			codeToChar.put(temp, current.data); //Maps the binary code to characters
		}
	}
	//Encodes the input string
	public String encode(String input) throws IOException{
		String temp = "";
		for(int i = 0; i < input.length(); i++){
			temp += charToCode.get(input.charAt(i)); //creates a binary string using charToCode hashmap translation table
		}
		writeFile(temp, "decode.txt"); //writes results to file
		return temp; //returns results
	}
	public String decode(String input) throws IOException{
		String temp = "";
		String output = "";
		for(int i = 0; i < input.length(); i++){
			temp += input.charAt(i); //copy over binary string one character at a time
			if(codeToChar.containsKey(temp)){ //if binary string is found in translation table 
				output += codeToChar.get(temp); //Translates back to original state using codeToChar hashmap
				temp = ""; //reset binary string to blank and go to next iteration
			}
		}
		writeFile(output, "results.txt"); //write results to file
		return output;
	}
	
	/*Method writes contents of variable "input" to a file stored in variable "name" */
	public void writeFile(String input, String name){
		try{
			File file = new File(name);
			PrintWriter pw = new PrintWriter(file);
			pw.print(input);
			pw.close();
		}catch(FileNotFoundException e){
			System.out.println("File " +  name + " not found!");
		}
	}
	public static void main(String[] args) throws IOException{
		HuffmanTree tree = new HuffmanTree();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		TreeSet<Character> set = new TreeSet<Character>();
		
		//Read in data from the file and store it in a variable called "test"
		File file = new File("encode.txt");
		String test = "";
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){
				String X = sc.next();
				if(!sc.hasNext()){
					test += X;
					break;
				}
				test += X + " ";
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		/*Loop over each character in the test variable and count the frequency of each
		 * We also add individual characters to a set*/
		for(int i = 0; i < test.length(); i++){
			set.add(test.charAt(i));
			if(map.containsKey(test.charAt(i))){
				map.put(test.charAt(i), map.get(test.charAt(i)) + 1);
			}
			else{
				map.put(test.charAt(i), 1);
			}
		}
		Node root = tree.getTree(map, set); //We create the tree which returns the root node
		tree.createTable(root); //We create a translation table for encoding and decoding
		System.out.println("Message before compressing: " + test);
		String temp = tree.encode(test); //encode our input
		System.out.println("Message after compressing: " + temp);
		temp = tree.decode(temp); //decode our input
		System.out.println("Message after decompressing: " + temp);		
	}
}
