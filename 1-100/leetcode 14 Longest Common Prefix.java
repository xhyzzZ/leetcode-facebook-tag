//leetcode 14 Longest Common Prefix

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";

        String first = strs[0], last = strs[0];

        for (String str : strs) {
        	if (str.compareTo(first) < 0) {
        		first = str;
            }
        	if (str.compareTo(last) > 0) {
        		last = str;
            }
        }

        int i = 0, len = Math.min(first.length(), last.length());

        while (i < len && first.charAt(i) == last.charAt(i)) i++;

        return first.substring(0, i);
    }
}

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }
}