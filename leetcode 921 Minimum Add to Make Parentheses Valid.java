//leetcode 921 Minimum Add to Make Parentheses Valid

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int minAddToMakeValid(String S) {
        int count = 0, stk = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') { 
            	++stk; 
            } else if (stk <= 0) { 
            	++count; 
            } else { 
            	--stk; 
            }
        }
        return count + stk;
    }
}