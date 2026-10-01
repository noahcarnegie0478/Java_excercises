/**
 * TASK: Extreme - Medium
 * Source image: exercise/arrays-basics - special/m-35-Extreme.png
 *
 * An array A consisting of N integers is given. The average value of array A
 * is defined as:
 *     (A[0] + A[1] + ... + A[N-1]) / N
 *
 * The deviation of element A[P] (where 0 <= P < N) is defined as |A[P] - M|,
 * where M is the average value of array A.
 *
 * Element A[P] is called extreme if its deviation is maximal among all the
 * elements of A.
 *
 * For example, consider the following array A consisting of four elements:
 *     A[0] =  9
 *     A[1] =  4
 *     A[2] = -3
 *     A[3] = -10
 * The average value of this array is (9 + 4 + (-3) + (-10)) / 4 = 0. The
 * deviation of element A[2] is |(-3) - 0| = |0 - (-3)| = 3. The deviation of
 * element A[3] is 10. It is an extreme element of array A, since no other
 * element has a deviation greater than 10. There are no other extreme
 * elements in this array.
 *
 * Write a function:
 *     class Solution { public int solution(int[] A); }
 * that, given an array A consisting of N integers, returns the index of an
 * extreme element. If more than one extreme element exists, the function may
 * return the index of any of them. If the array is empty (and hence no
 * extreme element exists), the function should return -1.
 *
 * For example, given array A shown above, the function should return 3,
 * since A[3] is the only extreme element.
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
        if (A.length == 0) return -1;
        

        // caculate the average 
        int average = 0;
        for (int i : A) {
            average = average + i;
        }
        average = average / A.length;



        // and then loop through everysingle one to find the best index that hold the greatest value; 
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            //condition: avarage - A[i] -> if result >= max -> replace max with index
            int res = Math.abs(A[i] - average);
            if (res >  Math.abs(A[max] - average)) max = i;
            
        }
        return max;


    }
}
