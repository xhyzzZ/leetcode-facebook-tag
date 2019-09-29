//leetcode 430 Flatten a Multilevel Doubly Linked List

/*
time: O(n)
space: O(1)
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/

public class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node cur = head;
        Stack<Node> stack = new Stack<>(); // store curt.next when curt.child is not null
        
        while (cur != null) {
            if (cur.child != null) {
                stack.push(cur.next); // might be null
                cur.next = cur.child;
                if (cur.next != null) cur.next.prev = cur;
                cur.child = null;
            } else if (cur.next == null && !stack.isEmpty()) { // reach of tail of child, reconnet the next of parent
                cur.next = stack.pop();
                if (cur.next != null) cur.next.prev = cur;
            }
            
            cur = cur.next;
        }
        return head;
    }
}        

public class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
	    // Pointer
        Node p = head;
        while (p != null) {
            if (p.child != null) {
                /* CASE 2: got child, find the tail of the child and link it to p.next */
                Node temp = p.child;
                // Find the tail of the child
                while (temp.next != null) {
                    temp = temp.next;
                }
                // Connect tail with p.next, if it is not null
                temp.next = p.next;  
                if (p.next != null)  p.next.prev = temp;
                // Connect p with p.child, and remove p.child
                p.next = p.child; 
                p.child.prev = p;
                p.child = null;
            }
            /* CASE 1: if no child, proceed */
            p = p.next;
        }
        return head;
    }
}

