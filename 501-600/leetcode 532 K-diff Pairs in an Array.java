// leetcode 532 K-diff Pairs in an Array

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        HashMap <Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (k > 0 && map.containsKey(key + k)) {
                res++;
            } else if (k == 0 && val > 1) {
                res++;
            }
        }
        return res;
    }
}