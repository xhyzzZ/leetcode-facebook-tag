//leetcode 1047 Remove All Adjacent Duplicates In String

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char s : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == s) {
                stack.pop();
            } else {
                stack.push(s);
            }  
        }
        StringBuilder sb = new StringBuilder();
        for (char s : stack) sb.append(s);
        return sb.toString();
    }
}