//leetcode 767 Reorganize String

/*
time: O()
space: O()
*/

class Solution {
    public String reorganizeString(String S) {
	    if (S == null || S.length() == 0) return "";

	    /* store char-frequency pair into map */
	    Map<Character, Integer> map = new HashMap<>();
	    for (char c : S.toCharArray()) {
	        map.put(c, map.getOrDefault(c, 0) + 1);
	    }

	    // push all map entry into priority element, by sorting from high frequency to low frequency
	    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
	            (a, b) -> (b.getValue() - a.getValue())
	    );
	    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
	        pq.offer(entry);
	    }


	    StringBuilder sb = new StringBuilder();
	    while (!pq.isEmpty()) {
	        // store character with highest frequency in cache
	        Map.Entry<Character, Integer> cache = pq.poll();

	        // if character in cache is different with tail character in current string
	        if (sb.length() == 0 || cache.getKey() != sb.charAt(sb.length() - 1)) {
	            sb.append(cache.getKey());
	            cache.setValue(cache.getValue() - 1);

	            // if current character still have more quota left, push back to queue
	            if (cache.getValue() != 0) {
	                pq.offer(cache);
	            }
	        }

	        // if character in cache is same as tail character in current string
	        // we need to try the character with second highest frequency
	        else {
	            Map.Entry<Character, Integer> cache2 = pq.poll();
	            // corner case: if no more elements in queue, the input string should be invalid
	            // because we do not have any other characters that different with current string tail
	            if (cache2 == null) {
	                return "";
	            }
	            sb.append(cache2.getKey());
	            cache2.setValue(cache2.getValue() - 1);
	            
	            // if current character still have more quota left, push back to queue
	            if (cache2.getValue() != 0) {
	                pq.offer(cache2);
	            }
	            // DO NOT FORGET to push top frequency entry into queue as well
	            pq.offer(cache);
	        }
	    }
	    return sb.toString();
	}
}