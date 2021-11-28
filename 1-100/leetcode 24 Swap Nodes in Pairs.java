// leetcode 24 Swap Nodes in Pairs

/*
time: O(n)
space: O(1)
*/

// iterative
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            // Nodes to be swapped
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Reinitializing the head and prevNode for next swap
            prev = first;
            head = first.next;
        }
        return dummy.next;
    }
}

/*
time: O(n)
space: O(1)
*/

// recursive
class Solution {
    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode first = head;
        ListNode second = head.next;

        // Swapping
        first.next  = swapPairs(second.next);
        second.next = first;

        // Now the head is the second node
        return second;
    }
}