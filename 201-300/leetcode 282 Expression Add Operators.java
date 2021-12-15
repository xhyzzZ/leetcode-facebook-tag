// leetcode 282 Expression Add Operators

/*
time: O(n * 4^n)
space: O(n)

This problem has a lot of edge cases to be considered:

overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
a little trick is that we should save the value that is to be multiplied in the next recursion.
*/

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
	   	StringBuilder sb = new StringBuilder();
	    dfs(res, sb, num, 0, target, 0, 0);
	    return res;
	    
	}
	public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) { 
		if (pos == num.length()) {
			if (target == prev) res.add(sb.toString());
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			// corner case: if current position is 0, we can only use it as a single digit number, should be 0
        	// if it is not a single digit number with leading 0, it should be considered as an invalid number 
			if (num.charAt(pos) == '0' && i != pos) break;
			long curr = Long.parseLong(num.substring(pos, i + 1));
			int len = sb.length();
			// position 0 should be considered individually, since it does not have any operand character before curNum
			if (pos == 0) {
				dfs(res, sb.append(curr), num, i + 1, target, curr, curr); 
				sb.setLength(len);
			} else {
				dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr); 
				sb.setLength(len);
				dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr); 
				sb.setLength(len);
				// trick part: to calculate multiplication, we should subtract previous number, and then add current
            	// multiplication result to the subtraction result 
				dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr); 
				sb.setLength(len);
			}
		}
    }
}