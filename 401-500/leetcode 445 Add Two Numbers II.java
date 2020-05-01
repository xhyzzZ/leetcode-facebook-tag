//leetcode 445 Add Two Numbers II

/*
time: O(n)
space: O(n)
*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
        	s1.push(l1.val);
        	l1 = l1.next;
        }
        while (l2 != null) {

        	s2.push(l2.val);
        	l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
        	if (!s1.empty()) sum += s1.pop();
        	if (!s2.empty()) sum += s2.pop();
        	list.val = sum % 10;
        	ListNode head = new ListNode(sum / 10);
        	head.next = list;
        	list = head;
        	sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        ListNode head = new ListNode(1);
        // Make sure l1.length >= l2.length
        head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
        // Handle the first digit
        if (head.next.val > 9) {
            head.next.val = head.next.val % 10;
            return head;
        }
        return head.next;
    }
    // get length of the list
    public int getLength(ListNode l) {
        int count = 0;
        while(l != null) {
            l = l.next;
            count++;
        }
        return count;
    }
    // offset is the difference of length between l1 and l2
    public ListNode helper(ListNode l1, ListNode l2, int offset) {
        if (l1 == null) return null;
        // check whether l1 becomes the same length as l2
        ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
        // handle carry 
        if (post != null && post.val > 9) {
            result.val += 1;
            post.val = post.val % 10;
        }
        // combine nodes
        result.next = post;
        return result;
    }
}