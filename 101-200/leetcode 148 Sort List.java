// leetcode 148 Sort List

/*
time: O(nlogn)
space: O(1)
*/

// buttom up
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


/*
time: O(nlogn)
space: O(logn)
*/

// Top Down
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
    
        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            } 
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }
}
