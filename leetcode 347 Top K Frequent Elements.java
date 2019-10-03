//leetcode 347 Top K Frequent Elements

/*
time: O(n)
space: O(k)
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
        	frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
/
        for (int key : frequencyMap.keySet()) {
        	int frequency = frequencyMap.get(key);
        	if(bucket[frequency] == null) {
        		bucket[frequency] = new ArrayList<>();
        	}
        	bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
        	if (bucket[pos] != null) {
        		res.addAll(bucket[pos]);
        	}
        }
        return res;
    }
}

/*
time: O(nlogn)
space: O(n)
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
           
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b)-> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}

/*
time: O(n) + O(nlogk) + O(klogk)
space: O(n)
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) { 
            minHeap.add(entry);
            if (minHeap.size() > k) minHeap.poll(); 
        }

        List<Integer> res = new LinkedList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            res.addFirst(entry.getKey());
        }
        return res;
    }
}