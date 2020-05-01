//leetcode 171 Excel Sheet Column Number

/*
time: O(n)
space: O(1)
*/
public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
        	res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}