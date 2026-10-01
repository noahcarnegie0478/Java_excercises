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

        total++; if (check(total, "example: A=[2,1,5,-6,9]", 4, () -> sol.solution(new int[]{2, 1, 5, -6, 9}))) pass++;
        total++; if (check(total, "N=0 (empty array, smallest N)", 0, () -> sol.solution(new int[]{}))) pass++;
        total++; if (check(total, "N=1 (single element, no pair possible)", 0, () -> sol.solution(new int[]{5}))) pass++;
        total++; if (check(total, "N=2, same parity (both even)", 1, () -> sol.solution(new int[]{2, 4}))) pass++;
        total++; if (check(total, "N=2, different parity", 0, () -> sol.solution(new int[]{2, 3}))) pass++;
        total++; if (check(total, "all odd, all negative", 3, () -> sol.solution(new int[]{-1, -3, -5}))) pass++;
        total++; if (check(total, "zero mixed with positive evens", 3, () -> sol.solution(new int[]{0, 2, 4}))) pass++;
        total++; if (check(total, "negative/zero/positive mixed parity", 2, () -> sol.solution(new int[]{0, -1, 2, -3}))) pass++;
        total++; if (check(total, "all elements identical (odd)", 10, () -> sol.solution(new int[]{7, 7, 7, 7, 7}))) pass++;
        total++; if (check(total, "distinct elements, all same parity (even)", 10, () -> sol.solution(new int[]{2, 4, 6, 8, 10}))) pass++;
        // total++; if (check(total, "N=50,000 all same parity -> exceeds 1e9, returns -1", -1, () -> sol.solution(filled(50000, 2)))) pass++;
        // total++; if (check(total, "N=44,721 all same parity -> right at the allowed boundary", 999961560, () -> sol.solution(filled(44721, 2)))) pass++;
        // total++; if (check(total, "N=44,722 all same parity -> just over 1e9, returns -1", -1, () -> sol.solution(filled(44722, 2)))) pass++;
        total++; if (check(total, "extreme min/max values, mixed parity", 2, () -> sol.solution(new int[]{1000000000, -1000000000, 999999999, -999999999}))) pass++;
        total++; if (check(total, "sorted ascending, all odd", 15, () -> sol.solution(new int[]{-5, -3, -1, 1, 3, 5}))) pass++;
        total++; if (check(total, "sorted descending, mixed parity", 10, () -> sol.solution(new int[]{9, 7, 5, 3, 1, 0}))) pass++;
        total++; if (check(total, "single matching pair at the start", 1, () -> sol.solution(new int[]{2, 4, 1}))) pass++;
        total++; if (check(total, "matching pair sits in the middle", 2, () -> sol.solution(new int[]{1, 2, 4, 3}))) pass++;
        total++; if (check(total, "matching pair sits at the end", 4, () -> sol.solution(new int[]{1, 3, 5, 2, 4}))) pass++;
        total++; if (check(total, "all zeros (duplicate boundary value)", 45, () -> sol.solution(filled(10, 0)))) pass++;
        total++; if (check(total, "N=2, both at extreme even boundary", 1, () -> sol.solution(new int[]{-1000000000, 1000000000}))) pass++;
        total++; if (check(total, "N=2, extreme values, different parity", 0, () -> sol.solution(new int[]{-1000000000, 999999999}))) pass++;
        // total++; if (check(total, "N=50,000 alternating parity (perf check, under limit)", 624975000, () -> sol.solution(alternating(50000, 1, 2)))) pass++;
         total++; if (check(total, "distinct negative evens", 6, () -> sol.solution(new int[]{-2, -4, -6, -8}))) pass++;
        total++; if (check(total, "N=7, mixed sign, uneven odd/even split", 9, () -> sol.solution(new int[]{3, -2, 5, 4, -7, 0, 8}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] filled(int n, int value) {
        int[] a = new int[n];
        Arrays.fill(a, value);
        return a;
    }

    private static int[] alternating(int n, int v1, int v2) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = (i % 2 == 0) ? v1 : v2;
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
