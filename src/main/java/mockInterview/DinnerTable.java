package mockInterview;


/**
 * There are N people sitting at a round table, having dinner. They are numbered from 0 to N-1 in clockwise order. Initially, each person has a dish on the table in front of them. Person number K does not like the taste of A[K], but has a dish of taste B[K]. We want every person to have a dish of a taste that they do not dislike, i.e. A[K] ≠ B[K] for each K from 0 to N-1.
 * In order to achieve this, you can rotate the whole table clockwise by one position any number of times. Rotating the table corresponds to moving the last element of B to the beginning. For example, given A = [3, 6, 4, 5] and B = [2, 6, 3, 5], if we rotate the table once, we would obtain B = [5, 2, 6, 3].
 * Find the minimum number of table rotations that need to be performed in order to satisfy every person.
 * <p>
 * Write a function:
 * class DinnerTable { public int solution(int[] A, int[] B); }
 * that, given arrays A and B, both consisting of N integers, representing tastes that people do not like and the taste of their dishes, respectively, returns the minimum number of table rotations required so that every person has a dish whose taste they do not dislike. In particular, if no rotations are needed, the function should return 0. If fulfilling the above condition is impossible, the function should return -1.
 * <p>
 * Examples:
 * <p>
 * 1. Given A = [1, 3, 5, 2, 8, 7] and B = [7, 1, 9, 8, 5, 7], your function should return 2. After rotating the table twice, we obtain B = [5, 7, 7, 1, 9, 8], so A[K] ≠ B[K] for every K from 0 to 5. If we rotated the table once, we would obtain B = [7, 7, 1, 9, 8, 5], which does not fulfil the condition, since A[4] = B[4] = 8. If we did not rotate the table at all, there would be A[5] = B[5] = 7. Note that rotating the table three times gives us B = [8, 5, 7, 7, 1, 9], which fulfils the condition too, but is not minimal.
 * 2. Given A = [1, 1, 1, 1] and B = [1, 2, 3, 4], your function should return -1. It is impossible to rotate the table so that every person is satisfied. Someone will always have a dish of taste 1.
 * 3. Given A = [3, 5, 0, 2, 4] and B = [1, 3, 10, 6, 7], your function should return 0. No rotation is needed to ensure that A[K] ≠ B[K].
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..300];
 * each element of arrays A and B is an integer within the range [0..1,000];
 * arrays A and B have equal sizes.
 */
public class DinnerTable {

    public int solution(int[] A, int[] B) {
        int rotateCounter = 0;
        while (!isSeatSatisfied(A, B) && (A.length > rotateCounter)) {
            rotateArray(B);
            rotateCounter++;
        }
        if (A.length == rotateCounter)
            return -1;
        return rotateCounter;
    }

    private void rotateArray(int[] A) {
        int lastIndex = A[A.length - 1];
        for (int i = A.length - 1; i > 0; i--) {
            A[i] = A[i - 1];
        }
        A[0] = lastIndex;
    }

    private boolean isSeatSatisfied(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i])
                return false;
        }
        return true;
    }
}
