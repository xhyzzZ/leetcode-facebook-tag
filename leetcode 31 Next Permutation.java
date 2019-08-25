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
    public void nextPermutation(int[] A) {
        if (A == null || A.length <= 1) return;
        int i = A.length - 2;
        while (i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
        if (i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while (A[j] <= A[i]) j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }      
}

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums == null) return;

        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
        	if (nums[i] < nums[i + 1]) {
        		firstSmall = i;
        		break;
        	}
        }
        if (firstSmall == -1) {
        	reverse(nums, 0, nums.length - 1);
        	return;
        }

        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
        	if (nums[i] > nums[firstSmall]) {
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
    	while (i < j) {
    		swap(nums, i++, j--);
    	}
    }
}