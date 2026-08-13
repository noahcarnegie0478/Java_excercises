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

        total++; if (check(total, "example: A=[5,4,0,3,1,6,2]", 4, () -> sol.solution(new int[]{5,4,0,3,1,6,2}))) pass++;
        total++; if (check(total, "N=0 (empty array)", 0, () -> sol.solution(new int[]{}))) pass++;
        total++; if (check(total, "N=1, single self loop", 1, () -> sol.solution(buildCycles(1)))) pass++;
        total++; if (check(total, "N=2, one necklace of 2 beads", 2, () -> sol.solution(buildCycles(2)))) pass++;
        total++; if (check(total, "N=2, two separate self loops", 1, () -> sol.solution(buildCycles(1,1)))) pass++;
        total++; if (check(total, "N=3, one necklace of 3 beads", 3, () -> sol.solution(buildCycles(3)))) pass++;
        total++; if (check(total, "N=3, three separate self loops", 1, () -> sol.solution(buildCycles(1,1,1)))) pass++;
        total++; if (check(total, "N=4, two necklaces of 2 beads each", 2, () -> sol.solution(buildCycles(2,2)))) pass++;
        total++; if (check(total, "N=5, one necklace of 5 beads", 5, () -> sol.solution(buildCycles(5)))) pass++;
        total++; if (check(total, "N=6, three necklaces of 2 beads each", 2, () -> sol.solution(buildCycles(2,2,2)))) pass++;
        total++; if (check(total, "N=6, necklaces of sizes 1, 2, 3", 3, () -> sol.solution(buildCycles(1,2,3)))) pass++;
        total++; if (check(total, "N=7, necklaces of sizes 4 and 3", 4, () -> sol.solution(buildCycles(4,3)))) pass++;
        total++; if (check(total, "N=10, one necklace of 10 beads", 10, () -> sol.solution(buildCycles(10)))) pass++;
        total++; if (check(total, "N=10, ten separate self loops", 1, () -> sol.solution(buildCycles(1,1,1,1,1,1,1,1,1,1)))) pass++;
        total++; if (check(total, "N=10, necklaces of sizes 7 and 3", 7, () -> sol.solution(buildCycles(7,3)))) pass++;
        total++; if (check(total, "N=10, necklaces of sizes 1, 2, 3, 4", 4, () -> sol.solution(buildCycles(1,2,3,4)))) pass++;
        total++; if (check(total, "N=1,000,000, one giant necklace (perf)", 1000000, () -> sol.solution(buildCycles(1000000)))) pass++;
        total++; if (check(total, "N=1,000,000, all 2-bead necklaces (perf)", 2, () -> sol.solution(twoCycles(1000000)))) pass++;
        total++; if (check(total, "N=1,000,000, all self loops (perf)", 1, () -> sol.solution(identity(1000000)))) pass++;
        total++; if (check(total, "N=1,000,000, one giant necklace plus a self loop (perf)", 999999, () -> sol.solution(buildCycles(999999,1)))) pass++;
        total++; if (check(total, "N=1,000,000, necklaces of sizes 1, 500000, 499999 (perf)", 500000, () -> sol.solution(buildCycles(1,500000,499999)))) pass++;
        total++; if (check(total, "N=4, two swapped pairs: A=[3,2,1,0]", 2, () -> sol.solution(new int[]{3,2,1,0}))) pass++;
        total++; if (check(total, "N=8, mixed necklace sizes 2, 3, 2, 1: A=[1,0,3,4,2,7,6,5]", 3, () -> sol.solution(new int[]{1,0,3,4,2,7,6,5}))) pass++;
        total++; if (check(total, "N=1,000,000, necklaces of sizes 300000, 300000, 400000 (perf)", 400000, () -> sol.solution(buildCycles(300000,300000,400000)))) pass++;
        total++; if (check(total, "N=5, self loop plus a 4-bead necklace: A=[0,2,3,4,1]", 4, () -> sol.solution(new int[]{0,2,3,4,1}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    // Builds a permutation array made of consecutive disjoint cycles whose
    // sizes are given in order, e.g. buildCycles(2,3) on indexes [0,1,2,3,4]
    // makes cycle {0,1} and cycle {2,3,4}.
    private static int[] buildCycles(int... sizes) {
        int n = 0;
        for (int s : sizes) n += s;
        int[] a = new int[n];
        int start = 0;
        for (int s : sizes) {
            for (int i = 0; i < s - 1; i++) a[start + i] = start + i + 1;
            a[start + s - 1] = start;
            start += s;
        }
        return a;
    }

    // n/2 disjoint 2-bead necklaces: (0,1), (2,3), (4,5), ...
    private static int[] twoCycles(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i += 2) {
            a[i] = i + 1;
            a[i + 1] = i;
        }
        return a;
    }

    // n self loops: every bead points to itself.
    private static int[] identity(int n) {
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
