import java.util.*;

public class backTracking {

    public static boolean solveMaze(int[][] maze, int row, int col) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        return solve(maze, row, col, visited);
    }

    private static boolean solve(int[][] maze, int row, int col, boolean[][] visited) {
        int n = maze.length;
        int m = maze[0].length;

        if (row < 0 || col < 0 || row >= n || col >= m || maze[row][col] == 0 || visited[row][col]) {
            return false;
        }

        myClass.path.add(row);
        myClass.path.add(col);
        visited[row][col] = true;

        if (row == n - 1 && col == m - 1) {
            return true;
        }

        if (solve(maze, row + 1, col, visited) ||
            solve(maze, row, col + 1, visited) ||
            solve(maze, row - 1, col, visited) ||
            solve(maze, row, col - 1, visited)) {
            return true;
        }

        myClass.path.remove(myClass.path.size() - 1);
        myClass.path.remove(myClass.path.size() - 1);

        return false;
    }
}