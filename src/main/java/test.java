public class test {

    public static double maxSliceProduct(double[] A) {
        double maxProductionTotal = A[0], maxAtIndex = A[0], minAtIndex = A[0];
        for (int i = 1; i < A.length; i++) {
            double tmp = A[i] * maxAtIndex;
            maxAtIndex = Math.max(A[i], Math.max(tmp, A[i] * minAtIndex));
            minAtIndex = Math.min(A[i], Math.min(tmp, A[i] * minAtIndex));
            maxProductionTotal = Math.max(maxProductionTotal, maxAtIndex);
            if (maxProductionTotal > 1000000000.0) {
                return 1000000000.0;
            }
        }
        return maxProductionTotal;
    }

    public static void main(String[] args) {
        double[] i = new double[]{0.1, -1.0, -7.0, 3.0, -5.0, -2.5, 0.0, 1.0};
        System.out.println(maxSliceProduct(i));
    }
}


class Solution {
//    public double solution(double[] A) {
//        calculateProduction()
//    }


    private double findProperIndexes(double[] A) {
//        int[] indexes = new int[2];//from first needed index to the last maximum
        double maxProduction = A[0];

        for (int i = 0; i < A.length; i++) {

        }

        return 1.0;
    }

    private double calculateProduction(double[] A, int[] indexes) {
        double maxProduction = 1.0;
        for (int i = indexes[0] + 1; i < indexes[1] + 1; i++) {
            maxProduction *= A[i];
        }
        return maxProduction;
    }
}