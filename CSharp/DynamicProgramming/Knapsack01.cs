/* DESCRIPTION:  You are given items of certain weights/values and a maximum allowed weight.  Pick the
number of items from this set to maximize the sum of the value of these items such that the sum of the weights
is less than or equal to the maximum allowed weight.
*/
public class Solution {
    public int Knapsack01(int[] val, int[] wt[], int W) {
        int[,] DP = new int[val.Length+1, W+1];
        for(int i = 0; i <= val.Length; i++){
          for(int j = 0; j <= W; j++){
            if(i == 0 || j == 0){
              dp[i,j] = 0;
              continue;
            }
            if(j - wt[i-1] >= 0){ //if this is negative current item is too large for current max weight
                DP[i,j] = Math.Max(DP[i-1,j], val[i-1] + DP[i-1,j-wt[i - 1]]);
            }
            else{
              DP[i,j] = DP[i-1, j];
            }
          }
        }
        return DP[val.Length, W];
    }
}
