//leetcode 987 Vertical Order Traversal of a Binary Tree

/*
time: O()
space: O()
*/

class Solution {
    class Pair {
        TreeNode node;
        int x;  //horizontal
        int y;  //depth
        Pair(TreeNode n, int x, int y) {
            node = n;
            this.x = x;
            this.y = y;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //x -> list (some nodes might have same y in the list)
        Map<Integer, List<Pair>> map = new HashMap<>(); 
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            Pair p = queue.poll(); 
            
            min = Math.min(min, p.x);
            max = Math.max(max, p.x);
            
            if (!map.containsKey(p.x)) map.put(p.x, new ArrayList<>());
            map.get(p.x).add(p);
            
            if (p.node.left != null) queue.add(new Pair(p.node.left, p.x - 1, p.y + 1));
            if (p.node.right != null) queue.add(new Pair(p.node.right, p.x + 1, p.y + 1));
        }        

        for (int i = min; i <= max; i++) {
            Collections.sort(map.get(i), new Comparator<Pair>() {
                public int compare(Pair a, Pair b) {
                    if (a.y == b.y) //when y is equal, sort it by value
                        return a.node.val - b.node.val;
                    return 0; //otherwise don't change the order as BFS ganrantees that top nodes are visited first
                }
            });
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < map.get(i).size(); j++) {
                list.add(map.get(i).get(j).node.val);
            }
            res.add(list);
        }
        return res;   
    }
}