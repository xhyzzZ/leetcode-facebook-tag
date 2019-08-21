//leetcode 314 Binary Tree Vertical Order Traversal


/*
time: O(n)
space: O(h)

1. BFS, put node, col into queue at the same time
2. Every left child access col - 1 while right child col + 1
3. This maps node into different col buckets
4. Get col boundary min and max on the fly
5. Retrieve result from cols
*/
public class Solution {
	public List<List<Integer>> verticalOrder(TreeNode root) {
	    List<List<Integer>> res = new ArrayList<>();
	    if (root == null) return res;
	    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	    Queue<TreeNode> queue = new LinkedList<>();
	    Queue<Integer> cols = new LinkedList<>();

	    queue.add(root); 
	    cols.add(0);

	    int min = 0;
	    int max = 0;
	    while (!queue.isEmpty()) {
	        TreeNode node = queue.poll();
	        int col = cols.poll();
	        
	        if (!map.containsKey(col)) {
	            map.put(col, new ArrayList<Integer>());
	        }
	        map.get(col).add(node.val);

	        if (node.left != null) {
	            queue.add(node.left); 
	            cols.add(col - 1);
	            //记录左边界
	            min = Math.min(min, col - 1);
	        }
	        
	        if (node.right != null) {
	            queue.add(node.right);
	            cols.add(col + 1);
	            //记录右边界
	            max = Math.max(max, col + 1);
	        }
	    }
	    for (int i = min; i <= max; i++) {
	        res.add(map.get(i));
	    }
	    return res;
	}
}