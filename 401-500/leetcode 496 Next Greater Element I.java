// leetcode 496 Next Greater Element I

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // map from x to next greater element of x
        Map<Integer, Integer> map = new HashMap<>(); 
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) map.put(stack.pop(), num);
            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) res[i] = map.getOrDefault(nums1[i], -1);
        return res;
    }
}