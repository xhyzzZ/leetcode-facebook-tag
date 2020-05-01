//leetcode 5 Longest Palindromic Substring

/*
time: O(n^2)
space: O(1)
*/

public class Solution {
	public String longestPalindrome(String s) {
		// use array in order to pass by reference instead of pass by value
		int len = s.length();
		if (len < 2) return s;
		int[] maxStart = new int[1], maxEnd = new int[1]; 
		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i, maxStart, maxEnd);
			extendPalindrome(s, i, i + 1, maxStart, maxEnd);
		}
		return s.substring(maxStart[0], maxEnd[0] + 1);
	}

	private void extendPalindrome(String s, int i, int j, int[] maxStart, int[] maxEnd) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}
		if (j - i + 1 > maxEnd[0] - maxStart[0] + 1) {
            maxStart[0] = i;
            maxEnd[0] = j;
        }
	}
}