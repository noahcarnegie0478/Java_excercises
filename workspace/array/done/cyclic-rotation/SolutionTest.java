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

        total++; if (check(total, "example 1: [3,8,9,7,6], K=3", new int[]{9, 7, 6, 3, 8}, () -> sol.solution(new int[]{3, 8, 9, 7, 6}, 3))) pass++;
        total++; if (check(total, "example 2: [0,0,0], K=1", new int[]{0, 0, 0}, () -> sol.solution(new int[]{0, 0, 0}, 1))) pass++;
        total++; if (check(total, "example 3: [1,2,3,4], K=4 (K==N, full rotation)", new int[]{1, 2, 3, 4}, () -> sol.solution(new int[]{1, 2, 3, 4}, 4))) pass++;
        total++; if (check(total, "empty array, K=0 (N=0, smallest possible input)", new int[]{}, () -> sol.solution(new int[]{}, 0))) pass++;
        total++; if (check(total, "empty array, K=5 (K ignored when N=0)", new int[]{}, () -> sol.solution(new int[]{}, 5))) pass++;
        total++; if (check(total, "K=0 (no rotation)", new int[]{1, 2, 3}, () -> sol.solution(new int[]{1, 2, 3}, 0))) pass++;
        total++; if (check(total, "single element, K=0 (N=1)", new int[]{5}, () -> sol.solution(new int[]{5}, 0))) pass++;
        total++; if (check(total, "single element, K=50 (N=1, any K keeps it the same)", new int[]{5}, () -> sol.solution(new int[]{5}, 50))) pass++;
        total++; if (check(total, "K equals N (full rotation back to original)", new int[]{1, 2, 3}, () -> sol.solution(new int[]{1, 2, 3}, 3))) pass++;
        total++; if (check(total, "K greater than N", new int[]{3, 1, 2}, () -> sol.solution(new int[]{1, 2, 3}, 7))) pass++;
        total++; if (check(total, "K=100 at max bound, N=2 (K%N=0)", new int[]{1, 2}, () -> sol.solution(new int[]{1, 2}, 100))) pass++;
        total++; if (check(total, "K=1 on a 5-element array", new int[]{5, 1, 2, 3, 4}, () -> sol.solution(new int[]{1, 2, 3, 4, 5}, 1))) pass++;
        total++; if (check(total, "K=N-1", new int[]{2, 3, 4, 5, 1}, () -> sol.solution(new int[]{1, 2, 3, 4, 5}, 4))) pass++;
        total++; if (check(total, "negative values", new int[]{-3, -1, -2}, () -> sol.solution(new int[]{-1, -2, -3}, 1))) pass++;
        total++; if (check(total, "mixed sign values", new int[]{5, 10, -5, 0}, () -> sol.solution(new int[]{-5, 0, 5, 10}, 2))) pass++;
        total++; if (check(total, "all elements identical", new int[]{7, 7, 7, 7}, () -> sol.solution(new int[]{7, 7, 7, 7}, 2))) pass++;
        total++; if (check(total, "elements at the value bounds [-1000,1000]", new int[]{1000, -1000}, () -> sol.solution(new int[]{-1000, 1000}, 1))) pass++;
        total++; if (check(total, "two elements, K=2 (full cycle back to original)", new int[]{1, 2}, () -> sol.solution(new int[]{1, 2}, 2))) pass++;
        total++; if (check(total, "three elements, K=1", new int[]{3, 1, 2}, () -> sol.solution(new int[]{1, 2, 3}, 1))) pass++;
        total++; if (check(total, "descending input, K=2", new int[]{2, 1, 5, 4, 3}, () -> sol.solution(new int[]{5, 4, 3, 2, 1}, 2))) pass++;
        total++; if (check(total, "K=100 at max bound, N=1", new int[]{9}, () -> sol.solution(new int[]{9}, 100))) pass++;
        total++; if (check(total, "all zeros, larger array", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, () -> sol.solution(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 5))) pass++;
        total++; if (check(total, "K=2 on a 5-element array", new int[]{40, 50, 10, 20, 30}, () -> sol.solution(new int[]{10, 20, 30, 40, 50}, 2))) pass++;
        total++; if (check(total, "values spanning the full bound range, K=3", new int[]{0, 500, 1000, -1000, -500}, () -> sol.solution(new int[]{-1000, -500, 0, 500, 1000}, 3))) pass++;
        total++; if (check(total, "large array, N=100, K=1 (perf check)", expectedLargeK1(), () -> sol.solution(ascending(100), 1))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] ascending(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }

    private static int[] expectedLargeK1() {
        int[] a = new int[100];
        a[0] = 99;
        for (int i = 1; i < 100; i++) a[i] = i - 1;
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
