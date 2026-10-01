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

        total++; if (check(total, "example from task: A=[1,4,-1,3,2]", 4, () -> sol.solution(new int[]{1,4,-1,3,2}))) pass++;
        total++; if (check(total, "N=1, head is immediately the last node", 1, () -> sol.solution(arr(1, 0,-1)))) pass++;
        total++; if (check(total, "N=2, forward chain of two nodes", 2, () -> sol.solution(arr(2, 0,1, 1,-1)))) pass++;
        total++; if (check(total, "N=2, head immediately last, second index unused", 1, () -> sol.solution(arr(2, 0,-1)))) pass++;
        total++; if (check(total, "N=3, forward chain covering all indices", 3, () -> sol.solution(arr(3, 0,1, 1,2, 2,-1)))) pass++;
        total++; if (check(total, "N=3, chain skips index 1", 2, () -> sol.solution(arr(3, 0,2, 2,-1)))) pass++;
        total++; if (check(total, "N=4, chain skips indices 1 and 2", 2, () -> sol.solution(arr(4, 0,3, 3,-1)))) pass++;
        total++; if (check(total, "N=4, forward chain covering all indices", 4, () -> sol.solution(arr(4, 0,1, 1,2, 2,3, 3,-1)))) pass++;
        total++; if (check(total, "N=5, reverse-order chain covering all indices", 5, () -> sol.solution(new int[]{4,-1,1,2,3}))) pass++;
        total++; if (check(total, "N=6, chain via indices 0 -> 3 -> 5", 3, () -> sol.solution(arr(6, 0,3, 3,5, 5,-1)))) pass++;
        total++; if (check(total, "N=7, zigzag stepping by 2 through every other index", 4, () -> sol.solution(arr(7, 0,2, 2,4, 4,6, 6,-1)))) pass++;
        total++; if (check(total, "N=10, forward chain covering all indices", 10, () -> sol.solution(fullForwardChain(10)))) pass++;
        total++; if (check(total, "N=10, reverse-order chain covering all indices", 10, () -> sol.solution(fullReverseChain(10)))) pass++;
        total++; if (check(total, "N=200,000 (max N), forward chain covering all indices (perf)", 200000, () -> sol.solution(fullForwardChain(200000)))) pass++;
        total++; if (check(total, "N=200,000 (max N), head immediately last node", 1, () -> sol.solution(arr(200000, 0,-1)))) pass++;
        total++; if (check(total, "N=200,000, two-node chain at the upper index boundary", 2, () -> sol.solution(arr(200000, 0,199999, 199999,-1)))) pass++;
        total++; if (check(total, "N=50, chain visiting scattered indices", 5, () -> sol.solution(arr(50, 0,10, 10,20, 20,30, 30,40, 40,-1)))) pass++;
        total++; if (check(total, "N=20, alternating jump pattern", 4, () -> sol.solution(arr(20, 0,5, 5,1, 1,15, 15,-1)))) pass++;
        total++; if (check(total, "N=15, forward chain covering all indices", 15, () -> sol.solution(fullForwardChain(15)))) pass++;
        total++; if (check(total, "N=8, chain combining forward and backward jumps", 4, () -> sol.solution(arr(8, 0,3, 3,1, 1,6, 6,-1)))) pass++;
        total++; if (check(total, "N=100, forward chain covering all indices", 100, () -> sol.solution(fullForwardChain(100)))) pass++;
        total++; if (check(total, "N=1000, reverse-order chain covering all indices", 1000, () -> sol.solution(fullReverseChain(1000)))) pass++;
        total++; if (check(total, "N=6, chain hops directly from index 0 to index 5", 2, () -> sol.solution(arr(6, 0,5, 5,-1)))) pass++;
        total++; if (check(total, "N=6, head immediately last, unreached cycle among other indices", 1, () -> sol.solution(new int[]{-1,2,3,4,5,1}))) pass++;
        total++; if (check(total, "N=5, chain length 2, unused index has a self-loop", 2, () -> sol.solution(arr(5, 0,1, 1,-1, 2,2)))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    /** Builds an int array of size n, default-filled with 0, with (index, value) pairs applied on top. */
    private static int[] arr(int n, int... pairs) {
        int[] a = new int[n];
        for (int i = 0; i < pairs.length; i += 2) a[pairs[i]] = pairs[i + 1];
        return a;
    }

    /** A[i] = i+1 for i < n-1, A[n-1] = -1: a chain visiting every index in increasing order. */
    private static int[] fullForwardChain(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n - 1; i++) a[i] = i + 1;
        a[n - 1] = -1;
        return a;
    }

    /** A chain visiting every index starting at 0, then n-1, n-2, ..., down to 1 (n >= 2). */
    private static int[] fullReverseChain(int n) {
        int[] a = new int[n];
        a[0] = n - 1;
        for (int i = n - 1; i >= 2; i--) a[i] = i - 1;
        a[1] = -1;
        return a;
    }

    private interface Supplier { Object get() throws Throwable; }

    private static boolean check(int idx, String desc, Object expected, Supplier actual) {
        try {
            Object a = actual.get();
            boolean ok = Objects.deepEquals(expected, a);
            System.out.printf("[%2d] %-4s %-65s expected=%-8s actual=%s%n",
                    idx, ok ? "PASS" : "FAIL", desc, fmt(expected), fmt(a));
            return ok;
        } catch (Throwable t) {
            System.out.printf("[%2d] %-4s %-65s expected=%-8s actual=THROWN %s: %s%n",
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
