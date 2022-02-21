// leetcode 449 Serialize and Deserialize BST

/*
time: O(n)
space: O(n)
*/

public class Codec {
    // That way you do not have to store null values, return null, 
    // when the range bound is out of lower or upper. It makes the string compact.
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode deserialize(Queue<String> queue, int lower, int upper) {
        if (queue.isEmpty()) return null;
        String s = queue.peek();
        int val = Integer.parseInt(s);
        if (val < lower || val > upper) return null;
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(queue, lower, val);
        root.right = deserialize(queue, val, upper);
        return root;
    }
}