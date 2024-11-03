package leet.graph;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 * <p>
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * <p>
 * A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.
 * <p>
 * sample
 * Input: board = [
 * ["X","X","X","X"],
 * ["X","O","O","X"],
 * ["X","X","O","X"],
 * ["X","O","X","X"]]
 * <p>
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || j == 0 || j == col - 1 || i == row - 1) && board[i][j] == 'O' && !visited[i][j]) {
                    bfs(board, visited, i, j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void bfs(char[][] board, boolean[][] visited, int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[startX][startY] = true;
        queue.add(new int[]{startX, startY});

        int[][] neighbours = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] neighbour : neighbours) {
                int newX = x + neighbour[0];
                int newY = y + neighbour[1];

                if (isInbound(board, newX, newY) && board[newX][newY] != 'X' && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean isInbound(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

}
