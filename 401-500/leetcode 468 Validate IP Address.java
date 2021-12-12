// leetcode 468 Validate IP Address

/*
time: O(n)
space: O(1)
*/

class Solution {
	public String validIPAddress(String queryIP) {
	    if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
	      	return validateIPv4(queryIP);
	    } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
	      	return validateIPv6(queryIP);
	    } else return "Neither";
  	}

  	private String validateIPv4(String queryIP) {
	    String[] nums = queryIP.split("\\.", -1);
	    for (String x : nums) {
	      	// Validate integer in range (0, 255):
	      	// 1. length of chunk is between 1 and 3
	      	if (x.length() == 0 || x.length() > 3) return "Neither";
	      	// 2. no extra leading zeros
	      	if (x.charAt(0) == '0' && x.length() != 1) return "Neither";
	      	// 3. only digits are allowed
	      	for (char ch : x.toCharArray()) {
	        	if (!Character.isDigit(ch)) return "Neither";
	      	}
	      	// 4. less than 255
	      	if (Integer.parseInt(x) > 255) return "Neither";
	    }
	    return "IPv4";
	}

  	private String validateIPv6(String queryIP) {
	    String[] nums = queryIP.split(":", -1);
	    String hexdigits = "0123456789abcdefABCDEF";
	    for (String x : nums) {
	      	// Validate hexadecimal in range (0, 2**16):
	      	// 1. at least one and not more than 4 hexdigits in one chunk
	      	if (x.length() == 0 || x.length() > 4) return "Neither";
	      	// 2. only hexdigits are allowed: 0-9, a-f, A-F
	      	for (Character ch : x.toCharArray()) {
	        	if (hexdigits.indexOf(ch) == -1) return "Neither";
	      	}
	    }
	    return "IPv6";
  	}
}