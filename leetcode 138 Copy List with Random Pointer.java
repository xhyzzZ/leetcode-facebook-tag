//leetcode 138 Copy List with Random Pointer

/*
time: O(n)
space: O(n)
*/
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while(cur != null) {
        	map.put(cur, new RandomListNode(cur.label));
        	cur = cur.next;
        }
        cur = head;
        while(cur != null) {
        	map.get(cur).next = map.get(cur.next);
        	map.get(cur).random = map.get(cur.random);
        	cur = cur.next;
        }
        return map.get(head);
    }
}