// leetcode 992 ubarrays with K Different Integers

/*
time: O(n)
space: O(n)
*/

// exactly(k) = atMost(k) - atMost(k-1)
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);  
    }
    
    // all subarrays with <= k distinct numbers are counted.
    private int atMostK(int[] nums, int k) {
        int start = 0, end = 0;
        int sum = 0;
        int counter = 0; 
        Map<Integer, Integer> map = new HashMap<>();
        while (end < nums.length) {
            if (map.getOrDefault(nums[end], 0) == 0) {
                counter++;
            }
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            
            while (counter > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) {
                    counter--;
                }
                start++;
            }
            sum += end - start + 1;
            end++;
        }
        return sum;
    }
}