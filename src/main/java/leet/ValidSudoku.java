package leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {//n
            List<Character> rowMap = new ArrayList<>();
            List<Character> colMap = new ArrayList<>();
            for (int j = 0; j < cols; j++) {//n^2
                char row = board[i][j];//row
                char col = board[j][i];//col

                if (rowMap.contains(row) || colMap.contains(col)) {//m
                    return false;
                }
                if (col != '.')
                    colMap.add(col);
                if (row != '.')
                    rowMap.add(row);
            }
        }


        /**
         * // the box check
         *         for(int box = 0; box < 9; box++) {
         *             Set<Character> boxSet = new HashSet<>();
         *             for(int i = 0; i < 3; i++) {
         *                 for(int j = 0; j< 3; j++) {
         *                     int oriRow = i + 3 * (box / 3);
         *                     int oriCol = j + 3 * (box % 3);
         *
         *                     if (board[oriRow][oriCol] != '.') {
         *                         if (!boxSet.add(board[oriRow][oriCol])) return false;
         *                     }
         *                 }
         *             }
         *         }
         * */
        for (int i = 1; i < rows; i += 3) {
            boolean flag =
                    checkBlock(i, 1, board) ||
                            checkBlock(i, 4, board) ||
                            checkBlock(i, 7, board);
            if (flag) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkBlock(int x, int y, char[][] board) {
        Set<Character> block = new HashSet<>();
        block.add(board[x][y] == '.' ? 'a' : board[x][y]);
        block.add(board[x - 1][y - 1] == '.' ? 'b' : board[x - 1][y - 1]);
        block.add(board[x - 1][y] == '.' ? 'c' : board[x - 1][y]);
        block.add(board[x - 1][y + 1] == '.' ? 'd' : board[x - 1][y + 1]);
        block.add(board[x][y - 1] == '.' ? 'e' : board[x][y - 1]);
        block.add(board[x][y + 1] == '.' ? 'f' : board[x][y + 1]);
        block.add(board[x + 1][y - 1] == '.' ? 'g' : board[x + 1][y - 1]);
        block.add(board[x + 1][y] == '.' ? 'h' : board[x + 1][y]);
        block.add(board[x + 1][y + 1] == '.' ? 'i' : board[x + 1][y + 1]);
        return block.size() != 9;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board2 = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '6', '.', '.', '9'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '1', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};

        char[][] board3 = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(isValidSudoku(board3));

    }
}
