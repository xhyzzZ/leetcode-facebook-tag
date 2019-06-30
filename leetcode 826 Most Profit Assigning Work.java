//leetcode 826 Most Profit Assigning Work

/*
time: O()
space: O()
*/

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        // in case two jobs have same difficulty but different profit, we want to count
        // the higher profit
        for(int i = 0; i < difficulty.length; i++) {
            tmap.put(difficulty[i], Math.max(profit[i], tmap.getOrDefault(difficulty[i], 0)));
        }

        int max = 0, res = 0;
        // maximum profit at this difficulty or below in case
        // lower difficulty job offers higher profit
        for(Integer key : tmap.keySet()) {
            max = Math.max(tmap.get(key), max);
            tmap.put(key, max);
        }
        
        Map.Entry<Integer, Integer> entry = null;
        for(int i = 0; i < worker.length; i++) {
            if (tmap.containsKey(worker[i])) {
                res += tmap.get(worker[i]);
            } else {
                entry = tmap.floorEntry(worker[i]);            
                if (entry != null) {
                    res += entry.getValue();
                }
            }  
        }
        return res;
    }
}