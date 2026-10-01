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

        total++; if (check(total, "example: [10,2,44,15,39,20]", 42, () -> sol.solution(new int[]{10, 2, 44, 15, 39, 20}))) pass++;
        total++; if (check(total, "single element [5] (N=1, smallest possible input)", 0, () -> sol.solution(new int[]{5}))) pass++;
        total++; if (check(total, "single element [0]", 0, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "single element at max bound [5000000]", 0, () -> sol.solution(new int[]{5000000}))) pass++;
        total++; if (check(total, "two elements increasing [1,2]", 1, () -> sol.solution(new int[]{1, 2}))) pass++;
        total++; if (check(total, "two elements decreasing [2,1]", 1, () -> sol.solution(new int[]{2, 1}))) pass++;
        total++; if (check(total, "two equal elements [7,7]", 0, () -> sol.solution(new int[]{7, 7}))) pass++;
        total++; if (check(total, "all elements identical [3,3,3,3,3]", 0, () -> sol.solution(new int[]{3, 3, 3, 3, 3}))) pass++;
        total++; if (check(total, "all zeros [0,0,0]", 0, () -> sol.solution(new int[]{0, 0, 0}))) pass++;
        total++; if (check(total, "min and max at the two extremes [0,5000000]", 5000000, () -> sol.solution(new int[]{0, 5000000}))) pass++;
        total++; if (check(total, "sorted ascending [1,2,3,4,5]", 4, () -> sol.solution(new int[]{1, 2, 3, 4, 5}))) pass++;
        total++; if (check(total, "sorted descending [5,4,3,2,1]", 4, () -> sol.solution(new int[]{5, 4, 3, 2, 1}))) pass++;
        total++; if (check(total, "max at start, min at end [100,50,25,10,1]", 99, () -> sol.solution(new int[]{100, 50, 25, 10, 1}))) pass++;
        total++; if (check(total, "min at start, max at end [1,10,25,50,100]", 99, () -> sol.solution(new int[]{1, 10, 25, 50, 100}))) pass++;
        total++; if (check(total, "max value in the middle [1,2,100,3,4]", 99, () -> sol.solution(new int[]{1, 2, 100, 3, 4}))) pass++;
        total++; if (check(total, "min value in the middle [100,99,0,98,97]", 100, () -> sol.solution(new int[]{100, 99, 0, 98, 97}))) pass++;
        total++; if (check(total, "duplicates with extremes mixed in [5,5,1,5,9,5]", 8, () -> sol.solution(new int[]{5, 5, 1, 5, 9, 5}))) pass++;
        total++; if (check(total, "scattered values [7,3,9,1,8,2]", 8, () -> sol.solution(new int[]{7, 3, 9, 1, 8, 2}))) pass++;
        total++; if (check(total, "min at start, max near end, zero present [0,1,2,3,4,5000000]", 5000000, () -> sol.solution(new int[]{0, 1, 2, 3, 4, 5000000}))) pass++;
        total++; if (check(total, "descending with duplicates [9,9,8,7,7,6,1,1]", 8, () -> sol.solution(new int[]{9, 9, 8, 7, 7, 6, 1, 1}))) pass++;
        total++; if (check(total, "max value repeated around a single min [5000000,0,5000000]", 5000000, () -> sol.solution(new int[]{5000000, 0, 5000000}))) pass++;
        total++; if (check(total, "both elements at max bound [5000000,5000000]", 0, () -> sol.solution(new int[]{5000000, 5000000}))) pass++;
        total++; if (check(total, "large ascending array, N=1000 (perf check)", 999, () -> sol.solution(ascending(1000)))) pass++;
        total++; if (check(total, "large descending array, N=1000 (perf check)", 999, () -> sol.solution(descending(1000)))) pass++;
        total++; if (check(total, "large array, N=1001, single spike in the middle (perf check)", 5000000, () -> sol.solution(spike(1001, 500, 5000000)))) pass++;

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

    private static int[] descending(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = n - 1 - i;
        return a;
    }

    private static int[] spike(int n, int spikeIndex, int spikeValue) {
        int[] a = new int[n];
        a[spikeIndex] = spikeValue;
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
