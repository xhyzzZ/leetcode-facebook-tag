//leetcode 210 Course Schedule II

/*
time: O(ve)
space: O()
*/

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      	if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        // Indegree - how many prerequisites are needed.
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;  
        } 

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }
        }
            
        // How many courses don't need prerequisites. 
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); 
            // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--; 
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                } 
            }
        }
        return (index == numCourses) ? order : new int[0];
    }
}



public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }

        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!topologicalSort(graph, i, stack, visited)) return new int[0];
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }
    
    private boolean topologicalSort(List<List<Integer>> graph, int v, Stack<Integer> stack, int[] visited) {
        if (visited[v] == 2) return true;
        if (visited[v] == 1) return false;
        visited[v] = 1;
        for (Integer u : graph.get(v)) {
            if (!topologicalSort(graph, u, stack, visited)) return false;
        }
        visited[v] = 2;
        stack.push(v);
        return true;
    }
}