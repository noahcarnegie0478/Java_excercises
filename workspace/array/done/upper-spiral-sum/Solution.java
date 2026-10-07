import java.lang.reflect.Array;
import java.util.Arrays;

import java.util.Arrays;

/**
 * TASK: UpperSpiralSum
 * Source images: exercise/arrays-basics - special/m-70-UpperSpiralSum-1.png,
 *                exercise/arrays-basics - special/m-70-UpperSpiralSum-2.png
 *
 * A zero-indexed matrix A consisting of N rows and M columns of integers is
 * given. It can be decomposed into two sets, called upper spiral and lower
 * spiral. The decomposition proceeds as follows:
 * - remove the top row of the matrix and assign its elements to the upper
 *   spiral;
 * - if a non-empty matrix is left, remove the bottom row of the matrix and
 *   assign its elements to the lower spiral;
 * - if a non-empty matrix is left, rotate it counter-clockwise (so that the
 *   rightmost column becomes the top row) and repeat.
 *
 * For example, consider matrix A consisting of 7 rows and 8 columns:
 *      5   3   8   9   4   1   3  -2
 *      4   6   0   3   6   4   2   1
 *      4  -5   3   1   9   5   6   6
 *      3   7   5   3   2   8   9   4
 *      5   3  -3   6   3   2   8   0
 *      5   7   5   3   3  -9   2   2
 *      0   4   3   2   5   7   5   4
 *
 * Write a function:
 *     class Solution { public int solution(int[][] A); }
 * that, given a zero-indexed matrix A consisting of N rows and M columns of
 * integers, returns the sum of the elements that belong to the upper spiral
 * of matrix A. The function should return -1 if the sum does not lie within
 * the range [-100,000,000..100,000,000].
 *
 * For example, given the matrix above, the function should return 91,
 * because 5+3+8+9+4+1+3+(-2) + 1 + 6+4+0+2 + 3+1+9+5 + (-9)+3+7+5 + 8+2+3
 * = 91.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N and M are integers within the range [1..1,000,000];
 * - the number of elements in matrix A is within the range [1..99,999,999];
 * - each element of matrix A is an integer within the range
 *   [-2,147,483,648..2,147,483,647].
 */
public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public int solution(int[][] A) {
        long sumHorizontal = 0;
        long sumVertical = 0;

        // idea is go circle

        // row-pairs: i-th pair is (row i, row N-1-i). Must stop once the
        // column range for that pair is already exhausted (lengthAllow <= i),
        // otherwise copyOfRange gets an invalid (from > to) range.
        for (int i = 0; i < (A.length + 1) / 2; i++) {

            //if i ~ even -> it is on the top -> else it is at the bottom

            int lengthAllow = A[0].length - i;
            if (lengthAllow <= i) break;
            int currentIndex = i % 2 == 0 ? i : A.length - i - 1;
            int[] sub = Arrays.copyOfRange(A[currentIndex], i, lengthAllow);
            sumHorizontal += sumOfArray(sub);
        }

        // column-pairs: i-th pair is (col M-1-i, col i).
        for (int i = 0; i < (A[0].length + 1) / 2; i++) {
            //if i ~ even -> it is on the right -> else it is at the left
            int currentIndex = i % 2 == 0 ?  A[0].length - i - 1 : i;
            int starting  = i+1;
            int allowed = A.length - starting;
            if (allowed <= 0) break;
            for (int e = starting; e < allowed; e++) {
                sumVertical += A[e][currentIndex];
            }
        }
        long result  = sumHorizontal + sumVertical;
        return result >= -100000000L && result <= 100000000L ? (int) result : -1;

    }


    public int sumOfArray (int[] array) {
        int sum = 0;
        for (int i : array) {
            sum+=i;   
        }
        return sum;
    }
    
}
