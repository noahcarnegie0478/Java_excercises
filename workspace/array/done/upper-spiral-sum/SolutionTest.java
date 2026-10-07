import java.util.*;

/**
 * TEST RUNNER for Solution.java — no need to edit this file.
 * Run it via the "Run" CodeLens above main() in VS Code; the Java extension
 * automatically compiles Solution.java from the same folder alongside this file.
 */
public class SolutionTest {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int pass = 0, total = 0;

        int[][] official = {
            {5,3,8,9,4,1,3,-2},
            {4,6,0,3,6,4,2,1},
            {4,-5,3,1,9,5,6,6},
            {3,7,5,3,2,8,9,4},
            {5,3,-3,6,3,2,8,0},
            {5,7,5,3,3,-9,2,2},
            {0,4,3,2,5,7,5,4}
        };
        total++; if (check(total, "official example 7x8", 91, () -> sol.solution(official))) pass++;
        total++; if (check(total, "1x1 single positive", 5, () -> sol.solution(new int[][]{{5}}))) pass++;
        total++; if (check(total, "1x1 single negative", -7, () -> sol.solution(new int[][]{{-7}}))) pass++;
        total++; if (check(total, "1x1 zero", 0, () -> sol.solution(new int[][]{{0}}))) pass++;
        total++; if (check(total, "1x1 large positive, out of range", -1, () -> sol.solution(new int[][]{{2000000000}}))) pass++;
        total++; if (check(total, "1x1 large negative, out of range", -1, () -> sol.solution(new int[][]{{-2000000000}}))) pass++;
        total++; if (check(total, "1 row x 5 cols (N=1, whole row is upper spiral)", 15, () -> sol.solution(new int[][]{{1,2,3,4,5}}))) pass++;
        total++; if (check(total, "1 row, all negative", -6, () -> sol.solution(new int[][]{{-1,-2,-3}}))) pass++;
        total++; if (check(total, "5 rows x 1 col (M=1, multiple rotations)", 10, () -> sol.solution(new int[][]{{1},{2},{3},{4},{5}}))) pass++;
        total++; if (check(total, "2x2 minimal rectangle", 3, () -> sol.solution(new int[][]{{1,2},{3,4}}))) pass++;
        total++; if (check(total, "2x2 positive/negative mix cancels out", 0, () -> sol.solution(new int[][]{{-5,5},{10,-10}}))) pass++;
        total++; if (check(total, "3x3 increasing values", 17, () -> sol.solution(new int[][]{{1,2,3},{4,5,6},{7,8,9}}))) pass++;
        total++; if (check(total, "3x3 all identical elements", 10, () -> sol.solution(new int[][]{{2,2,2},{2,2,2},{2,2,2}}))) pass++;
        total++; if (check(total, "4x4 increasing values, multiple rotations", 51, () -> sol.solution(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}))) pass++;
        total++; if (check(total, "4x4 all zeros", 0, () -> sol.solution(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}))) pass++;
        total++; if (check(total, "3 rows x 5 cols (wide rectangle)", 49, () -> sol.solution(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}}))) pass++;
        total++; if (check(total, "5 rows x 3 cols (tall rectangle)", 52, () -> sol.solution(new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}}))) pass++;
        total++; if (check(total, "6x6 mixed positive/negative, several rotations", 116, () -> sol.solution(new int[][]{
            {1,2,3,4,5,6},
            {7,-8,9,-10,11,-12},
            {13,14,-15,16,-17,18},
            {-19,20,21,-22,23,24},
            {25,-26,27,28,-29,30},
            {31,32,33,34,35,-36}
        }))) pass++;
        total++; if (check(total, "2 rows x 5 cols, only top row counts", 5, () -> sol.solution(new int[][]{{1,1,1,1,1},{2,2,2,2,2}}))) pass++;
        total++; if (check(total, "5 rows x 2 cols", 21, () -> sol.solution(new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}}))) pass++;
        total++; if (check(total, "1x1 exactly at upper boundary 100,000,000", 100000000, () -> sol.solution(new int[][]{{100000000}}))) pass++;
        total++; if (check(total, "1x1 exactly at lower boundary -100,000,000", -100000000, () -> sol.solution(new int[][]{{-100000000}}))) pass++;
        total++; if (check(total, "1x1 just above upper boundary, out of range", -1, () -> sol.solution(new int[][]{{100000001}}))) pass++;
        total++; if (check(total, "1x1 just below lower boundary, out of range", -1, () -> sol.solution(new int[][]{{-100000001}}))) pass++;
        total++; if (check(total, "4x3 mixed positive/negative rectangle", 14, () -> sol.solution(new int[][]{{3,-2,7},{1,5,-4},{-6,2,8},{9,-1,0}}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private interface Supplier { Object get() throws Throwable; }

    private static boolean check(int idx, String desc, Object expected, Supplier actual) {
        try {
            Object a = actual.get();
            boolean ok = Objects.deepEquals(expected, a);
            System.out.printf("[%2d] %-4s %-65s expected=%-6s actual=%s%n",
                    idx, ok ? "PASS" : "FAIL", desc, fmt(expected), fmt(a));
            return ok;
        } catch (Throwable t) {
            System.out.printf("[%2d] %-4s %-65s expected=%-6s actual=THROWN %s: %s%n",
                    idx, "ERR", desc, fmt(expected), t.getClass().getSimpleName(), t.getMessage());
            return false;
        }
    }

    private static String fmt(Object o) {
        if (o == null) return "null";
        if (o instanceof int[]) return Arrays.toString((int[]) o);
        if (o instanceof long[]) return Arrays.toString((long[]) o);
        if (o instanceof double[]) return Arrays.toString((double[]) o);
        if (o instanceof boolean[]) return Arrays.toString((boolean[]) o);
        if (o instanceof char[]) return Arrays.toString((char[]) o);
        if (o instanceof Object[]) return Arrays.deepToString((Object[]) o);
        return String.valueOf(o);
    }
}
