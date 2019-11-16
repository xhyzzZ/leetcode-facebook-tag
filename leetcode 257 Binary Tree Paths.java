//leetcode 257 Binary Tree Paths

/*
time: O(n)
space: O(h)
*/
recursion
public class Solution {
	//recursion
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<String>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
        	res.add(Integer.toString(root.val));
        	return res;
        }
        for (String s : binaryTreePaths(root.left)) {
        	res.add(Integer.toString(root.val) + "->" + s);
        }
        for (String s : binaryTreePaths(root.right)) {
        	res.add(Integer.toString(root.val) + "->" + s);
        }
        return res;
    }
}
/*
time: O(n)
space: O(h)
*/
dfs
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }
    
    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }
}