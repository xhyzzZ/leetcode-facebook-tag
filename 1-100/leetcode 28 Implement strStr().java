// leetcode 28 Implement strStr()

/*
time: O(n^2)
space: O(1)
*/

//substring: linear complexity O(n)
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        	if (haystack.substring(i, i + needle.length()).equals(needle)) return i;      
        }
        return -1;
    }
}