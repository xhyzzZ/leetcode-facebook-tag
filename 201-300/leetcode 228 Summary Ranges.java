// leetcode 228 Summary Ranges

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; ++j) {
            // check if j + 1 extends the range [nums[i], nums[j]]
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) continue;
            // put the range [nums[i], nums[j]] into the list
            if (i == j) {
                res.add(nums[i] + "");
            } else {
                res.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return res;
    }
}