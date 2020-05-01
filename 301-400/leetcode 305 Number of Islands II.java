//leetcode 305 Number of Islands II

/*
time: O()
space: O()
*/

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
	    List<Integer> result = new ArrayList<>();
	    if(m <= 0 || n <= 0) return result;

	    int count = 0;                      // number of islands
	    int[] roots = new int[m * n];       // one island = one tree
	    Arrays.fill(roots, -1);            

	    for(int[] p : positions) {
	        int root = n * p[0] + p[1];     // assume new point is isolated island
	        roots[root] = root;             // add new island
	        count++;

	        for(int[] dir : dirs) {
	            int x = p[0] + dir[0]; 
	            int y = p[1] + dir[1];
	            int nb = n * x + y;
	            if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;
	            
	            int rootNb = findIsland(roots, nb);
	            if(root != rootNb) {        // if neighbor is in another island
	                roots[root] = rootNb;   // union two islands 
	                root = rootNb;          // current tree root = joined tree root
	                count--;               
	            }
	        }

	        result.add(count);
	    }
	    return result;
	}

	public int findIsland(int[] roots, int id) {
	    while(id != roots[id]) id = roots[id];
	    return id;
	}
}