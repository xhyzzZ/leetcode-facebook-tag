//leetcode 703 Kth Largest Element in a Stream

/*
time: O()
add() is O(log k)
the constructor KthLargest() is O(n log k)
space: O(k)
*/

class KthLargest {
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final int k;    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (Integer i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }        
        return minHeap.peek();
    }
}

/*
Time Complexities
h = height of tree with the average and best time O(log n) and worst time O(n)

Constructor O(nh)
Add O(h)
findKthLargest O(h)
*/

class KthLargest {

    class TreeNode {
        int val, count = 1;
        TreeNode left, right;
        TreeNode(int v) { 
            val = v; 
        }
    }

    TreeNode root;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) root = add(root, num);
    }

    public int add(int val) {
        root = add(root, val);
        return findKthLargest();
    }

    private TreeNode add(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        root.count++;
        if (val < root.val) root.left = add(root.left, val);
        else root.right = add(root.right, val);

        return root;
    }

    public int findKthLargest() {
        int count = k;
        TreeNode walker = root;

        while (count > 0) {
            int pos = 1 + (walker.right != null ? walker.right.count : 0);
            if (count == pos) break;
            if (count > pos) {
                count -= pos;
                walker = walker.left;
            } else if (count < pos)
                walker = walker.right;
        }
        return walker.val;
    }
}