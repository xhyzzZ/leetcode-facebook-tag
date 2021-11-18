// leetcode 919 Complete Binary Tree Inserter

/*
time: O()
space: O()
*/

// O(1) Build Tree + O(N) Insert:
class CBTInserter {

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }
    
    public int insert(int val) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (true) {
            TreeNode n = q.poll();
            if (n.right != null) { // n has 2 children.
                q.offer(n.left);    
                q.offer(n.right);
            } else {  // n has at most 1 child.
                if (n.left == null) { 
                    n.left = new TreeNode(val); 
                } else { 
                   n.right = new TreeNode(val); 
                }
                return n.val;
            }
        } 
    }
    
    public TreeNode get_root() {
        return root;
    }
}


// O(1) Insert + O(N) Build Tree
class CBTInserter {

    private TreeNode root;
    private Queue<TreeNode> queue;
    
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            TreeNode cur = queue.peek();
            if (cur.left != null && cur.right != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
                queue.poll();
            } else {
                break;
            }
        }
    }
    
    public int insert(int val) {
        TreeNode cur = queue.peek();
        if (cur.left == null) {
            cur.left = new TreeNode(val);
        } else {
            cur.right = new TreeNode(val);
            queue.offer(cur.left);
            queue.offer(cur.right);
            queue.poll();
        }
        return cur.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}
