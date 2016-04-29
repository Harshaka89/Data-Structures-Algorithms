/* DESCRIPTION:  Given a 2D array A, your task is to convert all rows to columns and columns to rows.
*/
using System; 
using System.Numerics;
class MyClass {
    static void Main(string[] args) {
        String[] nums = Console.ReadLine().Split(' ');
        int N = int.Parse(nums[0]);
        int M = int.Parse(nums[1]);
        int[,] A = new int[N,M];
        int[,] B = new int[M,N];
        for(int i = 0; i < N; i++){
        	String[] nums2 = Console.ReadLine().Split(' ');
        	for(int j = 0; j < M; j++){
        		A[i,j] = int.Parse(nums2[j]);
        	}
        }
        for(int i = 0; i < M; i++){
        	for(int j = 0; j < N; j++){
        		B[i,j] = A[j,i];
        		Console.Write(B[i,j] + " ");
        	}
        	Console.WriteLine();
        }
    }
}
