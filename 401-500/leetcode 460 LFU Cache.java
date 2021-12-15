// leetcode 460 LFU Cache

/*
time: O(1)
space: O(n)
*/
676
class LFUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToCount;
    HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;
    int cap;
    int min;
    
    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToCount = new HashMap<>();
        countToLRUKeys = new HashMap<>();
        cap = capacity;
        min = 0;
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key))
            return -1;
        
        update(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0)
            return;
        
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            update(key);
            return;
        } 
        
        if (keyToVal.size() >= cap) 
            evict();
        
        keyToVal.put(key, value);
        keyToCount.put(key, 1);
        addToList(1, key);
        min = 1;
    }
    
    private void update(int key) {
        int cnt = keyToCount.get(key);
        keyToCount.put(key, cnt + 1);
        countToLRUKeys.get(cnt).remove(key);
        
        if (cnt == min && countToLRUKeys.get(cnt).size() == 0)
            min++;
        
        addToList(cnt + 1, key);
    }
    
    private void addToList(int cnt, int key) {
        if (!countToLRUKeys.containsKey(cnt))
            countToLRUKeys.put(cnt, new LinkedHashSet<>());
        
        countToLRUKeys.get(cnt).add(key);
    }
    
    private void evict() {
        int key = countToLRUKeys.get(min).iterator().next(); 
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
        keyToCount.remove(key);
    }
}