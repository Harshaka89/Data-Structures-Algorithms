/*  DESCRIPTION: Given an integer, write a function to determine if it is a power of two. 
*/
public class Solution {
    public bool IsPowerOfTwo(int n) {
        int test = 0;
        double total = 0;
        while(total < n){
            total = Math.Pow(2, test);
            if(total == n){
                return true;
            }
            test++;
        }
        return false;
    }
}
