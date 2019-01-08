//leetcode 314 Binary Tree Vertical Order Traversal


/*
time: O()
space: O()
*/
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
	    if(root == null)    return list;
	    computeRange(root, 0);
	    for(int i = min; i <= max; i++) list.add(new ArrayList<>());
	    Queue<TreeNode> q = new LinkedList<>();
	    Queue<Integer> idx = new LinkedList<>();
	    idx.add(-min);
	    q.add(root);
	    while(!q.isEmpty()){
	        TreeNode node = q.poll();
	        int i = idx.poll();
	        list.get(i).add(node.val);
	        if(node.left != null){
	            q.add(node.left);
	            idx.add(i - 1);
	        }
	        if(node.right != null){
	            q.add(node.right);
	            idx.add(i + 1);
	        }
	    }
	    return list;
	}
	private void computeRange(TreeNode root, int idx){
	    if(root == null)    return;
	    min = Math.min(min, idx);
	    max = Math.max(max, idx);
	    computeRange(root.left, idx - 1);
	    computeRange(root.right, idx + 1);

	}
}