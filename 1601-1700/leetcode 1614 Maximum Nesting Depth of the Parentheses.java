// leetcode 1614 Maximum Nesting Depth of the Parentheses

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        for (int i = 0, depth = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') depth += c == '(' ? 1 : -1;
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
}