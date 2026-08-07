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

        total++; if (check(total, "example: 1->2->3->4, M=2", 3, () -> sol.solution(buildList(new int[]{1,2,3,4}), 2))) pass++;
        total++; if (check(total, "1->2->3, M=1 (last element)", 3, () -> sol.solution(buildList(new int[]{1,2,3}), 1))) pass++;
        total++; if (check(total, "1->2->3, M=3 (first element, M=N)", 1, () -> sol.solution(buildList(new int[]{1,2,3}), 3))) pass++;
        total++; if (check(total, "1->2->3, M=4 (M=N+1, just too big)", -1, () -> sol.solution(buildList(new int[]{1,2,3}), 4))) pass++;
        total++; if (check(total, "1->2->3, M=1,000,000,000 (huge M on a small list)", -1, () -> sol.solution(buildList(new int[]{1,2,3}), 1000000000))) pass++;
        total++; if (check(total, "empty list (N=0), M=1", -1, () -> sol.solution(null, 1))) pass++;
        total++; if (check(total, "empty list (N=0), M=1,000,000,000", -1, () -> sol.solution(null, 1000000000))) pass++;
        total++; if (check(total, "single-node list [42], M=1", 42, () -> sol.solution(buildList(new int[]{42}), 1))) pass++;
        total++; if (check(total, "single-node list [42], M=2 (too big)", -1, () -> sol.solution(buildList(new int[]{42}), 2))) pass++;
        total++; if (check(total, "[-5,10,-3], M=2 (negative values)", 10, () -> sol.solution(buildList(new int[]{-5,10,-3}), 2))) pass++;
        total++; if (check(total, "[7,7,7,7], M=3 (all values equal, position matters)", 7, () -> sol.solution(buildList(new int[]{7,7,7,7}), 3))) pass++;
        total++; if (check(total, "[MIN_VALUE,MAX_VALUE], M=1 (last element)", Integer.MAX_VALUE, () -> sol.solution(buildList(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}), 1))) pass++;
        total++; if (check(total, "[MIN_VALUE,MAX_VALUE], M=2 (first element)", Integer.MIN_VALUE, () -> sol.solution(buildList(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}), 2))) pass++;
        total++; if (check(total, "N=100,000 (max N), M=1 (last element, perf)", 99999, () -> sol.solution(buildList(range(100000)), 1))) pass++;
        total++; if (check(total, "N=100,000 (max N), M=100,000 (first element, perf)", 0, () -> sol.solution(buildList(range(100000)), 100000))) pass++;
        total++; if (check(total, "N=100,000 (max N), M=50,000 (middle element, perf)", 50000, () -> sol.solution(buildList(range(100000)), 50000))) pass++;
        total++; if (check(total, "N=100,000 (max N), M=1,000,000,000 (huge M, perf)", -1, () -> sol.solution(buildList(range(100000)), 1000000000))) pass++;
        total++; if (check(total, "N=100,000 (max N), M=100,001 (just above N, perf)", -1, () -> sol.solution(buildList(range(100000)), 100001))) pass++;
        total++; if (check(total, "[10,20,30,40,50], M=5 (first element)", 10, () -> sol.solution(buildList(new int[]{10,20,30,40,50}), 5))) pass++;
        total++; if (check(total, "[10,20,30,40,50], M=1 (last element)", 50, () -> sol.solution(buildList(new int[]{10,20,30,40,50}), 1))) pass++;
        total++; if (check(total, "[10,20,30,40,50], M=3 (middle element)", 30, () -> sol.solution(buildList(new int[]{10,20,30,40,50}), 3))) pass++;
        total++; if (check(total, "[100,200], M=1 (two-node list, last)", 200, () -> sol.solution(buildList(new int[]{100,200}), 1))) pass++;
        total++; if (check(total, "[100,200], M=2 (two-node list, first)", 100, () -> sol.solution(buildList(new int[]{100,200}), 2))) pass++;
        total++; if (check(total, "[100,200], M=3 (two-node list, too big)", -1, () -> sol.solution(buildList(new int[]{100,200}), 3))) pass++;
        total++; if (check(total, "single-node list [MIN_VALUE], M=1 (boundary value)", Integer.MIN_VALUE, () -> sol.solution(buildList(new int[]{Integer.MIN_VALUE}), 1))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static IntList buildList(int[] vals) {
        IntList head = null, tail = null;
        for (int v : vals) {
            IntList node = new IntList();
            node.value = v;
            node.next = null;
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    /** Returns {0, 1, 2, ..., n-1}, used to build a large list where value == 0-based position. */
    private static int[] range(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }

    private interface Supplier { Object get() throws Throwable; }

    private static boolean check(int idx, String desc, Object expected, Supplier actual) {
        try {
            Object a = actual.get();
            boolean ok = Objects.deepEquals(expected, a);
            System.out.printf("[%2d] %-4s %-65s expected=%-12s actual=%s%n",
                    idx, ok ? "PASS" : "FAIL", desc, fmt(expected), fmt(a));
            return ok;
        } catch (Throwable t) {
            System.out.printf("[%2d] %-4s %-65s expected=%-12s actual=THROWN %s: %s%n",
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
