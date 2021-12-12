// leetcode 503 Next Greater Element II

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        // Loop once, we can get the Next Greater Number of a normal array.
        // Loop twice, we can get the Next Greater Number of a circular array
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }   
        return next;
    }
}