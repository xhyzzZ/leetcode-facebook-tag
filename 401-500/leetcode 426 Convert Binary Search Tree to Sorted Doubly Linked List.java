//leetcode 426 Convert Binary Search Tree to Sorted Doubly Linked List


/*
time: O(n)
space: O(logn)
Step 1: Divide:
We divide tree into three parts: left subtree, root node, right subtree.
Convert left subtree into a circular doubly linked list as well as the right subtree.
Be careful. You have to make the root node become a circular doubly linked list.

Step 2: Conquer:
Firstly, connect left circular doubly linked list with the root circular doubly linked list.
Secondly, connect them with the right circular doubly linked list. Here we go!
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
    
    // Used to connect two circular doubly linked lists. n1 is the head of circular DLL as well as n2.
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