// leetcode 208 Implement Trie (Prefix Tree)

/*
time:
space:
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
    // Time complexity : O(m), where m is the key length.
    // Space complexity : O(m).
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
    // Time complexity : O(m) In each step of the algorithm we search for the next key character. 
    // In the worst case the algorithm performs mm operations.
    // Space complexity : O(1)
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
    // Time complexity : O(m)
    // Space complexity : O(1)
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