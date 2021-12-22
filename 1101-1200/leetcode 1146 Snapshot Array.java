// leetcode 1146 Snapshot Array

/*
time: Instantiation cost O(length), each call of get()/set() cost O(log(count)), snap() O(1);
space: Total cost O(length + count).
*/

class SnapshotArray {
    private int count;
    private List<TreeMap<Integer, Integer>> shot = new ArrayList<>();
    
    public SnapshotArray(int length) {
        for (int i = 0; i < length; i++) {
            shot.add(new TreeMap<>());
        }
    }
    
    public void set(int index, int val) {
        shot.get(index).put(count, val);
    }
    
    public int snap() {
        return count++;
    }
    
    public int get(int index, int snap_id) {
        Integer key = shot.get(index).floorKey(snap_id);
        return key == null ? 0 : shot.get(index).get(key);
    }
}
