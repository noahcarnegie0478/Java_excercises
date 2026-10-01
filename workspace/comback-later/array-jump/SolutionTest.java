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

        total++; if (check(total, "example 1: A=[2,3,-1,1,3] (jumps out after 4 hops)", 4, () -> sol.solution(new int[]{2,3,-1,1,3}))) pass++;
        total++; if (check(total, "example 2: A=[1,1,-1,1] (loops between 0 and 1 forever)", -1, () -> sol.solution(new int[]{1,1,-1,1}))) pass++;
        total++; if (check(total, "N=1, single positive jump exits immediately", 1, () -> sol.solution(new int[]{1}))) pass++;
        total++; if (check(total, "N=1, self-loop (offset 0) never exits", -1, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "N=3, negative offset exits below index 0 on first jump", 1, () -> sol.solution(new int[]{-5,0,0}))) pass++;
        total++; if (check(total, "N=3, offset lands exactly at index N (upper boundary)", 1, () -> sol.solution(new int[]{3,0,0}))) pass++;
        total++; if (check(total, "N=4, chain of 2 hops before a large jump exits", 3, () -> sol.solution(new int[]{1,2,-1,100}))) pass++;
        total++; if (check(total, "N=5, path loops back to index 0 after 3 distinct hops", -1, () -> sol.solution(new int[]{1,1,1,-3,0}))) pass++;
        total++; if (check(total, "N=3, hops from index 0 straight to index 2, then out", 2, () -> sol.solution(new int[]{2,0,5}))) pass++;
        total++; if (check(total, "N=4, negative offset at the head exits immediately", 1, () -> sol.solution(new int[]{-1,0,0,0}))) pass++;
        total++; if (check(total, "N=4, two-node cycle including index 0", -1, () -> sol.solution(new int[]{3,0,0,-3}))) pass++;
        total++; if (check(total, "N=10, chain hops through every index then exits (perf)", 10, () -> sol.solution(chainThenExit(10, 100)))) pass++;
        total++; if (check(total, "N=100,000 (max N), chain hops through every index then exits (perf)", 100000, () -> sol.solution(chainThenExit(100000, 100000)))) pass++;
        total++; if (check(total, "N=100,000 (max N), self-loop at index 0 (perf, immediate loop)", -1, () -> sol.solution(new int[100000]))) pass++;
        total++; if (check(total, "N=1, extreme negative offset (-1,000,000) exits immediately", 1, () -> sol.solution(new int[]{-1000000}))) pass++;
        total++; if (check(total, "N=1, extreme positive offset (1,000,000) exits immediately", 1, () -> sol.solution(new int[]{1000000}))) pass++;
        total++; if (check(total, "N=6, chain visits every index, then loops back to index 0", -1, () -> sol.solution(new int[]{1,1,1,1,1,-5}))) pass++;
        total++; if (check(total, "N=6, zigzag of forward/backward hops before exiting", 3, () -> sol.solution(new int[]{2,100,-1,2,-10,0}))) pass++;
        total++; if (check(total, "N=5, all-zero offsets self-loop at index 0", -1, () -> sol.solution(new int[]{0,0,0,0,0}))) pass++;
        total++; if (check(total, "N=100,000 (max N), negative offset at the head exits immediately (perf)", 1, () -> sol.solution(headOffset(100000, -1)))) pass++;
        total++; if (check(total, "N=5, cycle of length 2 entered after 2 initial hops", -1, () -> sol.solution(new int[]{1,2,0,-2,0}))) pass++;
        total++; if (check(total, "N=2, two forward hops exits the array", 2, () -> sol.solution(new int[]{1,1}))) pass++;
        total++; if (check(total, "N=2, two-node cycle right at the start", -1, () -> sol.solution(new int[]{1,-1}))) pass++;
        total++; if (check(total, "N=100,000 (max N), full chain that loops back to index 0 (perf)", -1, () -> sol.solution(chainThenExit(100000, -(100000 - 1))))) pass++;
        total++; if (check(total, "N=8, combination of forward and backward hops before exiting", 4, () -> sol.solution(new int[]{3,6,0,-2,0,0,0,1}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    /** A[i] = 1 for i < n-1 (a chain visiting every index in order), A[n-1] = lastOffset. */
    private static int[] chainThenExit(int n, int lastOffset) {
        int[] a = new int[n];
        for (int i = 0; i < n - 1; i++) a[i] = 1;
        a[n - 1] = lastOffset;
        return a;
    }

    /** An array of size n with A[0] = offset0 and every other element 0. */
    private static int[] headOffset(int n, int offset0) {
        int[] a = new int[n];
        a[0] = offset0;
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
