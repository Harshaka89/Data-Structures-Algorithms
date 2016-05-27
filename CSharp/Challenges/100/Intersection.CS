/*Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note:
Each element in the result must be unique.
The result can be in any order.*/

public class Solution {
    public int[] Intersection(int[] nums1, int[] nums2) {
        var map1 = new HashSet<int>();
        var map2 = new HashSet<int>();
        var list = new List<int>();
        for(int i = 0; i < nums1.Length; i++){
            map1.Add(nums1[i]);
        }
        for(int i = 0; i < nums2.Length; i++){
            map2.Add(nums2[i]);
        }
        foreach(int i in map1){
            if(map2.Contains(i)){
                list.Add(i);
            }
        }
        return list.ToArray();
    }
}
