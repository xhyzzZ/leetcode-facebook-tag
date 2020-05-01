//leetcode 680 Valid Palindrome II


/*
time: O(n)
space: O(1)
*/
public class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right =  s.length() - 1;
        while (left <= right) {
        	if (s.charAt(left) == s.charAt(right)) {
        		left++;
        		right--;
        	} else {
        		return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
        	}
        }
        return true;
    }


    private boolean isPalindrome(String str, int s, int t) {
    	while (s <= t) {
    		if (str.charAt(s) == str.charAt(t)) {
    			s++;
    			t--;
    		} else return false;
    	}
    	return true;
    }
}