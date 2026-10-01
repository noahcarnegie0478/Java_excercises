import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TASK: Saddle Count
 * Source image: exercise/arrays-basics - special/e-50-SaddleCount.png
 *
 * A two-dimensional zero-indexed matrix consisting of N rows and M columns is
 * given. A saddle point of that matrix is any pair of integers (P, Q) such
 * that:
 * - 0 < P < N-1;
 * - 0 < Q < M-1;
 * - either element (P, Q) is a local minimum in its row and a local maximum
 *   in its column, i.e. A[P][Q-1] > A[P][Q] < A[P][Q+1] and
 *   A[P-1][Q] < A[P][Q] > A[P+1][Q];
 * - or element (P, Q) is a local maximum in its row and a local minimum in
 *   its column, i.e. A[P][Q-1] < A[P][Q] > A[P][Q+1] and
 *   A[P-1][Q] > A[P][Q] < A[P+1][Q].
 *
 * For example, matrix A such that:
 *     A[0][0] = 0   A[0][1] = 1   A[0][2] = 9   A[0][3] = 3
 *     A[1][0] = 7   A[1][1] = 5   A[1][2] = 8   A[1][3] = 3
 *     A[2][0] = 9   A[2][1] = 2   A[2][2] = 9   A[2][3] = 4
 *     A[3][0] = 4   A[3][1] = 6   A[3][2] = 7   A[3][3] = 1
 * has two saddle points because:
 * - element (1, 1) is a local minimum in its row and a local maximum in its
 *   column, so it is a saddle point;
 * - element (1, 2) is a local maximum in its row and a local minimum in its
 *   column, so it is a saddle point;
 * - element (2, 1) is a local minimum in both its row and its column, so it
 *   is not a saddle point;
 * - element (2, 2) is a local maximum in both its row and its column, so it
 *   is not a saddle point;
 * - other elements do not fulfill the requirements for the coordinates.
 *
 * Write a function:
 *     class Solution { public int solution(int[][] A); }
 * that, given a two-dimensional zero-indexed matrix of size N rows and M
 * columns, returns the number of saddle points.
 *
 * For example, given matrix A shown above, the function should return 2, as
 * explained in the example above.
 *
 * Assume that:
 * - N and M are integers within the range [1..500];
 * - each element of matrix A is an integer within the range
 *   [-2,147,483,648..2,147,483,647].
 *
 * In your solution, focus on correctness. The performance of your solution
 * will not be the focus of the assessment.
 */
public class Solution {

    // ==================== YOUR CODE ====================
    // Implement this method. Nothing else needs to change.

    public int solution(int[][] A) {

        // throw new UnsupportedOperationException("TODO: implement");

        // firstly, check if they are valid as they a smallest in the row 
        // and then we go vertically to see if they are valid to be in the vertical hashmap .

        // and then we loop through those one to see if they match or not. if yes count ++ 

/* 
         * For example, matrix A such that:
 *     A[0][0] = 0   A[0][1] = 1   A[0][2] = 9   A[0][3] = 3
 *     A[1][0] = 7   A[1][1] = 5   A[1][2] = 8   A[1][3] = 3
 *     A[2][0] = 9   A[2][1] = 2   A[2][2] = 9   A[2][3] = 4
 *     A[3][0] = 4   A[3][1] = 6   A[3][2] = 7   A[3][3] = 1
 * */
        int count= 0; 
        Map<String, Integer> rowValid = new HashMap<>();
        Map<String, Integer> collumnValid = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int[] cur = A[i];
            System.out.println(Arrays.toString(A[i]));

        }


        for (int i = 1; i < A.length; i++) {
        
            for (int j = 1; j < A[i].length-1; j++) {

                // System.out.println("current limit" + (A[i].length-1));
                // System.out.println("current location" + ("" + i + "," + j));
                // System.out.println("-----------------------------------------------------");
                // //
                int curr = A[i][j];
                int prev = A[i][j-1];
                int next = A[i][j+1];
                if (curr < prev && curr < next ) {
                    rowValid.put("" + i + "," + j, 0);
                }else if (curr > prev && curr > next) {
                    rowValid.put("" + i + "," + j, 1);

                }
            }
        }
        // [[1,2], [3,4]] -> a.length 
        for (int i = 0; i < A[0].length-1; i++) {
            for (int j = 1; j < A.length-1; j++) {
                int curr = A[j][i];
                int prev = A[j-1][i];
                int next = A[j+1][i];
                System.out.println("column: " + "" + i + "," + j + "has :");
                System.out.println("curr value: " + curr + ", prev value: " + prev + ", next value: " + next  );
                if (curr < prev && curr < next ) {
                    collumnValid.put("" + j + "," + i, 0);
                }else if (curr > prev && curr > next) {
                    collumnValid.put("" + j + "," + i, 1);

                }
            }
        }
        for(String key : rowValid.keySet()) {
            if (collumnValid.containsKey(key)) {
                System.out.println("matched" + key);
                System.out.println("value of row" + (rowValid.get(key) == 0 ? "min" : "max"));
                 System.out.println("value of collumn" + (collumnValid.get(key) == 0 ? "min" : "max"));
                if (collumnValid.get(key) != rowValid.get(key)) {
                    count++;
                    System.out.println("only count" + key);
                }
                System.out.println("------------------------------------------------------------------");
            }
        }
        return count;
        
    }
}
