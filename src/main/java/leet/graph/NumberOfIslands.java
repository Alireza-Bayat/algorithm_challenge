package leet.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

/**
 * Given an m x n 2D binary grid `grid` which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","1","0"]
 * ]
 * Output: 2
 */
public class NumberOfIslands {

    public static class VersionOne {
        public static int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int rows = grid.length;
            int cols = grid[0].length;
            boolean[][] visited = new boolean[rows][cols];

            int islandCount = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        bfs(grid, visited, i, j);
                        islandCount++;
                    }
                }
            }

            return islandCount;
        }

        public static void bfs(char[][] grid, boolean[][] visited, int startX, int startY) {
            Queue<List<Integer>> queue = new ArrayDeque<>();
            queue.add(Arrays.asList(startX, startY));
            visited[startX][startY] = true;

            while (!queue.isEmpty()) {
                List<Integer> poll = queue.poll();
                int x = poll.get(0);
                int y = poll.get(1);

                getNeighbours(grid, Neighbours.LEFT, x, y).ifPresent(integers -> {
                    int i = integers.get(0);
                    int j = integers.get(1);
                    if (!visited[i][j] && grid[i][j] == '1') {
                        visited[i][j] = true;
                        queue.add(integers);
                    }
                });
                getNeighbours(grid, Neighbours.RIGHT, x, y).ifPresent(integers -> {
                    int i = integers.get(0);
                    int j = integers.get(1);
                    if (!visited[i][j] && grid[i][j] == '1') {
                        visited[i][j] = true;
                        queue.add(integers);
                    }
                });
                getNeighbours(grid, Neighbours.TOP, x, y).ifPresent(integers -> {
                    int i = integers.get(0);
                    int j = integers.get(1);
                    if (!visited[i][j] && grid[i][j] == '1') {
                        visited[i][j] = true;
                        queue.add(integers);
                    }
                });
                getNeighbours(grid, Neighbours.BOTTOM, x, y).ifPresent(integers -> {
                    int i = integers.get(0);
                    int j = integers.get(1);
                    if (!visited[i][j] && grid[i][j] == '1') {
                        visited[i][j] = true;
                        queue.add(integers);
                    }
                });

            }
        }

        private static Optional<List<Integer>> getNeighbours(char[][] grid, Neighbours neighbours, int x, int y) {
            int row = grid.length - 1;
            int col = grid[0].length - 1;

            switch (neighbours) {
                case TOP -> {
                    if (x == 0) {
                        return Optional.empty();
                    }
                    return Optional.of(List.of(x - 1, y));
                }
                case LEFT -> {
                    if (y == 0) {
                        return Optional.empty();
                    }
                    return Optional.of(List.of(x, y - 1));
                }
                case RIGHT -> {
                    if (y >= col) {
                        return Optional.empty();
                    }
                    return Optional.of(List.of(x, y + 1));
                }
                case BOTTOM -> {
                    if (x >= row) {
                        return Optional.empty();
                    }
                    return Optional.of(List.of(x + 1, y));
                }
                default -> {
                    return Optional.empty();
                }
            }
        }

        enum Neighbours {
            LEFT, RIGHT, TOP, BOTTOM
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int islandCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void bfs(char[][] grid, boolean[][] visited, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // RIGHT, DOWN, LEFT, UP

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (isInBounds(newX, newY, grid) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean isInBounds(int x, int y, char[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

}
