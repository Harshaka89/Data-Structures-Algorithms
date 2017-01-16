/* DESCRIPTION:  You are given two sequences of characters, print the length of the longest common subsequence
        of both sequences.
        EX:  str1 = "abcdgh"
             str2 = "aedfhr"
             ANSWER IS: 3  (sequence is adh)
*/
public class Solution {
    public int EditDistance(string str1, string str2) {
        int[,] DP = new int[str1.Length+1, str2.Length+1];
        int max = 0;
        for(int i = 1; i < str1.Length; i++){
          for(int j = 1; j < str2.Length; j++){
            if(str1[i-1] == str2[j-1]){
                DP[i,j] = 1 + DP[i-1,j-1];
            }
            else{
              DP[i,j] = Math.Max(DP[i,j-1], DP[i-1,j])
            }
            if(DP[i,j] > max){
              max = DP[i,j];
            }
          }
        }
        return max;
    }
}
