/**
 * TASK: Nth From The End
 * Source image: exercise/linked-lists/e-35-NthLast.png
 *
 * Assume that the following declarations are given:
 *     class IntList {
 *       public int value;
 *       public IntList next;
 *     }
 *
 * Write a function:
 *     class Solution { public int solution(IntList L, int M); }
 * that, given a single-linked list L consisting of N integers and a positive
 * integer M, returns the value stored in the M-th element in the list, counting
 * from the end, assuming that the last element in the list has index 1. The
 * function should return -1 if it is not possible to return such a value.
 *
 * For example, given L such that:
 *     L = 1 -> 2 -> 3 -> 4
 *
 * and M = 2, the function should return 3, because the second element counting
 * from the end of the list has value 3.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [0..100,000];
 * - M is an integer within the range [1..1,000,000,000];
 * - each element of L can be any integer from the interval [-2,147,483,648..2,147,483,647].
 */

class IntList {
    public int value;
    public IntList next;
}

public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public int solution(IntList L, int M) {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
