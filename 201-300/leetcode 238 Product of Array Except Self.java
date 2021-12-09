// leetcode 238 Product of Array Except Self

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        // res[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the res[0] would be 1
        res[0] = 1;
        for (int i = 1; i < length; i++) {
            // res[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all 
            // elements to the left of index 'i'
            res[i] = nums[i - 1] * res[i - 1];
        }

        // right contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the right would be 1
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            // For the index 'i', right would contain the 
            // product of all elements to the right. We update right accordingly
            res[i] = res[i] * right;
            right *= nums[i];
        }

        return res;
    }
}