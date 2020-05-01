//leetcode 25 Reverse Nodes in k-Group


//time: O(n)
//space: O(1)
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head = null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null) {
            prev = reverse(prev, k);
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode prev, int k) {
        ListNode last = prev;
        for (int i = 0; i < k + 1; i++) {
            last = last.next;
            if (i != k && last == null) return null;
        }
        ListNode tail = prev.next;
        ListNode cur = prev.next.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            tail.next = next;
            cur = next;
        }
        return tail;
    }

//time: O(n)
//space: O(n)
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