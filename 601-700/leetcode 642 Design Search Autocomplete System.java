//leetcode 642 Design Search Autocomplete System

/*
time: O()
space: O()
*/

class AutocompleteSystem {
    class TrieNode {
	    Map<Character, TrieNode> children;
	    Map<String, Integer> counts;
	    boolean isWord;
	    public TrieNode() {
	        children = new HashMap<Character, TrieNode>();
	        counts = new HashMap<String, Integer>();
	        isWord = false;
	    }
	}
	TrieNode root;
	String prefix;


	public AutocompleteSystem(String[] sentences, int[] times) {
	    root = new TrieNode();
	    prefix = "";
	    
	    for (int i = 0; i < sentences.length; i++) {
	        add(sentences[i], times[i]);
	    }
	}

	private void add(String s, int count) {
	    TrieNode curr = root;
	    for (char c : s.toCharArray()) {
	        TrieNode next = curr.children.get(c);
	        if (next == null) {
	            next = new TrieNode();
	            curr.children.put(c, next);
	        }
	        curr = next;
	        curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
	    }
	    curr.isWord = true;
	}

	public List<String> input(char c) {
	    if (c == '#') {
	        add(prefix, 1);
	        prefix = "";
	        return new ArrayList<String>();
	    }
	    
	    prefix = prefix + c;
	    TrieNode curr = root;
	    for (char cc : prefix.toCharArray()) {
	        TrieNode next = curr.children.get(cc);
	        if (next == null) {
	            return new ArrayList<String>();
	        }
	        curr = next;
	    }
	    
	    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));
	    pq.addAll(curr.counts.entrySet());
	    
	    List<String> res = new ArrayList<String>();
	    
	    int k = 3;
	    while (!pq.isEmpty() && k > 0) {
	        res.add((String) pq.poll().getKey());
	        k--;
	    }
	    return res;
	}
}