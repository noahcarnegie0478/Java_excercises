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

        total++; if (check(total, "example: A=[2,3,1,1,3]", 2, () -> sol.solution(new int[]{2,3,1,1,3}))) pass++;
        total++; if (check(total, "N=1, A=[0] (self loop at start)", 1, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "N=2, full 2-cycle: A=[1,0]", 2, () -> sol.solution(chainThenCycle(0,2)))) pass++;
        total++; if (check(total, "N=2, tail 1 then self loop: A=[1,1]", 1, () -> sol.solution(chainThenCycle(1,1)))) pass++;
        total++; if (check(total, "N=3, whole array is one cycle", 3, () -> sol.solution(chainThenCycle(0,3)))) pass++;
        total++; if (check(total, "N=4, tail 2 then 2-cycle", 2, () -> sol.solution(chainThenCycle(2,2)))) pass++;
        total++; if (check(total, "N=4, tail 1 then 3-cycle", 3, () -> sol.solution(chainThenCycle(1,3)))) pass++;
        total++; if (check(total, "N=5, whole array is one cycle", 5, () -> sol.solution(chainThenCycle(0,5)))) pass++;
        total++; if (check(total, "N=6, tail 3 then 3-cycle", 3, () -> sol.solution(chainThenCycle(3,3)))) pass++;
        total++; if (check(total, "N=6, tail 5 then self loop", 1, () -> sol.solution(chainThenCycle(5,1)))) pass++;
        total++; if (check(total, "N=7, whole array is one cycle", 7, () -> sol.solution(chainThenCycle(0,7)))) pass++;
        total++; if (check(total, "N=5, tail 4 then self loop", 1, () -> sol.solution(chainThenCycle(4,1)))) pass++;
        total++; if (check(total, "N=10, whole array is one cycle", 10, () -> sol.solution(chainThenCycle(0,10)))) pass++;
        total++; if (check(total, "N=100, tail 50 then 50-cycle", 50, () -> sol.solution(chainThenCycle(50,50)))) pass++;
        total++; if (check(total, "N=100, tail 99 then self loop", 1, () -> sol.solution(chainThenCycle(99,1)))) pass++;
        total++; if (check(total, "N=100, whole array is one cycle", 100, () -> sol.solution(chainThenCycle(0,100)))) pass++;
        total++; if (check(total, "N=200,000, whole array is one cycle (perf)", 200000, () -> sol.solution(chainThenCycle(0,200000)))) pass++;
        total++; if (check(total, "N=200,000, long tail then 2-cycle (perf)", 2, () -> sol.solution(chainThenCycle(199998,2)))) pass++;
        total++; if (check(total, "N=200,000, long tail then self loop (perf)", 1, () -> sol.solution(chainThenCycle(199999,1)))) pass++;
        total++; if (check(total, "N=2, index 1 never reached: A=[0,0]", 1, () -> sol.solution(new int[]{0,0}))) pass++;
        total++; if (check(total, "N=3, self loop at boundary index N-1: A=[2,2,2]", 1, () -> sol.solution(new int[]{2,2,2}))) pass++;
        total++; if (check(total, "N=4, 2-cycle at the start, rest unreachable: A=[1,0,3,2]", 2, () -> sol.solution(new int[]{1,0,3,2}))) pass++;
        total++; if (check(total, "N=8, small cycle, unreachable indexes at the end", 3, () -> sol.solution(new int[]{1,2,0,7,7,7,7,7}))) pass++;
        total++; if (check(total, "N=5, all point to last index (self loop at N-1)", 1, () -> sol.solution(new int[]{4,4,4,4,4}))) pass++;
        total++; if (check(total, "N=6, tail 2 then 3-cycle: A=[1,2,3,4,2,0]", 3, () -> sol.solution(new int[]{1,2,3,4,2,0}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    // Builds an array of size (tail + cycle) where indexes 0..tail-1 form a
    // straight chain into the cycle, and indexes tail..n-1 form a cycle of
    // length `cycle` (the last index points back to index `tail`).
    private static int[] chainThenCycle(int tail, int cycle) {
        int n = tail + cycle;
        int[] a = new int[n];
        for (int i = 0; i < n - 1; i++) a[i] = i + 1;
        a[n - 1] = tail;
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
