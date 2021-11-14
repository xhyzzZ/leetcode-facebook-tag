// leetcode 1233 Remove Sub-Folders from the Filesystem

/*
time: O(n * m)
space: O(n * m)
*/

class TrieNode {
    TrieNode[] children;
    int index;
    
    public TrieNode() {
        this.children = new TrieNode[27];
        index = -1;
    }
}


class Solution {
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < folder.length; ++i) {
            TrieNode runner = root;
            for (char c : folder[i].toCharArray()) {
                int idx = c == '/' ? 26 : c - 'a'; // correspond '/' to index 26.
                if (runner.children[idx] == null)
                    runner.children[idx] = new TrieNode();
                runner = runner.children[idx];
            }
            runner.index = i;
        }
        return bfs(root, folder);
    }

     private List<String> bfs(TrieNode t, String[] folder) {
        List<String> ans = new ArrayList<>();
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(t);
        while (!q.isEmpty()) { // BFS search.
            t = q.poll();
            if (t.index >= 0) { // found a parent folder, but there might be more.
                ans.add(folder[t.index]);
            }
            for (int i = 0; i < 27; ++i)
                if (t.children[i] != null && !(i == 26 && t.index >= 0)) // not yet found all parent folders in current trie branch.
                    q.offer(t.children[i]);
        }
        return ans;
    }
}