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
        String ans;
        String inputString = myScan.nextLine();
        Map<Character, Integer> myMap = new HashMap<Character, Integer>();
        for(int i = 0; i < inputString.length(); i++){
        	if(myMap.containsKey(inputString.charAt(i))){
        		myMap.put(inputString.charAt(i), myMap.get(inputString.charAt(i)) + 1);
        	}
        	else{
        		myMap.put(inputString.charAt(i), 1);
        	}
        }
        Iterator itr = myMap.values().iterator();
        while(itr.hasNext()){
        	Integer test = (Integer)itr.next();
        	if(test % 2 != 0){
        		count++;
        		if(count > 1){
        			ans = "NO";
                    System.out.println(ans);
        			return;
        		}
        	}
        }
        ans = "YES";
        System.out.println(ans);
        myScan.close();
    }
}
