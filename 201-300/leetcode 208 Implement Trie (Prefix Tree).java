//leetcode 208 Implement Trie (Prefix Tree)

/*
time: O(l)
l单词长度
space: O(n * l^2)
*/

class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;
    
    // Initialize your data structure here.
    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

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
        runner.isEndOfWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode runner = root;
        for (char c : word.toCharArray()) {
            if (runner.children[c - 'a'] == null) {
                return false;
            } else {
                runner = runner.children[c - 'a'];
            }
        }
        return runner.isEndOfWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode runner = root;
        for (char c : prefix.toCharArray()) {
            if (runner.children[c - 'a'] == null) {
                return false;
            } else {
                runner = runner.children[c - 'a'];
            }
        }
        return true;
    }
}