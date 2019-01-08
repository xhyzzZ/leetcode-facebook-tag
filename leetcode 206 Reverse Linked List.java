//leetcode 206 Reverse Linked List

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur != null) {
        	cur.next = prev;
        	prev = cur;
        	cur = next;
        	if(cur != null) {
        		next = cur.next;
        	}
        }
        return pre;    
    }
}