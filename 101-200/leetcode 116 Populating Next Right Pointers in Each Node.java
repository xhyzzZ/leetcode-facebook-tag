//leetcode 116 Populating Next Right Pointers in Each Nod


/*
time: O(n)
space: O(1)
*/

// left to right
class Solution {
    public Node connect(Node root) {
        Node level = root;
        while (level != null) {
            Node cur = level;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;

                cur = cur.next;
            }
            level = level.left;
        }
        return root;
    }
}

// right to left
public class Solution {
    public Node connect(Node root) {
        Node level = root;
        while (level != null) {
            Node cur = level;
            while (cur != null) {
                if (cur.right != null) cur.right.next = cur.left;
                if (cur.left != null && cur.next != null) cur.left.next = cur.next.right;

                cur = cur.next;
            }
            level = level.right;
        }
        return root;
    }
}