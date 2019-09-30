//leetcode 380 Insert Delete GetRandom O(1)

/*
time: O()
space: O(1)
*/

public class RandomizedSet {
	HashMap<Integer, Integer> valToInd;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valToInd = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToInd.containsKey(val)) return false;
        list.add(val);
        valToInd.put(val, list.size() - 1);
        return true;
 
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int ind = valToInd.getOrDefault(val, -1);
        if (ind == -1) return false;
        // 将将要移除的元素和list末尾元素进行置换
        Collections.swap(list, ind, list.size() - 1);
        int lastVal = list.get(ind);
        valToInd.put(lastVal, ind);
        list.remove(list.size() - 1);
        valToInd.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int ind = random.nextInt(list.size());
        return list.get(ind);
    }
}