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
        throw new UnsupportedOperationException("TODO: implement");
    }
}
