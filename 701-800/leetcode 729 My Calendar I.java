// leetcode 729 My Calendar I

/*
time: O(nlogn)
space: O(n)
*/

class MyCalendar {

    TreeMap<Integer, Integer> map;
	public MyCalendar() {
	    map = new TreeMap<>();
	}

	public boolean book(int start, int end) {
	    Integer low = map.lowerKey(end);
	    
	    if (low == null || map.get(low) <= start) {
	        map.put(start, end);
	        return true;
	    }
	    return false;
	}
}
