/*  DESCRIPTION:  This program tests if two strings are anagrams and ignores case.  It uses a hashtable
                  to improve efficiency and achieve O(N) run time.
    LINK:  https://www.hackerrank.com/challenges/java-anagrams
*/
import java.io.*;
import java.util.*;

public class Solution {

   static boolean isAnagram(String A, String B) {
      if(A.length() != B.length()){
          return false;
      }
       A= A.toLowerCase(); B = B.toLowerCase();
       Map<Character, Integer> map = new HashMap<Character, Integer>();
       for(int i = 0; i < A.length(); i++){
           if(map.containsKey(A.charAt(i))){
               int count = map.get(A.charAt(i));
               map.put(A.charAt(i), ++count);
           }
           else{
           map.put(A.charAt(i), 1);
           }
       }
       for(int i = 0; i < B.length(); i++){
           if(map.containsKey(B.charAt(i))){
               int count = map.get(B.charAt(i));
               map.put(B.charAt(i), --count);
           }
           else{
               return false;
           }
       }
       Iterator itr = map.values().iterator();
       while(itr.hasNext()){
           Integer count = (Integer)itr.next();
           if(count != 0){
               return false;
           }
       }
       return true;
       
   
   }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        boolean ret=isAnagram(A,B);
        if(ret)System.out.println("Anagrams");
        else System.out.println("Not Anagrams");
        
    }
}
