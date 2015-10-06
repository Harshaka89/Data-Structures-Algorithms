/* DESCRIPTION:  Given a matrix of M x N elements (M rows, N columns), return all elements
   of the matrix in spiral order. 
Input:  [[ 1, 2, 3 ],
         [ 4, 5, 6 ],
         [ 7, 8, 9 ]]
Output: [1,2,3,6,9,8,7,4,5]
*/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int T = 0; 
        int B = matrix.length-1;
        int L = 0;
        if(matrix.length <= 0){
            return result;
        }
        if(matrix[0].length <= 0){
            return result;
        }
        int R = matrix[0].length-1; 
        
		 int dir = 0;
		 while(L <= R && T <= B){
		     if(dir == 0){
		         for(int k = L; k <= R; k++){
		             result.add(matrix[T][k]);
		         }
		         T++;
		     }
		     else if(dir == 1){
		         for(int k = T; k <= B; k++){
		             result.add(matrix[k][R]);
		         }
		         R--;
		     }
		     else if(dir == 2){
		         for(int k = R; k >= L; k--){
		             result.add(matrix[B][k]);
		         }
		         B--;
		     }
		     else if(dir == 3){
		         for(int k = B; k >= T; k--){
		             result.add(matrix[k][L]);
		         }
		         L++;
		     }
		     dir = (dir+1) % 4;
		 }
		 return result;
    }
}
