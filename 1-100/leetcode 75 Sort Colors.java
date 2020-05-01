//leetcode 75 Sort Colors


/*
time: O(n)
space: O(1)
*/
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
        	if (nums[index] == 0) {
        		swap(nums, index++, left++);
        	} else if (nums[index] == 1) {
        		index++;
        	} else {
        		swap(nums, index, right--);
        	}
        }
    }

    public void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}


public class Solution {
    public void sortColors(int[] nums) {
    // 2-pass
    int count0 = 0, count1 = 0, count2 = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) count0++;
        if (nums[i] == 1) count1++;
        if (nums[i] == 2) count2++;
    }
    for (int i = 0; i < nums.length; i++) {
        if (i < count0) {nums[i] = 0;}
        else if (i < count0 + count1) {nums[i] = 1;}
        else {nums[i] = 2;}
    }
}
    