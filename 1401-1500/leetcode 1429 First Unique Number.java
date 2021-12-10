// leetcode 1429 First Unique Number

/*
time: showFirstUnique() O(1), add() O(1)
space: O(n)
*/

class FirstUnique {
    
    class DLinkedNode {
        int val;
        DLinkedNode pre;
        DLinkedNode post;
        public DLinkedNode(int val){
            this.val = val;
            this.post = null;
            this.pre = null;
        }
    } 
    
    private DLinkedNode head, tail;
    private Map<Integer, DLinkedNode> cache;
    public FirstUnique(int[] nums) {
        cache = new HashMap<>();
        head = new DLinkedNode(0);
        tail = new DLinkedNode(0);
        
        head.post = tail;
        tail.pre = head;
        
        for (int num : nums) {
            this.add(num);
        }
    }
    
    public int showFirstUnique() {
        // return -1 if empty list; or the first unique value.
        return head.post == tail ? -1 : head.post.val; 
    }
    
    public void add(int value) {
        if (!cache.containsKey(value)) {
            // VALUE doesn't exist
            DLinkedNode node = new DLinkedNode(value);
            cache.put(value, node);
            addToEnd(node);
        } else {
            DLinkedNode node = cache.get(value);
            removeNode(node);
        }
    }
    
    private void addToEnd(DLinkedNode node) {
        node.post = tail;
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.post = node; 
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        if (pre != null && post != null) {
            pre.post = post;
            post.pre = pre;
            node.post = null;
            node.pre = null;
        }
    }
}
