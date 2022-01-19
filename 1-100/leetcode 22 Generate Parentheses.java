// leetcode 22 Generate Parentheses

/*
time: O(2 ^ 2n)
space: O(n)
n-th Catalan number
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
            return;
        }
        // Stop printing out “(“ when the number of “(“ s hit n.
        if (open < max) {
            cur.append("(");
            backtrack(res, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        // print “)” only when there are more “(“s than “)”s
        if (close < open) {
            cur.append(")");
            backtrack(res, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}