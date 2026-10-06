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

        total++; if (check(total, "example: [-6,-91,1011,-100,84,-22,0,1,473]", 1, () -> sol.solution(new int[]{-6, -91, 1011, -100, 84, -22, 0, 1, 473}))) pass++;
        total++; if (check(total, "single element, one-digit (N=1 smallest)", 7, () -> sol.solution(new int[]{7}))) pass++;
        total++; if (check(total, "single element, zero", 0, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "single element, negative one-digit", -3, () -> sol.solution(new int[]{-3}))) pass++;
        total++; if (check(total, "boundary: largest one-digit value 9", 9, () -> sol.solution(new int[]{9}))) pass++;
        total++; if (check(total, "boundary: smallest one-digit value -9", -9, () -> sol.solution(new int[]{-9}))) pass++;
        total++; if (check(total, "boundary just outside: 10 excluded, 9 kept", 9, () -> sol.solution(new int[]{10, 9}))) pass++;
        total++; if (check(total, "boundary just outside: -10 excluded, -9 kept", -9, () -> sol.solution(new int[]{-10, -9}))) pass++;
        total++; if (check(total, "all one-digit values, pick max", 8, () -> sol.solution(new int[]{3, 8, -5, 0, 2}))) pass++;
        total++; if (check(total, "all negative one-digit values", -1, () -> sol.solution(new int[]{-1, -2, -3, -4}))) pass++;
        total++; if (check(total, "duplicates of the max one-digit value", 6, () -> sol.solution(new int[]{6, 6, 6}))) pass++;
        total++; if (check(total, "one-digit answer at the start", 9, () -> sol.solution(new int[]{9, 1000, -2000, 500}))) pass++;
        total++; if (check(total, "one-digit answer at the end", 9, () -> sol.solution(new int[]{1000, -2000, 500, 9}))) pass++;
        total++; if (check(total, "one-digit answer in the middle", 9, () -> sol.solution(new int[]{1000, 9, -2000, 500}))) pass++;
        total++; if (check(total, "mostly large numbers, single qualifying value", 4, () -> sol.solution(new int[]{10000, -10000, 9999, 4, -9999}))) pass++;
        total++; if (check(total, "many one-digit values with negatives and positives", 7, () -> sol.solution(new int[]{-9, -5, 0, 3, 7, -2}))) pass++;
        total++; if (check(total, "min boundary element present alongside large noise", -7, () -> sol.solution(new int[]{-10000, 10000, -7, 9999}))) pass++;
        total++; if (check(total, "zero is the only one-digit value", 0, () -> sol.solution(new int[]{1000, 0, -5000}))) pass++;
        total++; if (check(total, "all same one-digit value", 5, () -> sol.solution(new int[]{5, 5, 5, 5, 5}))) pass++;
        total++; if (check(total, "sorted ascending with one-digit values mixed in", 8, () -> sol.solution(new int[]{-8000, -1, 0, 8, 8000}))) pass++;
        total++; if (check(total, "sorted descending with one-digit values mixed in", 8, () -> sol.solution(new int[]{8000, 8, 0, -1, -8000}))) pass++;
        total++; if (check(total, "boundary max int value present, one-digit still picked", 9, () -> sol.solution(new int[]{10000, -10000, 9}))) pass++;
        total++; if (check(total, "boundary min int value present, one-digit still picked", -9, () -> sol.solution(new int[]{-10000, 10000, -9}))) pass++;
        total++; if (check(total, "large array at N bound, single one-digit value (perf check)", 4, () -> sol.solution(withOneDigit(1000, 4)))) pass++;
        total++; if (check(total, "large array at N bound, all one-digit (perf check)", 9, () -> sol.solution(allSame(1000, 9)))) pass++;

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

    private static int[] withOneDigit(int n, int oneDigitVal) {
        int[] a = new int[n];
        Arrays.fill(a, 10000);
        a[n / 2] = oneDigitVal;
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
