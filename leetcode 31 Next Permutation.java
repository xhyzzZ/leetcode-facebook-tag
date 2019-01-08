//leetcode 31 Next Permutation


/*
time: O(n)
space: O(1)
1  2  7  4  3  1
   ^
1  2  7  4  3  1
            ^
1  3  7  4  2  1
   ^        ^
1  3  1  2  4  7
      ^  ^  ^  ^

7 4 3 2 1 1 firstSmall = 
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums == null) return;

        int firstSmall = -1;
        for(int i = nums.length - 2; i >= 0; i--) {
        	if(nums[i] < nums[i + 1]) {
        		firstSmall = i;
        		break;
        	}
        }
        if(firstSmall == -1) {
        	reverse(nums, 0, nums.length - 1);
        	return;
        }

        int firstLarge = -1;
        for(int i = nums.length - 1; i > firstSmall; i--) {
        	if(nums[i] > nums[firstSmall]) {
        		firstLarge = i;
        		break;
        	}
        }

        swap(nums, firstSmall, firstLarge);
        reverse(nums, firstSmall + 1, nums.length - 1);
        return;
    }

    public void swap(int[]nums, int i, int j) {
    	int temp = nums[i];
    	nums[i++] = nums[j];
    	nums[j--] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
    	while(i < j) {
    		swap(nums, i++, j--);
    	}
    }
}