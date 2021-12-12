// leetcode 398 Random Pick Index

/*
time: O(n)
space: O(1)
*/

class Solution {

    private int[] nums;
    private Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            // if nums[i] is equal to target, i is a potential candidate
            // which needs to be chosen uniformly at random
            if (nums[i] == target) {
                // increment the count of total candidates
                // available to be chosen uniformly at random
                count++;
                // we pick the current number with probability 1 / count (reservoir sampling)
                if (rand.nextInt(count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
}