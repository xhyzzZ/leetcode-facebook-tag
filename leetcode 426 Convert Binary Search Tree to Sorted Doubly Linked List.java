//leetcode 426 Convert Binary Search Tree to Sorted Doubly Linked List


/*
time: O()
space: O()
*/
public class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        
        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        return connect(connect(leftHead, root), rightHead);
    }

    // Used to connect two circular doubly linked lists. n1 is the head as well as n2.
    private Node connect(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        
        Node tail1 = n1.left;
        Node tail2 = n2.left;
        
        tail1.right = n2;
        n2.left = tail1;
        tail2.right = n1;
        n1.left = tail2;
        
        return n1;
    }
}