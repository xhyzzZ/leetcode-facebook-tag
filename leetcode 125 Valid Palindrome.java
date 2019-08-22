//leetcode 125 Valid Palindrome


/*
time: O(n)
space: O(1)
*/
public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0; 
        int j = s.length - 1;
        char[] c = s.toCharArray();
        while (i < j) {
        	while (i < s.length() && !valid(c[i])) i++;
        	while (j >= 0 && !valid(c[j])) j--;
        	if (i < j && Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) {
        		return false;
        	}
        	i++;
        	j--;
        }
        return true;
    }
    public boolean valid(char c) {
    	return (c >= 'a' && c <= 'z') ||
    	       (c >= 'A' && c <= 'Z') ||
    	       (c >= '0' && c <= '9');

    }
}