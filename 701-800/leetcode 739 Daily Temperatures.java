// leetcode 739 Daily Temperatures

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
        	while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        		int index = stack.pop();
        		res[index] = i - index;
        	}
        	stack.push(i);
        }
        return res;
    }
}