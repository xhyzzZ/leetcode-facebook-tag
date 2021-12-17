// leetcode 1762 Buildings With an Ocean View

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        // Assume that the first building can see the ocean
        stack.push(0);
        // Walk through list of buildings
        for (int i = 1; i < heights.length;i++) {
            // If the height of the current building is taller than whats in the stack
            // it needs to be the first building in the stack
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.pop();
            }
            // We know that we have the next tallest building in the input array
            stack.push(i);
        }
        
        // Our stack now contains only the buildings that have a view of the ocean and we need to return it in the appropriate form
        int[] res = new int[stack.size()];
        int n = stack.size();
        for (int i = n - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return res;
    }
}