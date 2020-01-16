//leetcode 692 Top K Frequent Words

/*
time: O(n + klgk)
space: O(n)
bucket sort

*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            max = Math.max(max, map.get(word));
        }
        List<String>[] bucket = new ArrayList[max + 1];
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            int fre = entry.getValue();
            if (bucket[fre] == null) {
                bucket[fre] = new ArrayList<>();
            }
            bucket[fre].add(entry.getKey());
        }
        List<String> res = new ArrayList<>();
        for (int i = max; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                Collections.sort(bucket[i]);
                res.addAll(bucket[i]);
            }
        }
        return res.subList(0, k);
    }
}

/*
time: O(nlogk)
space: O(n)
min heap + pq
*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        if (words.length == 0) return result;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 注意：如果使用max heap，则时间复杂度将为nlogn
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> 
            a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }
        
        return result;
    }
}