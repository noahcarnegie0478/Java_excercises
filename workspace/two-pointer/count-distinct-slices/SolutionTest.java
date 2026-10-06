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

        total++; if (check(total, "official example: M=6, A={3,4,5,5,2}", 9, () -> sol.solution(6, new int[]{3,4,5,5,2}))) pass++;
        total++; if (check(total, "single element, N=1", 1, () -> sol.solution(0, new int[]{0}))) pass++;
        total++; if (check(total, "single element equal to M", 1, () -> sol.solution(5, new int[]{5}))) pass++;
        total++; if (check(total, "two distinct elements", 3, () -> sol.solution(1, new int[]{0,1}))) pass++;
        total++; if (check(total, "two identical elements, no distinct slice spans both", 2, () -> sol.solution(1, new int[]{1,1}))) pass++;
        total++; if (check(total, "all distinct, every slice is distinct", 15, () -> sol.solution(5, new int[]{1,2,3,4,5}))) pass++;
        total++; if (check(total, "all identical elements", 4, () -> sol.solution(1, new int[]{1,1,1,1}))) pass++;
        total++; if (check(total, "alternating zero/one pattern", 7, () -> sol.solution(1, new int[]{0,1,0,1}))) pass++;
        total++; if (check(total, "all zeros, M=0", 5, () -> sol.solution(0, new int[]{0,0,0,0,0}))) pass++;
        total++; if (check(total, "repeating pair pattern, window capped at size 2", 15, () -> sol.solution(2, new int[]{1,2,1,2,1,2,1,2}))) pass++;
        total++; if (check(total, "repeating run of four distinct values", 26, () -> sol.solution(4, new int[]{1,2,3,4,1,2,3,4}))) pass++;
        total++; if (check(total, "single duplicate in the middle", 11, () -> sol.solution(3, new int[]{1,2,3,2,1}))) pass++;
        total++; if (check(total, "large N, all distinct, result clamped at 1,000,000,000", 1000000000, () -> sol.solution(49999, range(50000)))) pass++;
        total++; if (check(total, "large N, all identical values (perf check)", 100000, () -> sol.solution(7, filled(100000, 7)))) pass++;
        total++; if (check(total, "run ending in a duplicate tail", 8, () -> sol.solution(3, new int[]{1,2,3,3,3}))) pass++;
        total++; if (check(total, "array not sorted, duplicate at both ends", 11, () -> sol.solution(3, new int[]{3,1,2,1,3}))) pass++;
        total++; if (check(total, "two elements at value boundaries 0 and M", 3, () -> sol.solution(100000, new int[]{0,100000}))) pass++;
        total++; if (check(total, "ten distinct values, all slices distinct", 55, () -> sol.solution(10, new int[]{0,1,2,3,4,5,6,7,8,9}))) pass++;
        total++; if (check(total, "duplicate pair at the start of the array", 16, () -> sol.solution(5, new int[]{5,5,1,2,3,4}))) pass++;
        total++; if (check(total, "duplicate pair at the end of the array", 16, () -> sol.solution(5, new int[]{1,2,3,4,5,5}))) pass++;
        total++; if (check(total, "M much larger than any value actually used", 3, () -> sol.solution(100000, new int[]{1,1,1}))) pass++;
        total++; if (check(total, "six distinct values in non-sorted order", 21, () -> sol.solution(6, new int[]{1,3,2,6,4,5}))) pass++;
        total++; if (check(total, "single element equal to maximum possible M", 1, () -> sol.solution(100000, new int[]{100000}))) pass++;
        total++; if (check(total, "three increasing values from 0 to M", 6, () -> sol.solution(2, new int[]{0,1,2}))) pass++;
        total++; if (check(total, "two elements equal to M", 2, () -> sol.solution(2, new int[]{2,2}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] range(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }

    private static int[] filled(int n, int v) {
        int[] a = new int[n];
        Arrays.fill(a, v);
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
