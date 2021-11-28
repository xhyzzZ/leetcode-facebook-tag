// leetcode 25 Reverse Nodes in k-Group

/*
time: O(n)
space: O(n)
*/

// recursive
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode next = dummy.next;
        while (next != null) {
            for (int i = 0; i < k && next != null; i++) {
                stack.push(next);
                next = next.next;
            }
            if (stack.size() != k) return dummy.next;
            while (stack.size() != 0) {
                cur.next = stack.pop();
                cur = cur.next;
            }
            cur.next = next;
        }
        return dummy.next;
    }
}

/*
time: O(n)
space: O(1)
*/

// iterative 
class Solution {        
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer != null) {
            ListNode node = pointer;
            // first check whether there are k nodes to reverse
            for (int i = 0; i < k && node != null; i++) {
                node = node.next;
            }
            if (node == null) break;
            
            // now we know that we have k nodes, we will start from the first node
            ListNode prev = null, curr = pointer.next, next = null;
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode tail = pointer.next;
            tail.next = curr;
            pointer.next = prev;
            pointer = tail;
        }
        return dummy.next;
    }
}