// leetcode 708 Insert into a Cyclic Sorted List

/*
time: O(n)
space: O(1)
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        // if start is null, create a node pointing to itself and return
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        // if start is not null, try to insert it into correct position
        // 1st pass to find max node
        Node max = head;
        while (max.val <= max.next.val && max.next != head) max = max.next;

        // get the min node and point cur node to min node 
        Node min = max.next, cur = min;

        // if given val is < min or > max, then insert the new node after max.next 
        if (val <= min.val || val >= max.val) max.next = new Node(val, min);
        // otherwise find the correct position to insert
        else {
            while (cur.next != null && cur.next.val < val) cur = cur.next;
            cur.next = new Node(val, cur.next);
        }

        return head;
    }
}