/*  DESCRIPTION: Given an array of size n, find the majority element. The majority element is the element that
appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/
public class Solution {
    public int MajorityElement(int[] nums) {
        int N = nums.Length;
        var map = new Dictionary<int, int>();
        for(int i = 0; i < nums.Length; i++){
            if(map.ContainsKey(nums[i])){
                map[nums[i]]++;
            }
            else{
                map[nums[i]] = 1;
            }
        }
        int max = -99999999;
        for(int i = 0; i < nums.Length; i++){
            if(map[nums[i]] > N/2){
                max = nums[i];
            }
        }
        return max;
    }
}
