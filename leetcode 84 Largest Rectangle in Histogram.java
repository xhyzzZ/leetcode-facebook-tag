//leetcode 84 Largest Rectangle in Histogram

/*
time: O(n)
space: O(n)

stack: 1. 升序 2. 小于，计算
*/
public class Solution {
    public int largestRectangleArea(int[] heights) {
    	if (heights == null || heights.length == 0) return 0;
    	Stack<Integer> stack = new Stack<>();
    	int res = 0;
    	for (int i = 0; i <= heights.length; i++) {
    		int h = (i == heights.length ? 0 : heights[i]);
    		while (!stack.isEmpty() && h < heights[stack.peek()]) {
    			int height = heights[stack.pop()]; // 
    			int start = stack.isEmpty() ? -1 : stack.peek();
    			int area = height * (i - start - 1);
    			res = Math.max(res, area);
    		}
    		stack.push(i);
    	}
    	return res;
    }
}