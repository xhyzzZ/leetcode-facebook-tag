// leetcode 241 Different Ways to Add Parentheses

/*
time: O() https://leetcode.com/problems/different-ways-to-add-parentheses/discuss/66328/A-recursive-Java-solution-(284-ms)/192501
space: O()
*/

public class Solution { 
    private Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String p1 = input.substring(0, i);
                String p2 = input.substring(i + 1);
                List<Integer> l1 = memo.getOrDefault(p1, diffWaysToCompute(p1));
                List<Integer> l2 = memo.getOrDefault(p2, diffWaysToCompute(p2));
                for (Integer i1 : l1) {
                    for (Integer i2 : l2) {
                        int r = 0;
                        switch (c) {
                            case '+':
                                r = i1 + i2;
                                break;
                            case '-':
                                r = i1 - i2;
                                break;
                            case '*':
                                r = i1 * i2;
                                break;
                        }
                        res.add(r);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        memo.put(input, res);
        return res;
    }
}