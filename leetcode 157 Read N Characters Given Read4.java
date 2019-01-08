//leetcode 157 Read N Characters Given Read4


/*
time: O()
space: O()
*/
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int idx = 0;
        
        while (true) {
            int curr = read4(buffer);
            int currLen = Math.min(curr, n - idx);
            
            for (int i = 0; i < currLen; i++) {
                buf[idx + i] = buffer[i];
            }
            idx += currLen;
            
            if (currLen != 4 || idx == n) return idx;
        }
    }
}