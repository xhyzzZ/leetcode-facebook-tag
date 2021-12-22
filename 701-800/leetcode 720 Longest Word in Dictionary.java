// leetcode 720 Longest Word in Dictionary

/*
time: O(sum of the length of words)
space: O(sum of the length of words)
*/

class TrieNode {
    TrieNode[] children;
    String word;
    
    // Initialize your data structure here.
    public TrieNode() {
        this.children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode runner = root;
        for (char c : word.toCharArray()) {
            if (runner.children[c - 'a'] == null) {
                runner.children[c - 'a'] = new TrieNode();
            }
            runner = runner.children[c - 'a'];
        }
        runner.word = word;
    }

    public String bfs() {
        String res = "";
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TrieNode node = queue.poll();
                for (int j = 25; j >= 0; j--) {
                    if (node.children[j] != null && node.children[j].word != null) {
                        res = node.children[j].word;
                        queue.offer(node.children[j]);
                    }
                }
            }
        }
        return res;
    }
}

class Solution {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        return trie.bfs();
    }
}