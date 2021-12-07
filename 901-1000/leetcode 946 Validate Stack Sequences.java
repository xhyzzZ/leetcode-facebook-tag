// leetcode 946 Validate Stack Sequences

/*
time: O(n)
space: O(n)
*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < len && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == len;
    }
}