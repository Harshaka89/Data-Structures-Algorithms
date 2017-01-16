/* DESCRIPTION:  You are given two words word1 and word2.  Find the minimum number of steps required to convert word1 to word2.
      Each operation is counted as one step.  You can use the following operations:
      A- Insert a character,  B- Delete a character, C- Replace a character
*/
public class Solution {
    public int MinDistance(string word1, string word2) {
        int[,] DP = new int[word1.Length+1, word2.Length+1];
        for(int i = 0; i <= word1.Length; i++){
            DP[i,0] = i;
        }
        for(int i = 0; i <= word2.Length; i++){
            DP[0,i] = i;
        }
        for(int i = 1; i <= word1.Length; i++){
            for(int j = 1; j <= word2.Length; j++){
                if(word1[i-1] == word2[j-1]){
                    DP[i,j] = DP[i-1,j-1];
                }
                else{
                    DP[i,j] = Math.Min(DP[i-1,j-1], DP[i,j-1]);
                    DP[i,j] = 1 + Math.Min(DP[i,j], DP[i-1,j]);
                }
            }
        }
        return DP[word1.Length,word2.Length];
    }
}
