// leetcode 503 Next Greater Element II

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        // Loop once, we can get the Next Greater Number of a normal array.
        // Loop twice, we can get the Next Greater Number of a circular array
        for (int i = 0; i < len * 2; i++) {
            int num = nums[i % len]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num) res[stack.pop()] = num;
            if (i < len) stack.push(i);
        }   
        return res;
    }
}