//leetcode 654 Maximum Binary Tree

/*
time: O(n)
space: O()
*/
3 2 1 6 0 5

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
        	TreeNode cur = new TreeNode(nums[i]);
        	while(!stack.isEmpty() && stack.peek().val < nums[i]) {
        		cur.left = stack.pop();
        	}
        	if(!stack.isEmpty()) {
        		stack.peek().right = cur;
        	}
        	stack.push(cur);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }
}


/*
time: O(nlogn) ~ O(n^2)
space: O(nlogn) ~ O(n^2)
*/
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        
        int idxMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[idxMax]) {
                idxMax = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[idxMax]);
        
        root.left = build(nums, start, idxMax - 1);
        root.right = build(nums, idxMax + 1, end);
        
        return root;
    }
}