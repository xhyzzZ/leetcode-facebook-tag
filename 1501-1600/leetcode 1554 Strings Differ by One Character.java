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

/*
time: O(nm^2)
space: O(n)
*/

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean end;
        public TrieNode() {
            children = new HashMap<>();
        }
    }
    
    public boolean differByOne(String[] dict) {
        TrieNode root = buildTrie(dict);
        for (String w : dict) {
            if (search(root, w, 0, 0)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean search(TrieNode root, String w, int diff, int index) {
        if (diff > 1) return false;
    
        if (index >= w.length()) {
            return root.end && diff == 1;
        }
        
        char c = w.charAt(index);
        for (char key : root.children.keySet()) {
            if (key == c) {
                if (search(root.children.get(key), w, diff, index + 1)) return true;
            } else {
                if (search(root.children.get(key), w, diff + 1, index + 1)) return true;
            }
        }
        return false;
    }
    
    public TrieNode buildTrie(String[] dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (Character c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                } 
                node = node.children.get(c);
            }
            node.end = true;
        }
        return root;
    }
}