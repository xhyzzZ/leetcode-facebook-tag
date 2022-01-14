// leetcode 358 Rearrange String k Distance Apart

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) return s;
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) freq[c - 'a']++;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) pq.add(new int[] {i, freq[i]});
        }

        Queue<int[]> queue = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            sb.append((char) (cur[0] + 'a'));
            cur[1]--;
            queue.add(cur);
            if (queue.size() >= k) { 
                int[] front = queue.poll();
                if (front[1] > 0) pq.add(front);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}