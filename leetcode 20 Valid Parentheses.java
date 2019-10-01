//leetcode 20 Valid Parentheses

//time:O(n) 
//space: O(n)

public class Solution {
	public boolean isValid(String s) {

		if (s == null || s.length() == 0) return true;
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')')
			else if (c == '{')
				stack.push('}')
			else if (c == '[')
				stack.push(']')
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}