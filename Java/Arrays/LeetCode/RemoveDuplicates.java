/* DESCRIPTION: Given a sorted array, remove the duplicates in place such that each element appear only once and 
    return the new length.  Do not allocate extra space for another array, you must do this in place with constant memory.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int N = nums.length;
        if(N < 2){
            return N;
        }
        int A = 0; int B = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[A] == nums[B]){
                B++;
                N--;
            }
            else{
                A++;
                nums[A] = nums[B];
                B++;
            }
        }
        return N;
    }
}
