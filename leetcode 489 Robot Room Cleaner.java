//leetcode 489 Robot Room Cleaner

/*
time: O(n)
space: O(n)
*/

class Solution {
    public void cleanRoom(Robot robot) {
    	private static final int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	    private void find(Robot robot, Set<String> visited, int curDirection, int row, int col) {
	        StringBuilder sb = new StringBuilder();
	        sb.append(row);
	        sb.append(">");
	        sb.append(col);
	        visited.add(sb.toString());
	        robot.clean();
	        for (int i = 0; i < 4; ++i) {
	            int direction = (curDirection + i) % 4;
	            int [] next = directions[direction];
	            int nextRow = row + next[0];
	            int nextCol = col + next[1];
	            sb = new StringBuilder();
	            sb.append(nextRow);
	            sb.append(">");
	            sb.append(nextCol);
	            if (!visited.contains(sb.toString()) && robot.move()) {
	                find(robot, visited, direction, nextRow, nextCol);
	                robot.turnLeft();
	                robot.turnLeft();
	                robot.move();
	                robot.turnLeft();
	                robot.turnLeft();
	            }
	            robot.turnRight();
	        }
	    }
	    
	    public void cleanRoom(Robot robot) {
	        Set<String> offset = new HashSet<>();
	        find(robot, offset, 0, 0, 0);
	    }
    }
}