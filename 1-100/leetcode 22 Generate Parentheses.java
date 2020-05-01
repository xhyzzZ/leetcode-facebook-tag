//leetcode 22 Generate Parentheses


//time: O(2 ^ 2n)
//space: O(n)
//卡特兰数

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        // Stop printing out “(“ when the number of “(“ s hit n.
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        // print “)” only when there are more “(“s than “)”s
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }
}