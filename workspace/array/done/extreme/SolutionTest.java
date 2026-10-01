import java.util.*;

/**
 * TEST RUNNER for Solution.java — no need to edit this file.
 * Run it via the "Run" CodeLens above main() in VS Code; the Java extension
 * automatically compiles Solution.java from the same folder alongside this file.
 *
 * Note: every test array below is built so that exactly one element has the
 * maximal deviation, so there is exactly one correct expected index.
 */
public class SolutionTest {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int pass = 0, total = 0;

        total++; if (check(total, "example: [9,4,-3,-10], extreme is -10", 3, () -> sol.solution(new int[]{9, 4, -3, -10}))) pass++;
        total++; if (check(total, "empty array (N=0)", -1, () -> sol.solution(new int[]{}))) pass++;
        total++; if (check(total, "single positive element [42] (N=1)", 0, () -> sol.solution(new int[]{42}))) pass++;
        total++; if (check(total, "single negative element [-100] (N=1)", 0, () -> sol.solution(new int[]{-100}))) pass++;
        total++; if (check(total, "single zero element [0] (N=1)", 0, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "extreme at the end [1,2,3,100]", 3, () -> sol.solution(new int[]{1, 2, 3, 100}))) pass++;
        total++; if (check(total, "extreme at the start [100,1,2,3]", 0, () -> sol.solution(new int[]{100, 1, 2, 3}))) pass++;
        total++; if (check(total, "extreme in the middle [1,100,2,3]", 1, () -> sol.solution(new int[]{1, 100, 2, 3}))) pass++;
        total++; if (check(total, "extreme in the middle, different position [1,2,100,3]", 2, () -> sol.solution(new int[]{1, 2, 100, 3}))) pass++;
        total++; if (check(total, "negative extreme at the start [-50,1,2,3]", 0, () -> sol.solution(new int[]{-50, 1, 2, 3}))) pass++;
        total++; if (check(total, "negative extreme mixed with positives [5,5,5,-100]", 3, () -> sol.solution(new int[]{5, 5, 5, -100}))) pass++;
        total++; if (check(total, "negative extreme at the start, positives after [-100,5,5,5]", 0, () -> sol.solution(new int[]{-100, 5, 5, 5}))) pass++;
        total++; if (check(total, "large positive extreme among small values", 0, () -> sol.solution(new int[]{1000000, 1, 1, 1}))) pass++;
        total++; if (check(total, "large negative extreme among small values", 3, () -> sol.solution(new int[]{1, 1, 1, -1000000}))) pass++;
        total++; if (check(total, "extreme at Integer.MAX_VALUE boundary", 0, () -> sol.solution(new int[]{2147483647, 0, 0, 0}))) pass++;
        total++; if (check(total, "extreme at Integer.MIN_VALUE boundary", 0, () -> sol.solution(new int[]{-2147483648, 0, 0, 0}))) pass++;
        total++; if (check(total, "scattered values [3,1,4,1,5,9,2,6]", 5, () -> sol.solution(new int[]{3, 1, 4, 1, 5, 9, 2, 6}))) pass++;
        total++; if (check(total, "extreme at the end of a 5-element array", 4, () -> sol.solution(new int[]{10, 20, 30, 40, 1000}))) pass++;
        total++; if (check(total, "extreme at the start of a 5-element array", 0, () -> sol.solution(new int[]{1000, 10, 20, 30, 40}))) pass++;
        total++; if (check(total, "negative values with one far positive outlier", 3, () -> sol.solution(new int[]{-5, -10, -15, 100}))) pass++;
        total++; if (check(total, "large array, spike near the end (perf check)", 100, () -> sol.solution(ascendingThenSpike(100, 100000)))) pass++;
        total++; if (check(total, "large array, spike at the start (perf check)", 0, () -> sol.solution(spikeThenAscending(100000, 100)))) pass++;
        total++; if (check(total, "large array, N=1001, spike in the middle (perf check)", 500, () -> sol.solution(zerosWithSpike(1001, 500, 1000000)))) pass++;
        total++; if (check(total, "all negative values, extreme near the middle", 2, () -> sol.solution(new int[]{-10, -20, -30, -5}))) pass++;
        total++; if (check(total, "repeated values with a single far outlier at the end", 4, () -> sol.solution(new int[]{7, 7, 7, 7, 50}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] ascendingThenSpike(int count, int spikeValue) {
        int[] a = new int[count + 1];
        for (int i = 0; i < count; i++) a[i] = i;
        a[count] = spikeValue;
        return a;
    }

    private static int[] spikeThenAscending(int spikeValue, int count) {
        int[] a = new int[count + 1];
        a[0] = spikeValue;
        for (int i = 0; i < count; i++) a[i + 1] = i + 1;
        return a;
    }

    private static int[] zerosWithSpike(int size, int spikeIndex, int spikeValue) {
        int[] a = new int[size];
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
