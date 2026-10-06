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

        total++; if (check(total, "example 1: SUMMER has the highest amplitude", "SUMMER", () -> sol.solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3}))) pass++;
        total++; if (check(total, "example 2: AUTUMN has the highest amplitude", "AUTUMN", () -> sol.solution(new int[]{2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18}))) pass++;
        total++; if (check(total, "smallest N=8, WINTER wins", "WINTER", () -> sol.solution(new int[]{0, 100, 1, 2, 3, 5, 6, 9}))) pass++;
        total++; if (check(total, "smallest N=8, SPRING wins", "SPRING", () -> sol.solution(new int[]{1, 2, 0, 200, 3, 5, 7, 10}))) pass++;
        total++; if (check(total, "smallest N=8, SUMMER wins", "SUMMER", () -> sol.solution(new int[]{1, 2, 3, 5, 0, 500, 6, 9}))) pass++;
        total++; if (check(total, "smallest N=8, AUTUMN wins", "AUTUMN", () -> sol.solution(new int[]{1, 2, 3, 5, 6, 9, 0, 300}))) pass++;
        total++; if (check(total, "negative values, WINTER wins", "WINTER", () -> sol.solution(new int[]{-100, -1, -2, -4, -5, -9, -10, -13}))) pass++;
        total++; if (check(total, "negative values, SUMMER wins", "SUMMER", () -> sol.solution(new int[]{-5, -6, -7, -9, -100, 0, -9, -13}))) pass++;
        total++; if (check(total, "boundary extreme values [-1000,1000], WINTER wins", "WINTER", () -> sol.solution(new int[]{-1000, 1000, 0, 1, 2, 4, 5, 8}))) pass++;
        total++; if (check(total, "boundary extreme values [-1000,1000], AUTUMN wins", "AUTUMN", () -> sol.solution(new int[]{1, 2, 3, 5, 6, 9, -1000, 1000}))) pass++;
        total++; if (check(total, "N=16, plateau winter/summer/autumn, SPRING wins", "SPRING", () -> sol.solution(new int[]{5, 5, 5, 5, 1, 2, 3, 100, 10, 20, 10, 20, 0, 0, 0, 1}))) pass++;
        total++; if (check(total, "N=16, WINTER wins by a huge margin", "WINTER", () -> sol.solution(new int[]{100, -100, 0, 50, 1, 2, 3, 4, 1, 2, 3, 5, 1, 2, 3, 6}))) pass++;
        total++; if (check(total, "N=16, AUTUMN wins with a negative spike", "AUTUMN", () -> sol.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 9, 9, 10, 11, 14, -50, 20, 0, 30}))) pass++;
        total++; if (check(total, "N=16, SUMMER wins with mixed sign spike", "SUMMER", () -> sol.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 9, -30, 40, -10, 0, 9, 10, 11, 14}))) pass++;
        total++; if (check(total, "N=20, WINTER wins, quarter size 5", "WINTER", () -> sol.solution(new int[]{-1000, 1000, 0, 1, 2, 1, 2, 3, 4, 5, 1, 2, 3, 4, 6, 1, 2, 3, 4, 7}))) pass++;
        total++; if (check(total, "N=12, WINTER wins with spike in the middle of the quarter", "WINTER", () -> sol.solution(new int[]{1, 1000, -1000, 1, 2, 3, 1, 2, 4, 1, 2, 5}))) pass++;
        total++; if (check(total, "N=12, SPRING wins with descending extremes (max before min)", "SPRING", () -> sol.solution(new int[]{1, 2, 3, 1000, -1000, 500, 1, 2, 4, 1, 2, 5}))) pass++;
        total++; if (check(total, "N=8, one season has zero amplitude, AUTUMN still wins", "AUTUMN", () -> sol.solution(new int[]{0, 1, 5, 5, 2, 5, 1, 5}))) pass++;
        total++; if (check(total, "large N=200 (quarter=50), WINTER wins (perf check)", "WINTER", () -> sol.solution(join(quarter(50, -1000, 1000), quarter(50, 0, 10), quarter(50, 0, 20), quarter(50, 0, 30))))) pass++;
        total++; if (check(total, "large N=200 (quarter=50), SUMMER wins (perf check)", "SUMMER", () -> sol.solution(join(quarter(50, 0, 5), quarter(50, 0, 6), quarter(50, -1000, 1000), quarter(50, 0, 7))))) pass++;
        total++; if (check(total, "large N=200 (quarter=50), AUTUMN wins (perf check)", "AUTUMN", () -> sol.solution(join(quarter(50, 0, 5), quarter(50, 0, 6), quarter(50, 0, 7), quarter(50, -1000, 1000))))) pass++;
        total++; if (check(total, "N=20, SPRING wins, quarter size 5", "SPRING", () -> sol.solution(new int[]{1, 2, 3, 4, 5, 1000, -1000, 0, 5, -5, 1, 2, 3, 4, 6, 1, 2, 3, 4, 7}))) pass++;
        total++; if (check(total, "N=20, SUMMER wins, quarter size 5", "SUMMER", () -> sol.solution(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 6, 1000, -1000, 500, 0, 10, 1, 2, 3, 4, 7}))) pass++;
        total++; if (check(total, "N=20, AUTUMN wins, quarter size 5", "AUTUMN", () -> sol.solution(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 6, 1, 2, 3, 4, 7, -1000, 1000, 0, 0, 0}))) pass++;
        total++; if (check(total, "all four quarters share the same single value except one spike, SUMMER wins", "SUMMER", () -> sol.solution(new int[]{0, 0, 1, 0, 0, 2, -1000, 1000, 0, 3, 0, 0}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] quarter(int size, int lo, int hi) {
        int[] a = new int[size];
        Arrays.fill(a, lo);
        a[size - 1] = hi;
        return a;
    }

    private static int[] join(int[]... qs) {
        int total = 0;
        for (int[] q : qs) total += q.length;
        int[] result = new int[total];
        int pos = 0;
        for (int[] q : qs) {
            System.arraycopy(q, 0, result, pos, q.length);
            pos += q.length;
        }
        return result;
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
