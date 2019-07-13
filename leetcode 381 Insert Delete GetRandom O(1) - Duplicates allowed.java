//leetcode 381 Insert Delete GetRandom O(1) - Duplicates allowed

/*
time: O(1)
space: O()
*/

public class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> index;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */

    public RandomizedCollection() {
        list = new ArrayList<Integer>();
	    index = new HashMap<Integer, Set<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!index.containsKey(val)) index.put(val, new LinkedHashSet<Integer>());
        index.get(val).add(list.size());
        list.add(val);
        return index.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val) || index.get(val).size() == 0) return false;
	    int remove_idx = index.get(val).iterator().next();
        index.get(val).remove(remove_idx);
        int last = list.get(list.size() - 1);
        list.set(remove_idx, last);
        index.get(last).add(remove_idx);
        index.get(last).remove(list.size() - 1);

	    list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}