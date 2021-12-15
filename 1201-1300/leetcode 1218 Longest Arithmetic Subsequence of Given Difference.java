// leetcode 1218 Longest Arithmetic Subsequence of Given Difference

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int val : arr) {
            count.put(val, 1 + count.getOrDefault(val - difference, 0));
            ans = Math.max(ans, count.get(val));
        }
        return ans;
    }
}