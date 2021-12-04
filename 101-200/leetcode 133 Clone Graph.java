// leetcode 133 Clone Graph

/*
time: O(n + m) N is a number of nodes (vertices) and MM is a number of edges.
space: O(n)
*/

public class Solution {
    private HashMap<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        if (map.containsKey(node.val)) return map.get(node.val);
        
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        } 
        return newNode;
    }
}