//leetcode 199 Binary Tree Right Side View

/*
time: O(n)
space: O(h)
*/

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<Integer> res = new ArrayList();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (size == 0) {
                    res.add(cur.val);
                }
                
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }
}