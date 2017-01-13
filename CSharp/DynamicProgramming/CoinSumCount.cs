/*  Description:  You are given a set of coins S. In how many ways can you make sum N assuming you have an infinite 
amount of each coin in the set.  Coins in set S will be unique. Note that the answer can overflow. So, give us the answer % 1000007
*/
class Solution {
    public int coinchange2(List<int> A, int B) {
        int[] M = new int[B+1];
        M[0] = 1;
        for(int i = 0; i < A.Count; i++){
            for(int j = A[i]; j<= B; j++){
                M[j] += M[j - A[i]];
                M[j] %= 1000007;
            }
        }
        return M[B];
    }
}
