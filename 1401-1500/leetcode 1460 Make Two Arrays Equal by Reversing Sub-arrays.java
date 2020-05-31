// leetcode 1460 Make Two Arrays Equal by Reversing Sub-arrays

/*
time: O(n)
space: O(n)
*/

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : target) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int b : arr) {
            if (!map.containsKey(b)) {
                return false;
            } 
            if (map.get(b) == 1) map.remove(b); 
            else map.put(b, map.get(b) - 1); 
        }
        return map.size() == 0; 
    }
}