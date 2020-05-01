//leetcode 2 Add Two Numbers

/*
time: O(n)
space: O(1)
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0), cur = dummy;
        
        // iterate two list, add each position until 2 lists are finished && carry equals to 0
        while (l1 != null || l2 != null || carry != 0) {
            // is number1 finished?
            int add1 = l1 != null ? l1.val : 0;
            // is number2 finished?
            int add2 = l2 != null ? l2.val : 0;
            int sum = add1 + add2 + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            cur.next = newNode;
            cur = newNode;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}