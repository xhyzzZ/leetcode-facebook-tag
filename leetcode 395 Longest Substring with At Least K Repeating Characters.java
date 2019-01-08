//leetcode 395 Longest Substring with At Least K Repeating Characters

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        for(int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
        	res = Math.max(res, helper(s, k, numUniqueTarget));
        }
        return res;
    }

    private int helper(String s, int k, int numUniqueTarget) {
    	int[] count = new int[128];
    	int start = 0, end = 0;
    	int numUnique = 0, numNoLessThanK = 0;
    	int res = 0;

    	while(end < s.length()) {
    		if(count[s.charAt(end)]++ == 0) numUnique++;
    		if(count[s.charAt(end++)] == k) numNoLessThanK++;

    		while(numUnique > numUniqueTarget) {
    			if(count[s.charAt(start)]-- == k) numNoLessThanK--;
    			if(count[s.charAt(start++)] == 0) numUnique--;
    		}
    		if(numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
    			res = Math.max(end - start, res);
    		}
    	}
    	return res;
    }
}