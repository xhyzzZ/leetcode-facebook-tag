//leetcode 708 Insert into a Cyclic Sorted List

/*
time: O()
space: O()
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        // if start is null, create a node pointing to itself and return
        if (start == null) {
            Node node = new Node(x, null);
            node.next = node;
            return node;
        }
        // if start is not null, try to insert it into correct position
        // 1st pass to find max node
        Node cur = start;
        while (cur.val <= cur.next.val && cur.next != start) 
            cur = cur.next;
        // 2nd pass to insert the node in to correct position
        Node max = cur;
        Node dummy = new Node(0, max.next); // use a dummy head to make insertion process simpler
        max.next = null; // break the cycle
        cur = dummy;
        while (cur.next != null && cur.next.val < x) {
            cur = cur.next;
        }
        cur.next = new Node(x, cur.next); // insert
        Node newMax = max.next == null ? max : max.next; // reconnect to cycle
        newMax.next = dummy.next;
        return start;
    }
}