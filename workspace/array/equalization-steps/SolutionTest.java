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

        total++; if (check(total, "example: [11,3,7,1]", 5, () -> sol.solution(new int[]{11, 3, 7, 1}))) pass++;
        total++; if (check(total, "empty array (N=0)", 0, () -> sol.solution(new int[]{}))) pass++;
        total++; if (check(total, "single element (N=1, smallest possible input)", 0, () -> sol.solution(new int[]{5}))) pass++;
        total++; if (check(total, "already all equal", 0, () -> sol.solution(new int[]{4, 4, 4, 4}))) pass++;
        total++; if (check(total, "two elements, difference 2", 1, () -> sol.solution(new int[]{0, 2}))) pass++;
        total++; if (check(total, "two elements, difference 4", 2, () -> sol.solution(new int[]{0, 4}))) pass++;
        total++; if (check(total, "mixed parity: impossible", -1, () -> sol.solution(new int[]{1, 2}))) pass++;
        total++; if (check(total, "mixed parity among several equal elements: impossible", -1, () -> sol.solution(new int[]{3, 3, 3, 4}))) pass++;
        total++; if (check(total, "all odd values", 4, () -> sol.solution(new int[]{1, 3, 5, 7, 9}))) pass++;
        total++; if (check(total, "all even values", 4, () -> sol.solution(new int[]{2, 4, 6, 8, 10}))) pass++;
        total++; if (check(total, "all even including zero", 0, () -> sol.solution(new int[]{0, 0, 0}))) pass++;
        total++; if (check(total, "negative values, same parity", 2, () -> sol.solution(new int[]{-2, -4, -6}))) pass++;
        total++; if (check(total, "negative values, mixed parity: impossible", -1, () -> sol.solution(new int[]{-1, -2}))) pass++;
        total++; if (check(total, "negative and positive, even", 10, () -> sol.solution(new int[]{-10, 10}))) pass++;
        total++; if (check(total, "negative and positive, odd", 11, () -> sol.solution(new int[]{-11, 11}))) pass++;
        total++; if (check(total, "large spread, even, near value bounds", 200000000, () -> sol.solution(new int[]{-200000000, 200000000}))) pass++;
        total++; if (check(total, "large spread, odd, near value bounds", 199999999, () -> sol.solution(new int[]{-199999999, 199999999}))) pass++;
        total++; if (check(total, "single negative element", 0, () -> sol.solution(new int[]{-7}))) pass++;
        total++; if (check(total, "single zero element", 0, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "duplicates with a spread value", 4, () -> sol.solution(new int[]{5, 5, 5, 9, 9, 1}))) pass++;
        total++; if (check(total, "three distinct values, same parity", 9, () -> sol.solution(new int[]{2, 8, 20}))) pass++;
        total++; if (check(total, "large array at N bound, all equal (perf check)", 0, () -> sol.solution(allSame(20000, 7)))) pass++;
        total++; if (check(total, "large array at N bound, mixed parity (perf check)", -1, () -> sol.solution(ascending(20000)))) pass++;
        total++; if (check(total, "two close odd values", 1, () -> sol.solution(new int[]{7, 9}))) pass++;
        total++; if (check(total, "sorted ascending, all odd", 5, () -> sol.solution(new int[]{1, 3, 5, 7, 9, 11}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] allSame(int n, int val) {
        int[] a = new int[n];
        Arrays.fill(a, val);
        return a;
    }

    private static int[] ascending(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
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
