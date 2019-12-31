// leetcode 358 Rearrange String k Distance Apart

/*
time: O(n)
space: O()
*/

class Solution {
    public String rearrangeString(String s, int k) {
        StringBuilder rearranged = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });
        
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());
        
        while (!maxHeap.isEmpty()) {
            
            Map.Entry<Character, Integer> current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);
            
            if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
                continue;
            }
            // release from waitQueue if char is already k apart
            Map.Entry<Character, Integer> front = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }
        return rearranged.length() == s.length() ? rearranged.toString() : "";
    }
}