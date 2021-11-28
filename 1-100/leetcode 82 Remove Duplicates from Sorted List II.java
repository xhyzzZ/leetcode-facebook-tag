// leetcode 82 Remove Duplicates from Sorted List II

/*
time: O(n)
space: O(1)
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (head != null) {
            // if it's a beginning of duplicates sublist 
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;    
                }
                // skip all duplicates
                prev.next = head.next;     
            // otherwise, move predecessor
            } else {
                prev = prev.next;    
            }
            head = head.next;    
        }  
        return dummy.next;
    }
}