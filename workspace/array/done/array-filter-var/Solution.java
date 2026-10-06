/**
 * TASK: Array Filter Var
 * Source image: exercise/arrays-basics - special/ez-40-ArrayFilterVar (Jade variant).png
 *
 * Write a function:
 *     class Solution { public int solution(int[] A); }
 * that, given an array A consisting of N integers, returns the maximum
 * among all one-digit integers.
 *
 * For example, given array A as follows:
 *     [-6, -91, 1011, -100, 84, -22, 0, 1, 473]
 * the function should return 1.
 *
 * Assume that:
 * - N is an integer within the range [1..1,000];
 * - each element of array A is an integer within the range
 *   [-10,000..10,000];
 * - there is at least one element in array A which satisfies the condition
 *   in the task statement.
 */
public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public int solution(int[] A) {
        // that's mean there is a range between -9 - 9;
        
        int result = -9;

        for (int i : A) {
            if (i >= -9 && i <= 9) {
                result = Math.max(i, result);
            }
        }
        return result;
    }
}
