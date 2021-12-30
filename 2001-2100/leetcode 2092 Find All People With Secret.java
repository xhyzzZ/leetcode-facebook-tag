// leetcode 2092 Find All People With Secret

/*
time: O(MlogM + (M + N) * alpha(N))
space: O(N + M)
*/

union find
class UnionFind {
    private int count = 0;
    private int[] parent, rank;
    
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    // find(...) amortizes to O(α(N))
    public int find(int p) {
        if (parent[p] == p) return p;
        return find(parent[p]);
    }
    
    // path compression and union by rank to optimize
    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return false;
        if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ;
        } else if (rank[rootQ] < rank[rootP]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
        return true;
    }

    // reset parent 
    public void reset(int i) {
        parent[i] = i;
    }
    
    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind uf = new UnionFind(n);
        Set<Integer> set = new HashSet<>();
        uf.union(0, firstPerson);
        int size = meetings.length, i = 0;
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        while (i < size) {
        	set.clear();
        	int time = meetings[i][2];
        	while (i < size && meetings[i][2] == time) {
                uf.union(meetings[i][0], meetings[i][1]);
                set.add(meetings[i][0]);
                set.add(meetings[i][1]);
                i++;
            }
        	// For each person in the set, check if he/she's connected with person 0.
        	for (int x : set) {
        		// If not, this person doesn't have secret, reset it.
        		if (!uf.connected(0, x)) uf.reset(x);
        	}
        }

        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
        	if (uf.connected(0, j)) res.add(j);
        }
        return res;
    }
}
