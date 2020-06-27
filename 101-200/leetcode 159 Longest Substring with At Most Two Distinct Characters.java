//leetcode 159 Longest Substring with At Most Two Distinct Characters

/*
time: O(n)
space: O(128)
*/

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            
            while (counter > 2) {
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


public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 1) return 0;
        HashMap<Character, Integer> index = new HashMap<Character, Integer>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while (hi < s.length()) {
        	if (index.size() <= 2) {
        		char c = s.charAt(hi);
        		index.put(c, hi);
        		hi++;
        	} 
        	if (index.size() > 2) {
        		int leftMost = s.length();
        		for (int i : index.values()) {
        			leftMost = Math.min(leftMost, i);
        		}
        		char c = s.charAt(leftMost);
        		index.remove(c);
        		lo = leftMost + 1;
        	}
        	maxLength = Math.max(maxLength, hi - lo);
        }
        return maxLength;
    }
}
