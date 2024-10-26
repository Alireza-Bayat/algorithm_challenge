package leet;

public class WordSearch {

//    public static boolean exist(char[][] board, String word) {
//        String s = doesStringExistInMaze(board, word, new StringBuilder(), 0, 0, 0);
//        return s.length()==word.length();
//    }
//
//    private static String doesStringExistInMaze(char[][] board, String word, StringBuilder path, int x, int y, int index) {
//        if (word.equals(path.toString())) {
//            return path.toString();
//        }
//
//        for (int i = y; i < board[0].length; i++) {
//            if (word.charAt(index) != board[x][i])
//                break;
//            path.append(board[x][i]);
//            if (x < board.length-1)
//                doesStringExistInMaze(board, word, path, x + 1, y, index + 1);
//            if (y <= board[0].length)
//                doesStringExistInMaze(board, word, path, x, y + 1, index + 1);
//            if (x != 0)
//                doesStringExistInMaze(board, word, path, x - 1, y, index + 1);
//            if (y != 0)
//                doesStringExistInMaze(board, word, path, x, y - 1, index + 1);
//            path.setLength(path.length() - 1);
//        }
//
//        return path.toString();
//    }


    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Try to start the search from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchWord(board, word, i, j, 0, new boolean[rows][cols])) {
                    return true;
                }
            }
        }

        return false;
    }

    // Helper method to recursively search for the word
    private static boolean searchWord(char[][] board, String word, int x, int y, int index, boolean[][] visited) {
        // Base case: if index equals word length, we've found the word
        if (index == word.length()) {
            return true;
        }

        // Boundary conditions: check if x, y are out of bounds or the cell is already visited
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited
        visited[x][y] = true;

        // Explore all 4 directions: up, down, left, right
        boolean found = searchWord(board, word, x + 1, y, index + 1, visited) ||  // Down
                searchWord(board, word, x - 1, y, index + 1, visited) ||  // Up
                searchWord(board, word, x, y + 1, index + 1, visited) ||  // Right
                searchWord(board, word, x, y - 1, index + 1, visited);    // Left

        // Unmark the cell (backtrack)
        visited[x][y] = false;

        return found;
    }

    public static void main(String[] args) {
        //'A', 'B', 'C', 'E'
        //'S', 'F', 'C', 'S'
        //'A', 'D', 'E', 'E'
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
    }
}
