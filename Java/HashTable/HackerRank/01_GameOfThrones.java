/*
* DESCRIPTION:  Dothraki are planning an attack to usurp King Robert's throne. King Robert learns 
of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.
But, to lock the door he needs a key that is an anagram of a certain palindrome string.  The king has a
string composed of lowercase English letters. Help him figure out whether any anagram of the string can
be a palindrome or not.
Input Format: 
A single line which contains the input string.
Constraints:
1≤ length of string ≤105 
Each character of the string is a lowercase English letter.
Output Format:
A single line which contains YES or NO in uppercase.
Sample Input:
aaabbbb
Sample Output:
YES
Sample Input2:
cdefghmnopqrstuvw
Sample Output:
NO
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in); int count = 0;
        String ans; //will store answer
        String inputString = myScan.nextLine(); //take input
        Map<Character, Integer> myMap = new HashMap<Character, Integer>(); //Create HashTable
        /*Iterate over characters in string and add them to the table, keeping count of duplicates*/
        for(int i = 0; i < inputString.length(); i++){
        	if(myMap.containsKey(inputString.charAt(i))){ //If duplicate increase count by 1
        		myMap.put(inputString.charAt(i), myMap.get(inputString.charAt(i)) + 1);
        	}
        	else{ //Otherwise add to table and set count to 1
        		myMap.put(inputString.charAt(i), 1);
        	}
        }
        Iterator itr = myMap.values().iterator(); //Create iterator
        while(itr.hasNext()){ //Check if there is another value in table
        	Integer test = (Integer)itr.next(); //store value returned by iterator as Integer
        	if(test % 2 != 0){ //Check if not even
        		count++; //if not even then increase count
        		if(count > 1){ //if more than one odd value it cant be a palindrome
        			ans = "NO";
                    System.out.println(ans); //print NO
        			return; //exit
        		}
        	}
        }
        ans = "YES";
        System.out.println(ans); //if loop completes it must be true
        myScan.close();
    }
}
