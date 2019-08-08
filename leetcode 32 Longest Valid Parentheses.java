//leetcode 32 Longest Valid Parentheses



/*
time: O(n)
space: O(n)

0 1 2 3 4 5
) ( ) ( ) )
stack 1 -> 0
start = 0 i = 0
              2
res = 2
*/
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int start = -1;   /* 防止一开始元素为空 */
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') {
        		stack.push(i);
        	} else {
        		if (stack.isEmpty()) {
        			start = i;
        		} else {
        			stack.pop();
        			if (stack.isEmpty()) {
        				res = Math.max(res, i - start);
        			} else {
        				res = Math.max(res, i - stack.peek());   /*   0 1 2 3 4 5    */
        			}                                            /*	  (	( ) )		 */
        		}
        	}
        }
        return res;
    }
}