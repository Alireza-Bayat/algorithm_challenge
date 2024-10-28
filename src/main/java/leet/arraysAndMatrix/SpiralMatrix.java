package leet.arraysAndMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * Input: matrix = [[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
 * Output:  [1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13]
 */
public class SpiralMatrix {

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return list;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0;
        int bottom = row - 1;
        int right = col - 1;
        int left = 0;
        int direction = 0;

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                direction = 1;
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                direction = 2;
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                direction = 3;
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
                direction = 0;
            }

        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix3 = {{6, 9, 7}};
        int[][] matrix4 = {{7}, {9}, {6}};
        List<Integer> list1 = spiralOrder(matrix1);
        List<Integer> list2 = spiralOrder(matrix2);
        List<Integer> list3 = spiralOrder(matrix3);
        List<Integer> list4 = spiralOrder(matrix4);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
    }
}
