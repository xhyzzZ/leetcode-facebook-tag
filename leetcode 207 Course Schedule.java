//leetcode 207 Course Schedule

/*
time: O(ve)
space: O(n)
*/
dfs
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());
        
        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];            
            graph.get(course).add(prerequisite);
        }
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (dfs(i, graph, visited)) return false;
        }
        
        return true;
    }
    // states: 0 == unknown, 1 == visiting, 2 == visited
    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) return true;
        if (visited[curr] == 2) return false;
        
        visited[curr] = 1;
                
        for (int next : graph.get(curr)) {
            if (dfs(next, graph, visited)) return true;
        }
        
        visited[curr] = 2;
        return false;
    }
}

bfs
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;
        // Convert graph presentation from edges to indegree of adjacent list.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        // Indegree - how many prerequisites are needed.
        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
            indegree[next]++;
        }
               
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // How many courses don't need prerequisites.
        int canFinishCount = 0;  
        while (!queue.isEmpty()) {
            int curr = queue.poll(); // Already finished this prerequisite course.
            canFinishCount++;
            for (int adj : graph.get(curr)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    queue.offer(adj);

                }
            }
        }
        return canFinishCount == numCourses; 
    }
}