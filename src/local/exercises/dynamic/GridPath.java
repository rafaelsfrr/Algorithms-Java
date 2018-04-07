package local.exercises.dynamic;

import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

public class GridPath {

    public class Point {
        private int row;
        private int col;
        boolean isOutOfBounds;

        public Point(int row, int col, boolean isOutOfBounds) {
            this.row = row;
            this.col = col;
            this.isOutOfBounds = isOutOfBounds;
        }

        @Override
        public String toString() {
            return "(" + row + "," + col + ")";
        }
    }

    Point[][] initGrid(int length) {
        Point[][] grid = new Point[length][length];
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                Point p = new Point(i, j, false);
                grid[i][j] = p;
            }
        }

        return grid;
    }

    Stack<Point> getPath(Point[][] grid) {
        if(grid == null || grid.length == 0) {
            return null;
        }

        Stack<Point> path = new Stack<>();
        HashSet<Point> failedPoints = new HashSet<>();

        if(getPath(grid, grid.length - 1, grid[0].length - 1, path, failedPoints)) {
            return path;
        }

        return null;
    }

    private boolean getPath(Point[][] grid, int row, int col, Stack<Point> path,
                            HashSet<Point> failedPoints) {
        // check bounds
        if(col < 0 || row < 0) {
            return false;
        }

        boolean pointOutOfBounds = (grid[row][col]).isOutOfBounds;
        if(pointOutOfBounds) {
            return false;
        }

        Point p = new Point(row, col, pointOutOfBounds);

        // Cache hit
        if(failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        // (row, col) -> (row, col - 1) -> move left
        // (row, col) -> (row - 1, col) -> move up
        if(isAtOrigin || getPath(grid, row, col - 1, path, failedPoints) ||
                getPath(grid, row - 1, col, path, failedPoints)) {
            path.push(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }

    public static void main(String[] args) {
        GridPath gp = new GridPath();
        Point[][] grid = gp.initGrid(5);

        Stack<Point> path = gp.getPath(grid);

        for(Point p : path) {
            System.out.println(p);
        }
    }
}
