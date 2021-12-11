// leetcode 287 Find the Duplicate Number

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length() > 1) {
        	int slow = nums[0];
        	int fast = nums[nums[0]];
        	while (slow != fast) {
        		slow = nums[slow];
        		fast = nums[nums[fast]];
        	}
        	fast = 0;
        	while (fast != slow) {
        		fast = nums[fast];
        		slow = nums[slow];
        	}
        	return slow;
        }
        return -1;
    }
}

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }
}