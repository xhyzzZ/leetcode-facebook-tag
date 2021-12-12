// leetcode 384 Shuffle an Array

/*
time: O(n)
space: O(n)
*/

class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) return null;
        int[] copy = nums.clone();
        for (int j = 1; j < copy.length; j++) {
            // nextInt(j + 1) returns a random num between [0, j]
            int i = random.nextInt(j + 1);
            swap(copy, i, j);
        }
        return copy;
    }

    private void swap(int[] copy, int i, int j) {
        int t = copy[i];
        copy[i] = copy[j];
        copy[j] = t;
    }
}