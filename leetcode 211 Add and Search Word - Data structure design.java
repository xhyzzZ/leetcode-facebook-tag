//leetcode 211 Add and Search Word - Data structure design


/*
time: O(n)
space: O()
*/
public class WordDictionary {
	class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode root = new TrieNode();
    public void addWord(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.child[c - 'a'] == null) p.child[c - 'a'] = new TrieNode();
            p = p.child[c - 'a'];
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }
    
    private boolean helper(String s, int index, TrieNode p) {
        if (index >= s.length()) return p.isWord;
        char c = s.charAt(index);
        if (c == '.') {
            for (int i = 0; i < p.child.length; i++)
                if (p.child[i] != null && helper(s, index + 1, p.child[i]))
                    return true;
            return false;
        } else return (p.child[c - 'a'] != null && helper(s, index + 1, p.child[c - 'a']));
    }
}