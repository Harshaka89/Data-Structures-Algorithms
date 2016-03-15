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
        if(matrix.length == 0){
            return result;
        }
        int T = 0; int B = matrix.length-1; int L = 0; int R = matrix[0].length-1;
        int dir = 0;
        while(T <= B && L <= R){
            if( dir == 0){
                for(int i = L; i <= R; i++){
                    result.add(matrix[T][i]);
                }
                T++;
            }
            else if(dir == 1){
                for(int i = T; i <= B; i++){
                    result.add(matrix[i][R]);
                }
                R--;
            }
            else if(dir == 2){
                for(int i = R; i >= L; i--){
                    result.add(matrix[B][i]);
                }
                B--;
            }
            else if(dir == 3){
                for(int i = B; i >= T; i--){
                    result.add(matrix[i][L]);
                }
                L++;
            }
            dir = (dir+1) % 4;
        }
        return result;
    }
}
