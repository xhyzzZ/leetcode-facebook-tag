//leetcode 449 Serialize and Deserialize BST

/*
time: O(n^2)
space: O()
*/

public class Codec {
	private static final String SPLITER = ",";
    private static final String NULL = "N";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder st = new StringBuilder();
        serialize(root, st);
        return st.toString();
    }  
    public void serialize(TreeNode root, StringBuilder st) {
        if (root == null) st.append(NULL + SPLITER);
        else {
            st.append(root.val + SPLITER);
            serialize(root.left, st);
            serialize(root.right, st);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SPLITER)));
        return deseralize(queue);
    }
    public TreeNode deseralize(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deseralize(queue);
        root.right = deseralize(queue);
        return root;
    }
}


public class Codec {

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
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode deserialize(Queue<String> q, int lower, int upper) {
        if (q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.parseInt(s);
        if (val < lower || val > upper) return null;
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(q, lower, val);
        root.right = deserialize(q, val, upper);
        return root;
    }
}
