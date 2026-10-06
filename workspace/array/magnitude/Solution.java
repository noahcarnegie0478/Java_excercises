/**
 * TASK: Magnitude
 * Source image: exercise/arrays-basics - special/m-40-Magnitude.png
 *
 * An array A consisting of N integers is given. A magnitude pole of this
 * array is an integer Q such that:
 * - 0 <= Q < N;
 * - A[P] <= A[Q] for 0 <= P < Q;
 * - A[Q] <= A[R] for Q < R < N.
 *
 * For example, consider array A consisting of ten elements such that:
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 3
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 7
 *     A[7] = 8
 *     A[8] = 6
 *     A[9] = 9
 * Number 5 is a magnitude pole of this array, because all elements to the
 * left of A[5] have values smaller than or equal to A[5] (4, 2, 2, 3 and 1
 * are smaller than or equal to 4) and all elements to the right of A[5]
 * have values greater than or equal to A[5] (7, 8, 6 and 9 are greater than
 * or equal to 4). Number 9 is also a magnitude pole of this array.
 *
 * Write a function:
 *     class Solution { public int solution(int[] A); }
 * that, given an array A consisting of N integers, returns any of its
 * magnitude poles. The function should return -1 if array A does not have
 * a magnitude pole.
 *
 * For example, given array A consisting of ten elements such that:
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 3
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 7
 *     A[7] = 8
 *     A[8] = 6
 *     A[9] = 9
 * the function may return 5 or 9, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [0..100,000];
 * - each element of array A is an integer within the range
 *   [-2,147,483,648..2,147,483,647].
 */
public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public int solution(int[] A) {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
