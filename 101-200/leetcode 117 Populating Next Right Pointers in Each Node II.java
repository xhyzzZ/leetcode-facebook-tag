//leetcode 117 Populating Next Right Pointers in Each Node II

/*
time: O(n)
space: O(1)
*/
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        // - - - - - - - - - - - - - - - - - 
        while (root != null) {
            // 每一层 层序遍历建立链表
            TreeLinkNode cur = dummy;
            while (root != null) {
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            // root为空，则重建dummy
            root = dummy.next;
            dummy.next == null;
        }
    }
}