//leetcode 692 Top K Frequent Words

/*
time: O(n + klgk)
space: O(n)
bucket sort
*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        if (words.length == 0) return result;
        
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        List<String>[] count = new List[words.length + 1];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (count[entry.getValue()] == null) {
                count[entry.getValue()] = new ArrayList<>();
            }
            count[entry.getValue()].add(entry.getKey());
        }
        
        for (int i = count.length - 1; i >= 0 && k > 0; i--) {
            if(count[i] == null) continue;
            Collections.sort(count[i]);
            List<String> temp = count[i].subList(0, Math.min(count[i].size(), k));
            result.addAll(temp);
            k = k - temp.size();
        }
        return result;
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