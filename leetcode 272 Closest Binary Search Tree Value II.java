//leetcode 272 Closest Binary Search Tree Value II

/*
time: O(n)
space: O(k)
*/

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        inorder(list, root, target, k);
        return list;
    }
    
    private void inorder(LinkedList<Integer> list, TreeNode root, double target, int k) {
        if (root == null) return;
        inorder(list, root.left, target, k);
        
        if (list.size() == k) {
            if (Math.abs(list.getFirst() - target) < Math.abs(root.val - target)) {
                return;
            } else {
                list.removeFirst();
            }
        }
        
        list.addLast(root.val);
        inorder(list, root.right, target, k);
    }
}

/*
time: O(logn + k)
space: O(logn)
*/

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new LinkedList<Integer>();
        // populate the predecessor and successor stacks 
        Stack<TreeNode> pred = new Stack<TreeNode>();
        Stack<TreeNode> succ = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null) {
            if (target <= curr.val) {
                succ.push(curr);
                curr = curr.left;
            } else {
                pred.push(curr);
                curr = curr.right;
            }
        }
        while (k > 0) {
            if (pred.empty() && succ.empty()) {
                break; 
            } else if (pred.empty()) {
                result.add(getSuccessor(succ));
            } else if (succ.empty()) {
                result.add(getPredecessor(pred));
            } else if (Math.abs(target - pred.peek().val) < Math.abs(target - succ.peek().val)) {
                result.add(getPredecessor(pred));                    
            } else {
                result.add(getSuccessor(succ));
            }
            k--;
        }
        return result;
     }

    private int getPredecessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.left;
        while (p != null) {
            st.push(p);
            p = p.right;
        }
        return popped.val;
    }

    private int getSuccessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.right;
        while (p != null) {
            st.push(p);
            p = p.left;
        }
        return popped.val;
    }
}

/*
time: O(n)
space: O(n)
*/
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> dq = new LinkedList<>();
        inorder(root, dq);
        while (dq.size() > k) {
            if (Math.abs(dq.peekFirst() - target) > Math.abs(dq.peekLast() - target))
                dq.pollFirst();
            else 
                dq.pollLast();
        }
        
        return new ArrayList<Integer>(dq);
    }
    
    public void inorder(TreeNode root, Deque<Integer> dq) {
        if (root == null) return;
        inorder(root.left, dq);
        dq.add(root.val);
        inorder(root.right, dq);
    }
}