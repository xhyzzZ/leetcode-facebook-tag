//leetcode 340 Longest Substring with At Most K Distinct Characters

/*
time: O(n)
space: O(128)
*/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    	if (s == null || s.length() == 0) return 0;
	    int[] map = new int[128];
	    int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

	    while (end < s.length()) {
	      	char c1 = s.charAt(end);
	      	if (map[c1] == 0) counter++;
	      	map[c1]++;
	      	
	      	while (counter > k) {
		        char c2 = s.charAt(start);
		        if (map[c2] == 1) counter--;
		        map[c2]--;
		        start++;
	      	}
	      	maxLen = Math.max(maxLen, end - start + 1);
	      	end++;
	    }
	    return maxLen;
  	}
}