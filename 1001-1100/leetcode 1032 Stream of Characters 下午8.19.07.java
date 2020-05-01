// leetcode 1032 Stream of Characters

/*
time: O()
space: O()
*/

class StreamChecker {
    class TrieNode {
	    TrieNode[] children = new TrieNode[26];
	    boolean isWord;
	}
    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();;
    public StreamChecker(String[] words) {
        buildTrie(words); 
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            char c = sb.charAt(i);
            node = node.children[c - 'a'];
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }
    
    public void buildTrie(String[] words) {
	    for (String w : words) {
	        TrieNode node = root;
            int len = w.length();
	        for (int i = len - 1; i >= 0; i--) {
                char c = w.charAt(i);
	            if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
	       }
	       node.isWord = true;
	    }
	}
}