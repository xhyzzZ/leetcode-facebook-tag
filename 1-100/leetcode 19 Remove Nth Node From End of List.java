//leetcode 19 Remove Nth Node From End of List


//time: O(n)
//space: O(1)
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        // fast
        // slow
        //                   fast
        //								     fast
        //                   slow
        dummy.next = head;
        for (int i = 0; i <= n; i++) {
        	fast = fast.next;
        }
        while (fast != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}