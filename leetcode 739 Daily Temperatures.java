//leetcode 739 Daily Temperatures

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
        	while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
        		int index = stack.pop();
        		res[index] = i - index;
        	}
        	stack.push(i);
        }
        return res;
    }
}