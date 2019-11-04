//leetcode 116 Populating Next Right Pointers in Each Nod


/*
time: O(n)
space: O(1)
*/
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level = root;
        while (level != null) {
        	TreeLinkNode cur = level;
        	while (cur != null) {
        		if (cur.left != null) cur.left.next = cur.right;
        		if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;

        		cur = cur.next;
        	}
        	level = level.left;
        }
    }
}