//leetcode 652 Find Duplicate Subtrees

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        postOrder(root, map, res);
        return res;
    }
    private String postOrder(TreeNode root,Map<String, Integer> map, List<TreeNode> res) {
        if(root == null) {
            return "#";
        }
        String left = postOrder(root.left, map, res);
        String right = postOrder(root.right, map, res);
        String serial = left + "," + right + "," + root.val;
        if(map.containsKey(serial) && map.get(serial) == 1){
            res.add(root);
        }
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}