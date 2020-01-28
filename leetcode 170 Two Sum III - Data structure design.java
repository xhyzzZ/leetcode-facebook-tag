//leetcode 170 Two Sum III - Data structure design
// O(1) add
// O(n) find
class TwoSum {
	Map<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key : map.keySet()) {
            int remain = value - key;
            if (remain == key && map.get(key) >= 2) return true;
            if (remain != key && map.containsKey(remain)) return true;
        }
        return false;
    }
}