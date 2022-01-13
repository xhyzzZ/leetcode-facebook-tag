// leetcode 2089 Find Target Indices After Sorting Array

/*
time: O(n)
space: O(1)
*/

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0, lessThan = 0;
        for (int n : nums) {
            if (n == target) count++;
            if (n < target) lessThan++;
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            res.add(lessThan++);
        }
        return res;
    }
}