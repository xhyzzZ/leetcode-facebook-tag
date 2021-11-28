// leetcode 141 Linked List Cycle

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) return true;
        }
        return false;
    }
}