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

        total++; if (check(total, "example: K=2, A=[3,5,7,6,3]", 9, () -> sol.solution(2, new int[]{3,5,7,6,3}))) pass++;
        total++; if (check(total, "N=1, K=0 (smallest possible input)", 1, () -> sol.solution(0, new int[]{5}))) pass++;
        total++; if (check(total, "N=1, K=max, element=min (boundary values)", 1, () -> sol.solution(1000000000, new int[]{-1000000000}))) pass++;
        total++; if (check(total, "all elements equal, K=0", 10, () -> sol.solution(0, new int[]{4,4,4,4}))) pass++;
        total++; if (check(total, "strictly increasing, K huge covers everything", 15, () -> sol.solution(1000000000, new int[]{1,2,3,4,5}))) pass++;
        total++; if (check(total, "strictly increasing, K=0 (only single-element slices)", 5, () -> sol.solution(0, new int[]{1,2,3,4,5}))) pass++;
        total++; if (check(total, "negative values mixed", 12, () -> sol.solution(4, new int[]{-5,-3,-1,0,2}))) pass++;
        total++; if (check(total, "duplicates mixed, K=0", 7, () -> sol.solution(0, new int[]{1,1,2,2,1}))) pass++;
        total++; if (check(total, "N=100000 all equal, result exceeds cap (perf + cap check)", 1000000000, () -> sol.solution(0, repeat(4, 100000)))) pass++;
        total++; if (check(total, "two elements, diff within K", 3, () -> sol.solution(1, new int[]{1,2}))) pass++;
        total++; if (check(total, "two elements, diff exceeds K", 2, () -> sol.solution(0, new int[]{1,2}))) pass++;
        total++; if (check(total, "strictly decreasing, K=1", 9, () -> sol.solution(1, new int[]{5,4,3,2,1}))) pass++;
        total++; if (check(total, "bounded run at the start, spike at the end", 9, () -> sol.solution(0, new int[]{1,1,1,100,200,300}))) pass++;
        total++; if (check(total, "spike at the start, bounded run at the end", 9, () -> sol.solution(0, new int[]{100,200,300,1,1,1}))) pass++;
        total++; if (check(total, "extreme min/max values, K=max", 5, () -> sol.solution(1000000000, new int[]{-1000000000,0,1000000000}))) pass++;
        total++; if (check(total, "extreme min/max values, K=0", 3, () -> sol.solution(0, new int[]{-1000000000,0,1000000000}))) pass++;
        total++; if (check(total, "zigzag pattern, K=1", 6, () -> sol.solution(1, new int[]{1,3,1,3,1,3}))) pass++;
        total++; if (check(total, "repeated up-down pattern, K=0", 7, () -> sol.solution(0, new int[]{1,2,3,2,1,2,3}))) pass++;
        total++; if (check(total, "all negative values", 9, () -> sol.solution(3, new int[]{-10,-8,-6,-4,-2}))) pass++;
        total++; if (check(total, "mixed positive/negative, K huge covers everything", 15, () -> sol.solution(1000000000, new int[]{-5,10,-3,7,0}))) pass++;
        total++; if (check(total, "plateau interrupted by a spike in the middle", 10, () -> sol.solution(2, new int[]{3,3,3,10,3,3}))) pass++;
        total++; if (check(total, "evenly spaced values, K equals the step", 5, () -> sol.solution(5, new int[]{0,10,20,30,40}))) pass++;
        total++; if (check(total, "three elements, K exactly equals max-min", 6, () -> sol.solution(3, new int[]{1,4,2}))) pass++;
        total++; if (check(total, "alternating two values, all slices bounded", 28, () -> sol.solution(1, new int[]{2,1,2,1,2,1,2}))) pass++;
        total++; if (check(total, "N=100000 strictly increasing, K huge (perf + cap check)", 1000000000, () -> sol.solution(1000000000, increasing(100000)))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] repeat(int value, int n) {
        int[] a = new int[n];
        Arrays.fill(a, value);
        return a;
    }

    private static int[] increasing(int n) {
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
