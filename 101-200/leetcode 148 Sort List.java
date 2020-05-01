//leetcode 148 Sort List

/*
time: O(nlogn)
space: O(1)
*/
/*
buttom up
*/
public class Solution {
    public ListNode sortList(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	int n = 0;
    	while (head != null) {
    		head = head.next;
    		n++;
    	}

    	for (int step = 1; step < n; step *= 2) {
    		ListNode prev = dummy;
    		ListNode cur = dummy.next;
    		while (cur != null) {
    			ListNode left = cur;
    			ListNode right = split(left, step);
    			cur = split(right, step);
    			prev = merge(left, right, prev);
    		}
    	}
    	return dummy.next;
    }

    private ListNode split(ListNode head, int step) {
    	if (head == null) return null;

    	for (int i = 1; head.next != null && i < step; i++) {
    		head = head.next;
    	}
    	ListNode right = head.next;
    	head.next = null;
    	return right;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
    	ListNode cur = prev; 
    	while (left != null && right != null) {
    		if (left.val < right.val) {
    			cur.next = left;
    			left = left.next;
    		} else {
    			cur.next = right;
    			right = right.next;
    		}
    		cur = cur.next;
    	}
    	if (left != null) cur.next = left;
    	else if (right != null) cur.next = right;
    	while (cur.next != null) cur = cur.next;
    	return cur;
    }
}


public class Solution {
    public ListNode sortList(ListNode head) {
        //bottom case
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        
        //p1 move 1 step every time, p2 move 2 step every time, pre record node before p1
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = head;
        
        while (p2 != null && p2.next != null) {
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        //change pre next to null, make two sub list(head to pre, p1 to p2)
        pre.next = null;
        
        //handle those two sub list
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(p1);
        
        return merge(h1, h2);   
    }
    
    //merge two sorted list, return result head
    public ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        
        if (h1.val < h2.val) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h1, h2.next);
            return h2;
        }
        
    }
}