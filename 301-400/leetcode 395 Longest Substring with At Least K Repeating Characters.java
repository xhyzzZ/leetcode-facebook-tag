// leetcode 395 Longest Substring with At Least K Repeating Characters

/*
time: O(maxUnique * n)
space: O(1)
*/

public class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        int maxUnique = getMaxUniqueLetters(s);
        for(int currUnique = 1; currUnique <= maxUnique; currUnique++) {
        	res = Math.max(res, slideWindow(s, k, currUnique));
        }
        return res;
    }

    private int getMaxUniqueLetters(String s) {
        boolean[] map = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }

    private int slideWindow(String s, int k, int currUnique) {
    	int[] map = new int[128];
    	int start = 0, end = 0;
    	int numUnique = 0, numNoLessThanK = 0;
    	int res = 0;

    	while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] == 0) numUnique++;
            map[c1]++;
            if (map[c1] == k) numNoLessThanK++;

    		while (numUnique > currUnique) {
                char c2 = s.charAt(start);
                if (map[c2] == k) numNoLessThanK--;
                map[c2]--;
                if (map[c2] == 0) numUnique--;
                start++;;
    		}

    		if (numUnique == currUnique && numUnique == numNoLessThanK) {
    			res = Math.max(end - start + 1, res);
    		}

            end++;
    	}
    	return res;
    }
}
