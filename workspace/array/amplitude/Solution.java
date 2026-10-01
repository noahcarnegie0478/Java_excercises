/**
 * TASK: Amplitude - EZ
 * Source image: exercise/arrays-basics - special/e-30-Amplitude.png
 *
 * A non-empty array A consisting of N integers is given. The amplitude of this
 * array is defined as the largest possible difference between two of its
 * elements, i.e.:
 *     amplitude(A) = max{ A[P] - A[Q] : 0 <= P, Q < N }
 *
 * Write a function:
 *     class Solution { public int solution(int[] A); }
 * that, given a non-empty array A consisting of N integers, returns its
 * amplitude.
 *
 * Example:
 * Given array A such that:
 *     A[0] = 10
 *     A[1] = 2
 *     A[2] = 44
 *     A[3] = 15
 *     A[4] = 39
 *     A[5] = 20
 * the function should return 42.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1..1,000,000];
 * - each element of array A is an integer within the range [0..5,000,000].
 */
public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public int solution(int[] A) {
        // throw new UnsupportedOperationException("TODO: implement");
        if (A.length == 0) return -1;
        int maxNumber = A[0];
        int minNumber = A[0];

        for (int i : A) {
            maxNumber = Math.max(maxNumber, i);
            minNumber = Math.min(minNumber, i);
           
        }
        return maxNumber - minNumber;

    }
}
