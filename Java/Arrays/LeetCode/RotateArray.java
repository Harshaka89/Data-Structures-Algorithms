public class Solution {
    public void rotateRight(int[] nums, int k) {
        int N = nums.length;
        int[] result = new int[N];
        for(int i = 0; i < N; i++){
            result[i] = nums[(N - (k % N) + i) % N];
        }
        for(int i = 0; i < N; i++){
            nums[i] = result[i];
        }
    }
    
    public void rotateLeft(int[] nums, int k) {
        int N = nums.length;
        int[] result = new int[N];
        for(int i = 0; i < N; i++){
            result[i] = nums[(i + k) % N];
        }
        for(int i = 0; i < N; i++){
            nums[i] = result[i];
        }
    }
    
}
