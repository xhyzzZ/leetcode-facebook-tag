//leetcode 146 LRU Cache


/*
time: O(1)
space: O(1)
hashmap + double linkedlist
*/

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        /*
        Imagine we have a double linked list: " 1<-->3<-->4 ", and we need to 
        insert a new node "2" in it so that it becomes "1<--> 2<-->3 <--> 4". 
        After the first two line, we have "1 <-- 2 --> 3 <--> 4", 
        where 1 is still pointing at 3 and 3 is still pointing at 1. 
        Therefore, "head.post.pre = node" actually means "let 3 points to 2", 
        and "head.post=node" means "let 1 points to 2".
        */
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail. 
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }
        // move the accessed node to the head;
        this.moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }

    }
}