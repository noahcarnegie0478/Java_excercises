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

        total++; if (check(total, "example 1: [1,1000,80,-91]", -11, () -> sol.solution(new int[]{1, 1000, 80, -91}))) pass++;
        total++; if (check(total, "example 2: [47,1900,1,90,45]", 182, () -> sol.solution(new int[]{47, 1900, 1, 90, 45}))) pass++;
        total++; if (check(total, "example 3: [-13,1900,1,100,45]", 32, () -> sol.solution(new int[]{-13, 1900, 1, 100, 45}))) pass++;
        total++; if (check(total, "empty array (N=0 smallest)", 0, () -> sol.solution(new int[]{}))) pass++;
        total++; if (check(total, "single two-digit element", 42, () -> sol.solution(new int[]{42}))) pass++;
        total++; if (check(total, "single one-digit element", 0, () -> sol.solution(new int[]{5}))) pass++;
        total++; if (check(total, "single negative two-digit element", -42, () -> sol.solution(new int[]{-42}))) pass++;
        total++; if (check(total, "boundary: smallest two-digit value 10", 10, () -> sol.solution(new int[]{10}))) pass++;
        total++; if (check(total, "boundary: largest two-digit value 99", 99, () -> sol.solution(new int[]{99}))) pass++;
        total++; if (check(total, "boundary: smallest negative two-digit value -10", -10, () -> sol.solution(new int[]{-10}))) pass++;
        total++; if (check(total, "boundary: largest negative two-digit value -99", -99, () -> sol.solution(new int[]{-99}))) pass++;
        total++; if (check(total, "just below boundary: 9 excluded", 0, () -> sol.solution(new int[]{9}))) pass++;
        total++; if (check(total, "just above boundary: 100 excluded", 0, () -> sol.solution(new int[]{100}))) pass++;
        total++; if (check(total, "just below negative boundary: -9 excluded", 0, () -> sol.solution(new int[]{-9}))) pass++;
        total++; if (check(total, "just above negative boundary: -100 excluded", 0, () -> sol.solution(new int[]{-100}))) pass++;
        total++; if (check(total, "zero value excluded", 0, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "no two-digit numbers at all", 0, () -> sol.solution(new int[]{1, 5, 100, 1000, -5}))) pass++;
        total++; if (check(total, "all elements are two-digit", 30, () -> sol.solution(new int[]{10, 10, 10}))) pass++;
        total++; if (check(total, "duplicates among two-digit values", 50, () -> sol.solution(new int[]{25, 25}))) pass++;
        total++; if (check(total, "mix of positive and negative two-digit cancelling out", 0, () -> sol.solution(new int[]{50, -50}))) pass++;
        total++; if (check(total, "extreme int bounds mixed with two-digit values", 11, () -> sol.solution(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 11}))) pass++;
        total++; if (check(total, "extreme int min value alone (abs overflow edge case)", 0, () -> sol.solution(new int[]{Integer.MIN_VALUE}))) pass++;
        total++; if (check(total, "extreme int max value alone", 0, () -> sol.solution(new int[]{Integer.MAX_VALUE}))) pass++;
        total++; if (check(total, "answer only from first and last elements", -5, () -> sol.solution(new int[]{20, 1000, 1000, 1000, -25}))) pass++;
        total++; if (check(total, "large array at N bound, all two-digit (perf check)", 1000000, () -> sol.solution(allSame(100000, 10)))) pass++;

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
