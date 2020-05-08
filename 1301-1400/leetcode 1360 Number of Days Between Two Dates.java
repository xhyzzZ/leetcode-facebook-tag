// leetcode 1360 Number of Days Between Two Dates

/*
time: O(1)
space: O(1)
*/

import java.util.Date;
import java.text.SimpleDateFormat;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        float daysBetween = 0;
        try {
            Date dateBefore = myFormat.parse(date1);
            Date dateAfter = myFormat.parse(date2);
            long difference = Math.abs(dateAfter.getTime() - dateBefore.getTime());
            daysBetween = (difference / (1000 * 60 * 60 * 24));
        } catch (Exception e) {
	       e.printStackTrace();
	    }
        return (int) daysBetween;
    }
}