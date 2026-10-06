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

        total++; if (check(total, "example: [1,2,3,42,1,-7]", 42, () -> sol.solution(new int[]{1, 2, 3, 42, 1, -7}))) pass++;
        total++; if (check(total, "single element (N=1 smallest)", 5, () -> sol.solution(new int[]{5}))) pass++;
        total++; if (check(total, "single negative element", -5, () -> sol.solution(new int[]{-5}))) pass++;
        total++; if (check(total, "single zero element", 0, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "all zeros", 0, () -> sol.solution(new int[]{0, 0, 0, 0}))) pass++;
        total++; if (check(total, "two elements, positive", 7, () -> sol.solution(new int[]{3, 4}))) pass++;
        total++; if (check(total, "two elements, cancel out", 0, () -> sol.solution(new int[]{5, -5}))) pass++;
        total++; if (check(total, "all negative values", -15, () -> sol.solution(new int[]{-1, -2, -3, -4, -5}))) pass++;
        total++; if (check(total, "mixed positive and negative", 3, () -> sol.solution(new int[]{10, -7, 5, -5}))) pass++;
        total++; if (check(total, "duplicates", 12, () -> sol.solution(new int[]{4, 4, 4}))) pass++;
        total++; if (check(total, "sorted ascending", 15, () -> sol.solution(new int[]{1, 2, 3, 4, 5}))) pass++;
        total++; if (check(total, "sorted descending", 15, () -> sol.solution(new int[]{5, 4, 3, 2, 1}))) pass++;
        total++; if (check(total, "max boundary value single element", 10000, () -> sol.solution(new int[]{10000}))) pass++;
        total++; if (check(total, "min boundary value single element", -10000, () -> sol.solution(new int[]{-10000}))) pass++;
        total++; if (check(total, "max and min boundary together", 0, () -> sol.solution(new int[]{10000, -10000}))) pass++;
        total++; if (check(total, "many boundary max values", 30000, () -> sol.solution(new int[]{10000, 10000, 10000}))) pass++;
        total++; if (check(total, "many boundary min values", -30000, () -> sol.solution(new int[]{-10000, -10000, -10000}))) pass++;
        total++; if (check(total, "answer influenced by first element", 100, () -> sol.solution(new int[]{100, 0, 0, 0}))) pass++;
        total++; if (check(total, "answer influenced by last element", 100, () -> sol.solution(new int[]{0, 0, 0, 100}))) pass++;
        total++; if (check(total, "answer influenced by middle element", 100, () -> sol.solution(new int[]{0, 100, 0}))) pass++;
        total++; if (check(total, "alternating signs", 3, () -> sol.solution(new int[]{1, -2, 3, -4, 5}))) pass++;
        total++; if (check(total, "large array, all ones (perf check)", 100000, () -> sol.solution(ones(100000)))) pass++;
        total++; if (check(total, "large array, all boundary max (perf check)", 1000000000, () -> sol.solution(allSame(100000, 10000)))) pass++;
        total++; if (check(total, "large array, all boundary min (perf check)", -1000000000, () -> sol.solution(allSame(100000, -10000)))) pass++;
        total++; if (check(total, "small sequential spread", 9, () -> sol.solution(new int[]{2, 3, 4}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] ones(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 1);
        return a;
    }

    private static int[] allSame(int n, int val) {
        int[] a = new int[n];
        Arrays.fill(a, val);
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
