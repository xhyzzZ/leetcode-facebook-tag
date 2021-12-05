// leetcode 981 Time Based Key-Value Store

/*
time: O(logN) get, O(logK) set
space: O()
*/

treemap
public class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }
        Integer floor = treeMap.floorKey(timestamp);
        if (floor == null) {
            return "";
        }
        return treeMap.get(floor);
    }
}

/*
time: O(logN) get, O(1) set
space: O()
*/

binary search
class Data {
    String val;
    int time;
    Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}
class TimeMap {

    /** Initialize your data structure here. */
    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<Data>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }

    private String binarySearch(List<Data> list, int time) {
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int mid = (low + high + 1) >> 1;
            if (list.get(mid).time <= time) {
                low = mid;
            } else {
                high = mid -1;
            }
        }
        return list.get(low).time <= time ? list.get(low).val : "";  // low == high
    }
}