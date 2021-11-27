// leetcode 424 Longest Repeating Character Replacement

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[128];
        int uniqueCount = 0;
        int start = 0, end = 0, maxLen = 0;
        while (end < s.length()) {
            char c1 = s.charAt(end);
            map[c1]++;
            uniqueCount = Math.max(uniqueCount, map[c1]);
            int replaceCount = end - start + 1 - uniqueCount;
            if (replaceCount > k) {
                // invalid window
                char c2 = s.charAt(start);
                map[c2]--;
                start++;
            } else {
                maxLen = Math.max(maxLen, end - start + 1);
            }
            end++;
        }
        return maxLen;
    }
}