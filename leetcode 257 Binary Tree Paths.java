//leetcode 257 Binary Tree Paths

/*
time: O()
space: O()
*/
public class Solution {
	//recursion
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<String>();

        if(root == null) return res;
        if(root.left == null && root.right == null) {
        	res.add(Integer.toString(root.val));
        	return res;
        }

        for(String s : binaryTreePaths(root.left)) {
        	res.add(Integer.toString(root.val) + "->" + s);
        }
        for(String s : binaryTreePaths(root.right)) {
        	res.add(Integer.toString(root.val) + "->" + s);
        }
        return res;
    }


    public List binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, "");
        return res;
    }
    /*
	time: O(n)
    */
    private void dfs(TreeNode root, List ls, String accum) {
        if (root == null) return;
        accum += (accum.length() == 0 ? "" : "->") + root.val;
        if (root.left == null && root.right == null) {
            ls.add(accum);
            return;
        }
        dfs(root.left, ls, accum);
        dfs(root.right, ls, accum);
    }
}