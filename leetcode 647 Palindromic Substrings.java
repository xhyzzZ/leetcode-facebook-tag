//leetcode 647 Palindromic Substrings

/*
time: O(n^2)
space: O(1)
*/

public class Solution {
    public int countSubstrings(String s) {
    	int count = 0;
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) {
        	extendPalindrome(s, i, i);
        	extendPalindrome(s, i, i + 1);
        }
        return count;
    }

    private void extendPalindrome(String s, int ieft, int right) {
    	int count = 0;
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		count++;
    		left--;
    		right++;
    	}
    	return count;
    }
}