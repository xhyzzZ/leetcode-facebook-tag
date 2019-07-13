//leetcode 158 Read N Characters Given Read4 II - Call multiple times


/*
time: O(n)
space: O(1)

This is a great solution! I just noticed two things to make it more intuitive.

shift breaking condition to the end, "if (buffCnt < 4) break;"
instead of "if (buffPtr >= buffCnt)", simply "if (buffPtr == buffCnt)"
*/
public class Solution extends Reader4 {
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];

    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            // all chars in buff used up, set pointer to 0
            if (buffPtr == buffCnt) buffPtr = 0;
            // read4 returns less than 4, end of file
            if (buffCnt < 4) break;
        }
        return ptr;
    }
}