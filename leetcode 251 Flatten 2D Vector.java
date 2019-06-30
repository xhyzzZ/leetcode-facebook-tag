//leetcode 251 Flatten 2D Vector

/*
time: O()
space: O()
*/

class Vector2D {
    int data [][];
    int rows, row, col;
    public Vector2D(int[][] v) {
        data = v;
        rows = v.length;
        row = 0;
        col = 0;
    }
    
    public int next() {
        if(hasNext()) {
            //store next to support peek 
            int next = data[row][col++];
            return next;
        }
        throw new UnsupportedOperationException();
    }
    
    public boolean hasNext() {
       while(row < rows){
           if(col < data[row].length) {
               return true;
           }
           row++;
           col = 0;    
       }
       return false;
    }
}