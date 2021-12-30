// leetcode 1868 Product of Two Run-Length Encoded Arrays

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
    	List<List<Integer>> res = new ArrayList<>();
	    if (encoded1 == null || encoded2 == null && encoded1.length == 0 || encoded2.length == 0) return res;
	    
	    int i = 0, j = 0;
	    int[] first = encoded1[i], second = encoded2[j];
	    while (i < encoded1.length && j < encoded2.length) {
	        if (first[1] < second[1]) {
	            addToResult(res, first[0] * second[0], first[1]);
	            second[1] -= first[1];      // Reduce frequency of more frequent one.
	            first = encoded1[++i];      // Less frequent one is fully used up. Can't be out of bounds because the two fully encoded arrays have an equal length.
	    
	        } else if (first[1] > second[1]) {
	            addToResult(res, first[0] * second[0], second[1]);
	            first[1] -= second[1];      
	            second = encoded2[++j];    
	            
	        } else {
	            addToResult(res, first[0] * second[0], first[1]);
	            first = ++i < encoded1.length ? encoded1[i] : null; 
	            second = ++j < encoded2.length ? encoded2[j] : null;
	        }
	    }
	    return res;
	}

	private void addToResult(List<List<Integer>> res, int value, int frequency) {
	    if (res.size() == 0 || res.get(res.size() - 1).get(0) != value) {
	        res.add(Arrays.asList(value, frequency));
	    } else {
	        List<Integer> last = res.remove(res.size() - 1);
	        res.add(Arrays.asList(last.get(0), last.get(1) + frequency));
	    }
	}
}