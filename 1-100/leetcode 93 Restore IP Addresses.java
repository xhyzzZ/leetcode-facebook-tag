//leetcode 93 Restore IP Addresses

/*
time: O(n)
spcae: O(1)
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        doRestore(res, "", s, 0);
        return res;
    }
    
    private void doRestore(List<String> res, String path, String s, int k) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4)
                res.add(path.substring(1));
            return;
        }
        // Avoid leading 0
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) { 
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255) {
                doRestore(res, path + "." + part, s.substring(i), k + 1);
            }
        }
    }
}