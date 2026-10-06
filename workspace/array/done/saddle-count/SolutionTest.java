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

        total++; if (check(total, "example matrix, two saddle points", 2, () -> sol.solution(new int[][]{
                {0, 1, 9, 3},
                {7, 5, 8, 3},
                {9, 2, 9, 4},
                {4, 6, 7, 1}
        }))) pass++;

        total++; if (check(total, "3x3, local min in row & local max in column", 1, () -> sol.solution(new int[][]{
                {5, -1, 5},
                {2, 0, 2},
                {5, -1, 5}
        }))) pass++;

        total++; if (check(total, "3x3, local max in row & local min in column", 1, () -> sol.solution(new int[][]{
                {0, 9, 0},
                {1, 5, 1},
                {0, 9, 0}
        }))) pass++;

        total++; if (check(total, "3x3, all elements identical (no strict extrema)", 0, () -> sol.solution(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        }))) pass++;

        total++; if (check(total, "1x1 matrix (N=M=1, no interior cell)", 0, () -> sol.solution(new int[][]{{5}}))) pass++;

        total++; if (check(total, "single row (N=1, no interior row)", 0, () -> sol.solution(new int[][]{
                {1, 2, 3, 4, 5}
        }))) pass++;

        total++; if (check(total, "single column (M=1, no interior column)", 0, () -> sol.solution(new int[][]{
                {1}, {2}, {3}, {4}, {5}
        }))) pass++;

        total++; if (check(total, "2x2 matrix (N=M=2, no interior cell)", 0, () -> sol.solution(new int[][]{
                {1, 2}, {3, 4}
        }))) pass++;

        total++; if (check(total, "2 rows, 5 columns (N=2, no interior row)", 0, () -> sol.solution(new int[][]{
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1}
        }))) pass++;

        total++; if (check(total, "5 rows, 2 columns (M=2, no interior column)", 0, () -> sol.solution(new int[][]{
                {1, 5}, {2, 4}, {3, 3}, {4, 2}, {5, 1}
        }))) pass++;

        total++; if (check(total, "5x5, two separate saddle points plus one extra from overlap", 3, () -> sol.solution(new int[][]{
                {100, 50, 100, 100, 100},
                {150, 100, 150, 100, 100},
                {100, 50, 100, 50, 100},
                {100, 100, 150, 100, 150},
                {100, 100, 100, 50, 100}
        }))) pass++;

        total++; if (check(total, "negative values, a valid saddle point", 1, () -> sol.solution(new int[][]{
                {0, -9, 0},
                {-1, -5, -1},
                {0, -9, 0}
        }))) pass++;

        total++; if (check(total, "all neighbors tied (no strict inequality, not a saddle)", 0, () -> sol.solution(new int[][]{
                {5, 5, 5},
                {5, 0, 5},
                {5, 5, 5}
        }))) pass++;

        total++; if (check(total, "Integer.MIN_VALUE / MAX_VALUE boundaries", 1, () -> sol.solution(new int[][]{
                {0, Integer.MAX_VALUE, 0},
                {Integer.MIN_VALUE, 0, Integer.MIN_VALUE},
                {0, Integer.MAX_VALUE, 0}
        }))) pass++;

        total++; if (check(total, "checkerboard pattern (no saddle points)", 0, () -> sol.solution(checkerboard(5, 5)))) pass++;

        total++; if (check(total, "non-square matrix, 4 rows x 6 columns, no saddle", 0, () -> sol.solution(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {2, 9, 1, 9, 1, 5},
                {3, 1, 9, 1, 9, 4},
                {4, 5, 6, 7, 8, 9}
        }))) pass++;

        total++; if (check(total, "non-square matrix, 6 rows x 4 columns, no saddle", 0, () -> sol.solution(new int[][]{
                {1, 2, 3, 4},
                {5, 9, 1, 6},
                {7, 1, 9, 8},
                {9, 9, 1, 1},
                {1, 1, 9, 9},
                {2, 3, 4, 5}
        }))) pass++;

        total++; if (check(total, "narrow matrix at N bound, 500 rows x 3 columns", 0, () -> sol.solution(narrow500x3()))) pass++;

        total++; if (check(total, "wide matrix at M bound, 3 rows x 500 columns", 0, () -> sol.solution(wide3x500()))) pass++;

        total++; if (check(total, "strictly monotonic matrix (no saddle points)", 0, () -> sol.solution(monotonic(5, 5)))) pass++;

        total++; if (check(total, "6x6 matrix, single saddle point in a sea of equal values", 1, () -> sol.solution(singleSaddleBig()))) pass++;

        total++; if (check(total, "5x5 alternating rows, multiple saddle points", 3, () -> sol.solution(new int[][]{
                {10, 20, 10, 20, 10},
                {5, 0, 5, 0, 5},
                {10, 20, 10, 20, 10},
                {5, 0, 5, 0, 5},
                {10, 20, 10, 20, 10}
        }))) pass++;

        total++; if (check(total, "saddle point at the last interior cell (bottom-right corner of interior)", 1, () -> sol.solution(new int[][]{
                {100, 100, 100, 100, 100},
                {100, 100, 100, 100, 100},
                {100, 100, 100, 50, 100},
                {100, 100, 150, 100, 150},
                {100, 100, 100, 50, 100}
        }))) pass++;

        total++; if (check(total, "row condition strict but column has a tied neighbor (not a saddle)", 0, () -> sol.solution(new int[][]{
                {0, 10, 0},
                {50, 10, 150},
                {0, 5, 0}
        }))) pass++;

        //check
        total++; if (check(total, "8x8 deterministic varied values, no saddle points", 0, () -> sol.solution(deterministic8x8()))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[][] checkerboard(int n, int m) {
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = ((i + j) % 2 == 0) ? 9 : 1;
        return a;
    }

    private static int[][] monotonic(int n, int m) {
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = i * m + j;
        return a;
    }

    private static int[][] narrow500x3() {
        int[][] a = new int[500][3];
        for (int i = 0; i < 500; i++) {
            a[i][0] = 100;
            a[i][1] = (i % 2 == 0) ? 200 : 0;
            a[i][2] = 100;
        }
        return a;
    }

    private static int[][] wide3x500() {
        int[][] a = new int[3][500];
        for (int j = 0; j < 500; j++) {
            a[0][j] = 100;
            a[1][j] = (j % 2 == 0) ? 200 : 0;
            a[2][j] = 100;
        }
        return a;
    }

    private static int[][] singleSaddleBig() {
        int[][] a = new int[6][6];
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                a[i][j] = 100;
        a[2][1] = 150;
        a[2][3] = 150;
        a[1][2] = 50;
        a[3][2] = 50;
        return a;
    }

    private static int[][] deterministic8x8() {
        int[][] a = new int[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                a[i][j] = ((i * 31 + j * 17) % 23) - 11;
        return a;
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
