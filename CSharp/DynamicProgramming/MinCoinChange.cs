/* DESCRIPTION:  You are given coins of different denominations and a total amount of money amount. Write a function 
to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made 
up by any combination of the coins, return -1.  You may assume that you have an infinite number of each kind of coin.
*/
public class Solution {
    public int CoinChange(int[] coins, int amount) {
        int[] M = new int[amount + 1];  
        int[] C = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            M[i] = int.MaxValue-1;
            C[i] = -1;
        }
        for(int i = 0; i < coins.Length; i++){
            for(int j = coins[i]; j <= amount; j++){
                if(M[j] > 1 + M[j - coins[i]]){
                    M[j] = 1 + M[j - coins[i]];
                    C[j] = i; 
                }
            }
        }
        if(C[amount] == -1){
            return -1;
        }
        else{
            return M[amount];
        }
    }
}
