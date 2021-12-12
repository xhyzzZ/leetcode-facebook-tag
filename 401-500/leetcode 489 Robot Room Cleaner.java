// leetcode 489 Robot Room Cleaner

/*
time: O(n)
space: O(n)
*/

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */


class Solution {
	private static final int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public void cleanRoom(Robot robot) {
        clean(robot, 0, 0, 0, new HashSet<>());
    }
    // move forward - move; orientation x
	// move right - turnRight, move; orientation (x + 1) % 4
	// move backward - turnRight, turnRight, move; orientation (x + 2) % 4
	// move left - turnRight, turnRight, turnRight, move;  orientation (x + 3) % 4
    
    private void clean(Robot robot, int x, int y, int curDirection, Set<String> visited) {
        // Cleans current cell.
        robot.clean();
        visited.add(x + " " + y);
        
        for (int nDirection = curDirection; nDirection < curDirection + 4; nDirection++) {
            int nx = dirs[nDirection % 4][0] + x;
            int ny = dirs[nDirection % 4][1] + y;
            if (!visited.contains(nx + " " + ny) && robot.move()) {
                clean(robot, nx, ny, nDirection % 4, visited);
            }
            // Changed orientation.
            robot.turnRight();
        }
        
        // Moves backward one step while maintaining the orientation.
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}