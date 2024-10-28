package leet.arraysAndMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * <p>
 * You must do it in place.
 */
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        Map<Integer, List<Integer>> marks = new HashMap<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (marks.containsKey(i)) {
                        marks.get(i).add(j);
                    } else {
                        List<Integer> value = new ArrayList<>();
                        value.add(j);
                        marks.put(i, value);
                    }
                }
            }
        }

        for (Integer key : marks.keySet()) {
            List<Integer> values = marks.get(key);
            for (int i = 0; i < col; i++) {
                matrix[key][i] = 0;
            }
            for (Integer column : values) {
                for (int i = 0; i < row; i++) {
                    matrix[i][column] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        System.out.println(matrix);
    }
}
