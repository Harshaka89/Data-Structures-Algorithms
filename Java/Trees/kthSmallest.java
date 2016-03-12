/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution { //Solution using in order traversal.  O(K)
    public int kthsmallest(TreeNode root, int k) {
        int N[] = {0, 0}; //N[0] will hold the count, and N[1] the value
        kthsmallest(root, k, N); //call helper method
        return N[1]; //return kth smallest
    }
    public void kthsmallest(TreeNode root, int k, int[] N){
        if(root == null){ //base case to exit recursion
            return;
        }
        kthsmallest(root.left, k, N); //go left until null
        N[0]++; //increment count
        if(N[0] == k){ //when count is equal to k
            N[1] = root.val; //assign value of kth smallest node to N[1]
            return; //return
        }
        kthsmallest(root.right, k , N); 
    }
}
