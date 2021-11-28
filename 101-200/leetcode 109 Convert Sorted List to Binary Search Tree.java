// leetcode 109 Convert Sorted List to Binary Search Tree

/*
time: O(nlogn)
space: O(logn)
*/

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
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

/*
time: O(n)
space: O(n)
*/

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> values = new ArrayList<>();

        // Form an array out of the given linked list and then
        // use the array to form the BST.
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        // Convert the array to
        return convertListToBST(0, values.size() - 1, values);
    }

    private TreeNode convertListToBST(int left, int right, List<Integer> values) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(values.get(mid));

        // Base case
        if (left == right) return node;

        node.left = convertListToBST(left, mid - 1);
        node.right = convertListToBST(mid + 1, right);
        return node;
    }
}