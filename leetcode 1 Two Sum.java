//leetcode 1 Two Sum

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null) return null;
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            if (map.containsKey(m)) {
                res[1] = i;
                res[0] = map.get(m);
                return res;
            } 
            map.put(nums[i], i);
        } 
        return res;
    }
}