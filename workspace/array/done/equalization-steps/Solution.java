/**
 * TASK: Equalization Steps 
 * Source image: exercise/arrays-basics - special/m-40-EqualizationSteps.png
 *
 * An array A consisting of N integers is given. It can be transformed as
 * follows: each element of the array is increased or decreased by 1. For
 * example, array:
 *     [11, 3, 7, 1]
 * can be transformed into:
 *     [12, 4, 8, 0] or [10, 4, 6, 2] or [10, 2, 6, 0] etc.
 *
 * Write a function:
 *     class Solution { public int solution(int[] A); }
 * that, given an array A, returns the minimum number of transformation
 * steps, as described above, that are necessary to make all elements in the
 * array equal. The function should return -1 if this is not possible.
 *
 * For example, given this array:
 *     [11, 3, 7, 1]
 * the following five steps transform it into an array whose elements are
 * all equal:
 * - [11, 3, 7, 1] (initial array)
 * - [10, 4, 6, 2] (after step 1)
 * - [9, 5, 7, 3] (after step 2)
 * - [8, 6, 6, 4] (after step 3)
 * - [7, 7, 5, 5] (after step 4)
 * - [6, 6, 6, 6] (after step 5)
 * There are other sequences that will transform this array into one that
 * has all elements equal, but none of them uses fewer than five steps.
 * Therefore, the function should return 5 when given this array.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [0..20,000];
 * - each element of array A is an integer within the range
 *   [-200,000,000..200,000,000].
 */
public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public int solution(int[] A) {
        if (A.length == 0) return 0;
        int min =A[0];
        int max = min;
         for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
         }
        if (max - min == 0) return 0;
        if (max - min == 1) return -1;
        return (max + min) / 2 - min;

        // if they just different 1 number, -> then return -1

    }
}
