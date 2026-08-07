/**
 * TASK: Array Jump
 * Source image: exercise/linked-lists/e-30-ArrayJmp.png
 *
 * A non-empty array A consisting of N integers is given. Each element of the array
 * can be treated as a relative pointer to another element in the array: if A[K] = M
 * then element A[K] points to element A[K+M].
 *
 * The array defines a sequence of jumps of a pawn as follows:
 * - initially, the pawn is located at element A[0];
 * - on each jump the pawn moves from its current element to the destination element
 *   pointed to by the current element; i.e. if the pawn stands on element A[K] then
 *   it jumps to the element pointed to by A[K];
 * - the pawn may jump forever or may jump out of the array.
 *
 * For example, consider the following array A:
 *     A[0] = 2   A[1] = 3   A[2] = -1
 *     A[3] = 1   A[4] = 3
 *
 * This array defines the following sequence of jumps of the pawn:
 * - initially, the pawn is located at element A[0];
 * - on the first jump, the pawn moves from A[0] to A[2] because 0 + A[0] = 2;
 * - on the second jump, the pawn moves from A[2] to A[1] because 2 + A[2] = 1;
 * - on the third jump, the pawn moves from A[1] to A[4] because 1 + A[1] = 4;
 * - on the fourth jump, the pawn jumps out of the array.
 *
 * Write a function:
 *     class Solution { public int solution(int[] A); }
 * that, given a non-empty array A consisting of N integers, returns the number of
 * jumps after which the pawn will be out of the array. The function should return
 * -1 if the pawn will never jump out of the array.
 *
 * For example, for the array A given above, the function should return 4, as
 * explained above.
 *
 * Given array A such that:
 *     A[0] = 1   A[1] = 1   A[2] = -1   A[3] = 1
 *
 * the function should return -1, because the pawn keeps jumping between indices
 * 0 and 1 forever and never leaves the array.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1..100,000];
 * - each element of array A is an integer within the range [-1,000,000..1,000,000].
 */
public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public int solution(int[] A) {
            int count = 0;
            // keep counting between the index, if current > int.length -1 => return
            boolean[] checked = new boolean[A.length];
            int current = 0;


            while (current < A.length && current >=0) {
                
                if (checked[current] != false) {return -1;}
                int next = current + A[current];
                checked[current] = true;
                current = next;
                count++;
            }

            return count;


        // throw new UnsupportedOperationException("TODO: implement");
    }
}
