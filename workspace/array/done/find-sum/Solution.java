/**
 * TASK: Find Sum
 * Source image: exercise/arrays-basics - special/el-15-FindSum.png
 *
 * Write a function:
 *     class Solution { public int solution(int[] A); }
 * that, given an array A of N integers, returns the sum of values from
 * array A:
 *     sum{ A[i] : 1 <= i <= N }
 *
 * For example, given:
 *     A[0] = 1
 *     A[1] = 2
 *     A[2] = 3
 *     A[3] = 42
 *     A[4] = 1
 *     A[5] = -7
 * your function should return 42.
 *
 * Assume that:
 * - N is an integer within the range [1..100,000];
 * - each element of array A is an integer within the range
 *   [-10,000..10,000].
 */
public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public int solution(int[] A) {
        int sum = 0; 
        for (int i : A ) sum+= i;
        return sum;
    }
}
