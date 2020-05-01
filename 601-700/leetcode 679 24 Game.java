//leetcode 679 24 Game

/*
time: O()
space: O()
*/

class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int i : nums) {
            list.add((double) i);
        }
        return dfs(list);
    }

    // 每次dfs都是选取两张牌
    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            // 如果此时list只剩下了一张牌
            if(Math.abs(list.get(0) - 24.0) < 0.001) {
                return true;
            }
            return false;
        }
        
        // 选取两张牌
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                // 对于每下一个可能的产生的组合
                for (double c : compute(list.get(i), list.get(j))) {
                    List<Double> nextRound = new ArrayList<>();
                    // 将他们加入到下一个list循环中去
                    nextRound.add(c);
                    for(int k = 0; k < list.size(); k++) {
                        if(k == j || k == i) continue;
                        nextRound.add(list.get(k));
                    }
                    if(dfs(nextRound)) return true;
                }
            }
        }
        return false;
    }
    // 计算下一个可能产生的组合
    private List<Double> compute(double a, double b) {
        List<Double> res = Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
        return res;
    }
}