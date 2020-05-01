//leetcode 13 Roman to Integer

//time: O(n)
//space; O(1)

//规律： 左边的数字如果小于右边的数字 = 右 - 左

public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int sum = 0;
        int prev = map.get(s.charAt(0));
        int next = 0;

        for (int i = 1; i < s.length(); i++) {
            next = map.get(s.charAt(i));

            if (prev < next) {
                sum -= prev;
            } else {
                sum += prev;
            }

            //udpare prev because it is like sliding window
            prev = next;
        }

        sum += prev;//corner case when only one digit, we need to let sum = prev, so we add prev, not next
        return sum;
    }
}