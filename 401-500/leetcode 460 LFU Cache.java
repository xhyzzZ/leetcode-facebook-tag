// leetcode 460 LFU Cache

/*
time: O(1)
space: O(n)
*/

public class LFUCache {
    class DLLNode {
        int key;
        int val;
        int freq;
        DLLNode prev;
        DLLNode next;
        DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }
    
    class DoubleLinkedList {
        int size;
        DLLNode head;
        DLLNode tail;
        public DoubleLinkedList() {
            head = new DLLNode(0, 0);
            head.prev = null;
            
            tail = new DLLNode(0, 0);
            tail.next = null;
            
            head.next = tail;
            tail.prev = head;
        }
        
        public void addNode(DLLNode node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }
        
        public void removeNode(DLLNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        public DLLNode removeTail() {
            if (size > 0) {
                DLLNode node = tail.prev;
                removeNode(node);
                return node;
            }
            else return null;
        }
    }
    
    // total capacity of LFU Cache
    int capacity;
    // current size of LFU cache
    int size;
    // frequency of the last linked list (the minimum frequency of entire LFU cache)
    int min;
    // a hash map that has key to Node mapping, which used for storing all nodes by their keys
    Map<Integer, DLLNode> cache;
    // a hash map that has key to linked list mapping, which used for storing all 
    // double linked list by their frequencies
    Map<Integer, DoubleLinkedList> frequencyMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }
    
    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key) {
        DLLNode node = cache.get(key);
        if (node == null) return -1;
        updateNode(node);
        return node.val;
    }
    
    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            node = cache.get(key);
            node.val = value;
            updateNode(node);
        }
        else {
            DLLNode node = new DLLNode(key, value);
            cache.put(key, node);
            if (size == capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequencyMap.get(min);
                DLLNode deleteNode = minFreqList.removeTail();
                cache.remove(deleteNode.key);
                size--;
            }
            
            size++;
            // reset min frequency to 1 because of adding new node
            min = 1;
            
            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList newList = frequencyMap.getOrDefault(node.freq, new DoubleLinkedList());
            newList.addNode(node);
            frequencyMap.put(node.freq, newList);
        }
    }
    
    private void updateNode(DLLNode node) {
        int curFreq = node.freq;
        DoubleLinkedList oldList = frequencyMap.get(curFreq);
        oldList.removeNode(node);
        
        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if (curFreq == min && oldList.size == 0) min++; 
        node.freq++;
        
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(node.freq, new DoubleLinkedList());
        newList.addNode(node);
        frequencyMap.put(node.freq, newList);
    }
}