//leetcode 773 Sliding Puzzle

/*
time: O()
space: O()
*/



class Solution {
    private static final int[] d = { 1, -1, 3, -3 }; // potential swap displacements.
    public int slidingPuzzle(int[][] board) {
        // convert board to string - initial state.
        String s = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", "");
        Queue<String> q = new LinkedList<>(Arrays.asList(s)); // add initial state to queue.
        Set<String> seen = new HashSet<>(q); // used to avoid duplicates
        int ans = 0; // record the # of rounds of Breadth Search
        while (!q.isEmpty()) { // Not traverse all states yet?
            // loop used to control search breadth.
            for (int sz = q.size(); sz > 0; --sz) { 
                String str = q.poll();
                if (str.equals("123450")) { return ans; } // found target.
                int i = str.indexOf('0'); // locate '0'
                for (int k = 0; k < 4; ++k) { // traverse all options.
                    int j = i + d[k]; // potential swap index.
                    // conditional used to avoid invalid swaps.
                    if (j < 0 || j > 5 || i == 2 && j == 3 || i == 3 && j == 2) { continue; } 
                    char[] ch = str.toCharArray();
                    // swap ch[i] and ch[j]:  ch[i] = ch[j], ch[j] = '0'. Updated per @caowang888's suggestion. 
                    ch[i] = ch[j];
                    ch[j] = '0';
                    s = String.valueOf(ch); // a new candidate state.
                    if (seen.add(s)) { q.offer(s); } //Avoid duplicate.
                }
            }
            ++ans; // finished a round of Breadth Search, plus 1.
        }
        return -1;
    }
}