package leet;

import java.util.List;

public class FlippingMatrix {

    private static int flippingMatrix(List<List<Integer>> matrix) {
//        [1 2 3 4]  2*(2) - 1
//        [2 3 4 5]
//        [4 3 3 2]
//        [1 10 2 2]

        // [0][0] => {1,4,1,2} = +=4[]
        int n = matrix.size() / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int topLeft = matrix.get(i).get(j);
                int topRight = matrix.get(i).get(2 * n - 1 - j);
                int bottomLeft = matrix.get(2 * n - 1 - i).get(j);
                int bottomRight = matrix.get(2 * n - 1 - i).get(2 * n - 1 - j);

                sum += Math.max(Math.max(topLeft, topRight), Math.max(bottomLeft, bottomRight));
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(112, 42, 83, 119),
                List.of(56, 125, 56, 49),
                List.of(15, 78, 101, 43),
                List.of(62, 98, 114, 108)
        );

        int[] a =new  int[10];
        System.out.println(a.length);

        int result = flippingMatrix(matrix);
        System.out.println("Maximum sum in the top-left quadrant: " + result);
    }
}
