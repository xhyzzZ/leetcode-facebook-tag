//leetcode 161 One Edit Distance


/*
time: O(n)
space: O(1)

*/
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        int i = 0, j = 0, err = 0;
        while (i < s.length() && j < t.length()) {
        	if (s.charAt(i) != t.charAt(j)) {
        		err++;
        		if (err > 1) return false;
        		if (s.length() > t.length()) j--;
        		else if (s.length() < t.length()) i--;
        	}
        	i++;
        	j++;
        }
        return (err == 1 || (err == 0 && t.length() != s.length())) ? true : false;
    }
}