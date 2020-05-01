//leetcode 1019 Next Greater Node In Linked List

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i)) {
                res[stack.pop()] = A.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}