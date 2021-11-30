// leetcode 445 Add Two Numbers II

/*
time: O(n1 + n2)
space: O(1)
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x1 = l1 != null ? l1.val : 0;
            int x2 = l2 != null ? l2.val : 0;
            
            int val = (carry + x1 + x2) % 10;
            carry = (carry + x1 + x2) / 10;
            
            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;
            
            // move to the next elements in the lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;
        }

        return head;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;    
        }    
        return prev;
    }
}

/*
time: O(n1 + n2)
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
