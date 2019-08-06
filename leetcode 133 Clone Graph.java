//leetcode 133 Clone Graph

/*
time: O()
space: O()
*/

public class Solution {
    public HashMap<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        return clone(node);
    }
    
    public Node clone(Node node) {
        if (node == null) return null;
        
        if (map.containsKey(node.val)) return map.get(node.val);
        
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors) {
        	newNode.neighbors.add(clone(neighbor));
        } 
        return newNode;
    }
}