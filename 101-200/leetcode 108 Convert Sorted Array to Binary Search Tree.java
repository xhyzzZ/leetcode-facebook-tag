//leetcode 108 Convert Sorted Array to Binary Search Tree


/*
time: O(n)
space: O(logn)
*/
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode helper(int[] nums, int low, int high) {
    	if (low > high) return null;

    	int mid = (high - low) / 2 + low;
    	TreeNode node = new TreeNode(nums[mid]);
    	node.left = helper(nums, low, mid - 1);
    	node.right = helper(nums, mid + 1, high);
    	return node;
    }
}