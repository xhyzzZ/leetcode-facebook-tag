//leetcode 336 Palindrome Pairs

/*
time: O()
space: O()
*/

class Solution {
    /** 
	 * Step 1: store every word with its index into a hash map.
	 * Step 2: For each word in the array, split into two parts str1 and str2. Check whether str1 and str2 is palindrome
	 * If str1 is palindrome, we can use str1 as middle part, str2 as right part, and find if map contains reversed str2.
	 * If contains, then we can use that string as left part, combine with middle part, right part, it will form a correct
	 * palindrome string. 
	 * Step 3: do all same operations for str2 (set str2 as middle part) 
	 * */
	public List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> result = new ArrayList<>();
	    if (words.length == 0) {
	        return result;
	    }

	    // step1
	    Map<String, Integer> map = new HashMap<>();
	    for (int i = 0; i < words.length; i++) {
	        map.put(words[i], i);
	    }

	    for (int i = 0; i < words.length; i++) {
	        for (int j = 0; j <= words[i].length(); j++) {
	            String str1 = words[i].substring(0, j);
	            String str2 = words[i].substring(j);

	            // step 2
	            if (isPalindrome(str1)) {
	                String reversedStr2 = new StringBuilder(str2).reverse().toString();

	                  /* WARNING: MUST CHECK whether str.length() is equal to 0 in either if statement, because we need to make sure
	                   *  we do not add duplicate pairs (if str1.length() == 0, both of str1 and str2 will from input array) */
	                if (map.containsKey(reversedStr2) && map.get(reversedStr2) != i && str1.length() != 0) {
	                    List<Integer> newPair = new ArrayList<>();
	                    newPair.add(map.get(reversedStr2));
	                    newPair.add(i);
	                    result.add(newPair);
	                }
	            }

	            // step 3
	            if (isPalindrome(str2)) {
	                String reversedStr1 = new StringBuilder(str1).reverse().toString();
	                if (map.containsKey(reversedStr1) && map.get(reversedStr1) != i) {
	                    List<Integer> newPair = new ArrayList<>();
	                    newPair.add(i);
	                    newPair.add(map.get(reversedStr1));
	                    result.add(newPair);
	                }
	            }
	        }
	    }
	    return result;
	}

	public boolean isPalindrome(String s) {
	    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
	        if (s.charAt(i) != s.charAt(j)) {
	            return false;
	        }
	    }
	    return true;
	}        
}