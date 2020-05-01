//leetcode 109 Convert Sorted List to Binary Search Tree


/*
time: O(nlogn)
space: O(logn)
*/
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }
    public TreeNode helper(ListNode head, ListNode tail) {
    	ListNode slow = head;
    	ListNode fast = head;
    	if (head = tail) return null;

    	while (fast != tail && fast.next != tail) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	TreeNode thread = new TreeNode(slow.val);
    	thread.left = helper(head, slow);
    	thread.right = helper(slow.next, tail);
    	return thread;
    }
}