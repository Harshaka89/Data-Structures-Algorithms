/* DESCRIPTION: Write a function that takes an unsigned integer and returns the number of ’1' bits 
it has (also known as the Hamming weight).
For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/
public class Solution {
    public int HammingWeight(uint n) {
        string num = Convert.ToString(n, 2);
        int count = 0;
        for(int i = 0; i < num.Length; i++){
            if(num[i] == '1'){
                count++;
            }
        }
        return count;
    }
}
