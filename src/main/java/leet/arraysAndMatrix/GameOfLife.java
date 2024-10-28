package leet.arraysAndMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * According to https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * <p>
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 */
public class GameOfLife {

    private static void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        Map<Integer, List<Integer>> changes = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (shouldValueChange(i, j, board)) {
                    if (changes.containsKey(i)) {
                        changes.get(i).add(j);
                    } else {
                        List<Integer> val = new ArrayList<>();
                        val.add(j);
                        changes.put(i, val);
                    }
                }
            }
        }

        for (Integer key : changes.keySet()) {
            List<Integer> list = changes.get(key);
            for (Integer colIndex : list) {
                if (board[key][colIndex] == 0) {
                    board[key][colIndex] = 1;
                } else {
                    board[key][colIndex] = 0;
                }
            }
        }
    }

    private static boolean shouldValueChange(int x, int y, int[][] board) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        int rows = board.length;
        int cols = board[0].length;

        int currentCellStatus = board[x][y];
        int liveCounter = 0;

        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                if (board[newX][newY] == 1) {
                    liveCounter++;
                }
            }
        }

        if (currentCellStatus == 1) {
            return liveCounter < 2 || liveCounter > 3;
        }
        return liveCounter == 3;
    }


    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}}; // output [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        gameOfLife(board);
        System.out.println(board);
    }
}
