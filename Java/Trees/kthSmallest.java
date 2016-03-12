/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthsmallest(TreeNode root, int k) {
        int N[] = {0, 0};;
        kthsmallest(root, k, N);
        return N[1];
    }
    public void kthsmallest(TreeNode root, int k, int[] N){
        if(root == null){
            return;
        }
        kthsmallest(root.left, k, N);
        N[0]++;
        if(N[0] == k){
            N[1] = root.val;
            return;
        }
        kthsmallest(root.right, k , N);
    }
}
