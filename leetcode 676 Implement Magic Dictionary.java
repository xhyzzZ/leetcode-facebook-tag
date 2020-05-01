//leetcode 676 Implement Magic Dictionary

/*
time: O()
space: O()
*/

class MagicDictionary {

    Map<Integer, Set<String>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            int len = s.length();
            if (!map.containsKey(len)) {
                map.put(len, new HashSet<>());
            }
            map.get(len).add(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int len = word.length();
        if (!map.containsKey(len)) {
            return false;
        }
        for (String s : map.get(len)) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != s.charAt(i)) {
                    count++;
                }
            }
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}