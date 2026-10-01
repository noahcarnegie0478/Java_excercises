import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TASK: Coding Find Common Min - EZ
 * Source image: exercise/arrays-basics - special/e-30-CodingFindCommonMin.png
 *
 * Write a function:
 *     class Solution { public int solution(int[] A, int[] B); }
 * that, given a non-empty array A of N non-negative integers and a non-empty
 * array B of M non-negative integers, returns the minimal value that occurs in
 * both arrays. If there is no such value, the function should return -1.
 *
 * Examples:
 * 1. Given arrays A and B such that:
 *        A[0] = 1   B[0] = 4
 *        A[1] = 3   B[1] = 2
 *        A[2] = 2   B[2] = 5
 *        A[3] = 1   B[3] = 3
 *                   B[4] = 2
 *    your function should return 2, since 2 is the minimal value which occurs
 *    in both arrays A and B (another value which occurs in both arrays is 3).
 *
 * 2. Given arrays A and B such that:
 *        A[0] = 2   B[0] = 3
 *        A[1] = 1   B[1] = 3
 *    your function should return -1, since there is no value that occurs in
 *    both arrays.
 *
 * Assume that:
 * - N and M are integers within the range [1..1,000];
 * - each element of arrays A and B is an integer within the range [0..3,000].
 *
 * In your solution, focus on correctness. The performance of your solution
 * will not be the focus of the assessment.
 */
public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public int solution(int[] A, int[] B) {
        // 
        int result = -1;
        Set<Integer> aStrorage = new HashSet<>();
        for (int i : A) aStrorage.add(i);  
        for (int e : B) if (aStrorage.contains(e) && (result == -1 || e < result) ) result = e;     
        return result;
    }
}
