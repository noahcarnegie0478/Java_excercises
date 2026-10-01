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

        total++; if (check(total, "example 1: A=[1,2,3]", 1, () -> sol.solution(new int[]{1,2,3}))) pass++;
        total++; if (check(total, "example 2: A=[3,-5,0,-1,-3]", 2, () -> sol.solution(new int[]{3,-5,0,-1,-3}))) pass++;
        total++; if (check(total, "N=0 (empty array)", 0, () -> sol.solution(new int[]{}))) pass++;
        total++; if (check(total, "N=1, A[0]=0 (self loop at start)", 0, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "N=1, A[0]=5 (jumps out immediately)", 0, () -> sol.solution(new int[]{5}))) pass++;
        total++; if (check(total, "N=1, A[0]=-5 (negative jump out immediately)", 0, () -> sol.solution(new int[]{-5}))) pass++;
        total++; if (check(total, "N=5, all zeros (self loop at index 0)", 4, () -> sol.solution(new int[]{0,0,0,0,0}))) pass++;
        total++; if (check(total, "N=5, all +1 (visits every index in order)", 0, () -> sol.solution(new int[]{1,1,1,1,1}))) pass++;
        total++; if (check(total, "N=1, A[0]=100 (large jump out)", 0, () -> sol.solution(new int[]{100}))) pass++;
        total++; if (check(total, "N=3, jumps out on the very first move", 2, () -> sol.solution(new int[]{5,-100,3}))) pass++;
        total++; if (check(total, "N=3, cycle visits all indexes", 0, () -> sol.solution(new int[]{2,-1,-1}))) pass++;
        total++; if (check(total, "N=4, short cycle leaves indexes unvisited", 2, () -> sol.solution(new int[]{1,-1,5,-1}))) pass++;
        total++; if (check(total, "N=2, boundary values +1,000,000 jumps out", 1, () -> sol.solution(new int[]{1000000,-1000000}))) pass++;
        total++; if (check(total, "N=2, mutual cycle visits both indexes", 0, () -> sol.solution(new int[]{1,-1}))) pass++;
        total++; if (check(total, "large N=200,000, chain of +1 visits everything (perf)", 0, () -> sol.solution(ones(200000)))) pass++;
        total++; if (check(total, "large N=200,000, first jump goes out of bounds (perf)", 199999, () -> sol.solution(firstOut(200000)))) pass++;
        total++; if (check(total, "N=5, cycle of length 2 skips the rest", 3, () -> sol.solution(new int[]{2,3,-2,-3,100}))) pass++;
        total++; if (check(total, "N=1, A[0]=-1 (negative jump out at boundary)", 0, () -> sol.solution(new int[]{-1}))) pass++;
        total++; if (check(total, "N=4, self loop reached after two hops", 1, () -> sol.solution(new int[]{1,1,0,-10}))) pass++;
        total++; if (check(total, "N=2, negative underflow just past index 0", 0, () -> sol.solution(new int[]{1,-2}))) pass++;
        total++; if (check(total, "N=3, jump lands exactly at M=N (out of bounds boundary)", 2, () -> sol.solution(new int[]{3,0,0}))) pass++;
        total++; if (check(total, "N=3, self loop at the last valid index", 1, () -> sol.solution(new int[]{2,0,0}))) pass++;
        total++; if (check(total, "N=5, chain visits all indexes via mixed jumps", 0, () -> sol.solution(new int[]{4,-1,-1,-1,-1}))) pass++;
        total++; if (check(total, "N=6, two separate small cycles unreachable from 0", 4, () -> sol.solution(new int[]{1,-1,1,1,-1,1}))) pass++;
        total++; if (check(total, "N=200,000, single self loop at index 0 (perf)", 199999, () -> sol.solution(zeros(200000)))) pass++;

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

    private static int[] zeros(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 0);
        return a;
    }

    private static int[] firstOut(int n) {
        int[] a = new int[n];
        a[0] = 1000000;
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
