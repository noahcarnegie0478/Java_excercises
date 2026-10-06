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

        total++; if (check(total, "example: [1,0,0,1,0,0]", 2, () -> sol.solution(new int[]{1, 0, 0, 1, 0, 0}))) pass++;
        total++; if (check(total, "single coin heads (N=1 smallest)", 0, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "single coin tails (N=1 smallest)", 0, () -> sol.solution(new int[]{1}))) pass++;
        total++; if (check(total, "already all heads", 0, () -> sol.solution(new int[]{0, 0, 0, 0}))) pass++;
        total++; if (check(total, "already all tails", 0, () -> sol.solution(new int[]{1, 1, 1, 1}))) pass++;
        total++; if (check(total, "two coins, one of each", 1, () -> sol.solution(new int[]{0, 1}))) pass++;
        total++; if (check(total, "two coins, reversed order", 1, () -> sol.solution(new int[]{1, 0}))) pass++;
        total++; if (check(total, "equal split, even N", 2, () -> sol.solution(new int[]{0, 0, 1, 1}))) pass++;
        total++; if (check(total, "majority heads", 1, () -> sol.solution(new int[]{0, 0, 0, 1}))) pass++;
        total++; if (check(total, "majority tails", 1, () -> sol.solution(new int[]{1, 1, 1, 0}))) pass++;
        total++; if (check(total, "alternating pattern", 2, () -> sol.solution(new int[]{0, 1, 0, 1}))) pass++;
        total++; if (check(total, "heads first then all tails", 1, () -> sol.solution(new int[]{0, 1, 1, 1, 1}))) pass++;
        total++; if (check(total, "tails first then all heads", 1, () -> sol.solution(new int[]{1, 0, 0, 0, 0}))) pass++;
        total++; if (check(total, "answer in the middle of array", 1, () -> sol.solution(new int[]{0, 0, 1, 0, 0}))) pass++;
        total++; if (check(total, "three coins, minority tails", 1, () -> sol.solution(new int[]{0, 0, 1}))) pass++;
        total++; if (check(total, "three coins, minority heads", 1, () -> sol.solution(new int[]{1, 1, 0}))) pass++;
        total++; if (check(total, "five coins tie-breakish, minority is 2", 2, () -> sol.solution(new int[]{0, 0, 0, 1, 1}))) pass++;
        total++; if (check(total, "ten coins, half and half", 5, () -> sol.solution(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1}))) pass++;
        total++; if (check(total, "ten coins, one tail", 1, () -> sol.solution(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1}))) pass++;
        total++; if (check(total, "ten coins, one head", 1, () -> sol.solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 0}))) pass++;
        total++; if (check(total, "large array at N bound, all heads (perf check)", 0, () -> sol.solution(allSame(100, 0)))) pass++;
        total++; if (check(total, "large array at N bound, all tails (perf check)", 0, () -> sol.solution(allSame(100, 1)))) pass++;
        total++; if (check(total, "large array at N bound, half/half (perf check)", 50, () -> sol.solution(halfHalf(100)))) pass++;
        total++; if (check(total, "large array at N bound, single tail (perf check)", 1, () -> sol.solution(singleOddOut(100, 1)))) pass++;
        total++; if (check(total, "large array at N bound, single head (perf check)", 1, () -> sol.solution(singleOddOut(100, 0)))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] allSame(int n, int val) {
        int[] a = new int[n];
        Arrays.fill(a, val);
        return a;
    }

    private static int[] halfHalf(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i < n / 2 ? 0 : 1;
        return a;
    }

    private static int[] singleOddOut(int n, int oddVal) {
        int[] a = new int[n];
        Arrays.fill(a, 1 - oddVal);
        a[n / 2] = oddVal;
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
