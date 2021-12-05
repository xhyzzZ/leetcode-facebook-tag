// leetcode 38 Count and Say

/*
time: O()
space: O()
*/

public class Solution {
    public String countAndSay(int n) {
        int i = 1;
        String res = "1";
        while (i < n) {
        	int count = 0;
        	StringBuilder sb = new StringBuilder();
        	char c = res.charAt(0);
        	for (int j = 0; j <= res.length(); j++) {
        		if (j != res.length() && res.charAt(j) == c) {
        			count++;
        		} else {
        			sb.append(count);
        			sb.append(c);
        			if (j != res.length()) {
        				count = 1;
        				c = res.charAt(j);
        			}
        		}
        	}
        	res = sb.toString();
        	i++;
        }
        return res;
    }
}