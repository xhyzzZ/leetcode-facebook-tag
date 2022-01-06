// leetcode 1554 Strings Differ by One Character

/*
time: O(nm^2)
space: O(n)
*/

class Solution {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        int len = dict[0].length();
        for (int i = 0; i < len; i++) {
            set.clear();
            for (String str : dict) {
                String t = str.substring(0, i) + str.substring(i + 1, len);
                if (set.contains(t)) return true;
                set.add(t);
            }
        }
        return false;
    }
}