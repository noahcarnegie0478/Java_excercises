import java.util.*;

/**
 * TEST RUNNER for Solution.java — no need to edit this file.
 * Run it via the "Run" CodeLens above main() in VS Code; the Java extension
 * automatically compiles Solution.java from the same folder alongside this file.
 *
 * This task allows multiple valid answers (any magnitude pole may be
 * returned), so tests use checkPole(), which validates the returned index
 * against the magnitude-pole definition instead of comparing to one fixed
 * expected value. check()/fmt()/Supplier are kept for completeness.
 */
public class SolutionTest {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int pass = 0, total = 0;

        total++; if (checkPole(total, "example: 10 elements, poles 5 or 9", new int[]{4, 2, 2, 3, 1, 4, 7, 8, 6, 9}, () -> sol.solution(new int[]{4, 2, 2, 3, 1, 4, 7, 8, 6, 9}))) pass++;
        total++; if (check(total, "empty array (N=0 smallest), no pole possible", -1, () -> sol.solution(new int[]{}))) pass++;
        total++; if (check(total, "single element (N=1 smallest), always a pole", 0, () -> sol.solution(new int[]{7}))) pass++;
        total++; if (check(total, "single negative element", 0, () -> sol.solution(new int[]{-7}))) pass++;
        total++; if (checkPole(total, "two equal elements, both valid poles", new int[]{5, 5}, () -> sol.solution(new int[]{5, 5}))) pass++;
        total++; if (checkPole(total, "two ascending elements, both valid poles", new int[]{1, 5}, () -> sol.solution(new int[]{1, 5}))) pass++;
        total++; if (check(total, "two descending elements, no pole", -1, () -> sol.solution(new int[]{5, 1}))) pass++;
        total++; if (checkPole(total, "all elements equal", new int[]{3, 3, 3, 3, 3}, () -> sol.solution(new int[]{3, 3, 3, 3, 3}))) pass++;
        total++; if (checkPole(total, "strictly ascending, every index is a pole", new int[]{1, 2, 3, 4, 5}, () -> sol.solution(new int[]{1, 2, 3, 4, 5}))) pass++;
        total++; if (check(total, "strictly descending, no pole", -1, () -> sol.solution(new int[]{5, 4, 3, 2, 1}))) pass++;
        total++; if (checkPole(total, "negative and positive mixed, ascending", new int[]{-10, -3, 0, 4, 9}, () -> sol.solution(new int[]{-10, -3, 0, 4, 9}))) pass++;
        total++; if (check(total, "negative and positive mixed, descending, no pole", -1, () -> sol.solution(new int[]{9, 4, 0, -3, -10}))) pass++;
        total++; if (checkPole(total, "single dip then rise, pole at the valley", new int[]{3, 1, 5}, () -> sol.solution(new int[]{3, 1, 5}))) pass++;
        total++; if (check(total, "single peak then drop, no pole", -1, () -> sol.solution(new int[]{1, 5, 0}))) pass++;
        total++; if (checkPole(total, "pole at the very start", new int[]{-5, 10, 20, 30}, () -> sol.solution(new int[]{-5, 10, 20, 30}))) pass++;
        total++; if (checkPole(total, "pole at the very end", new int[]{1, 2, 3, 10, 10}, () -> sol.solution(new int[]{1, 2, 3, 10, 10}))) pass++;
        total++; if (checkPole(total, "plateau in the middle, several valid poles", new int[]{1, 4, 4, 4, 9}, () -> sol.solution(new int[]{1, 4, 4, 4, 9}))) pass++;
        total++; if (check(total, "classic non-pole: oscillating values", -1, () -> sol.solution(new int[]{2, 1, 2, 1}))) pass++;
        total++; if (checkPole(total, "boundary extreme values ascending", new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, () -> sol.solution(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}))) pass++;
        total++; if (check(total, "boundary extreme values descending, no pole", -1, () -> sol.solution(new int[]{Integer.MAX_VALUE, 0, Integer.MIN_VALUE}))) pass++;
        total++; if (checkPole(total, "all zeros", new int[]{0, 0, 0, 0, 0, 0}, () -> sol.solution(new int[]{0, 0, 0, 0, 0, 0}))) pass++;
        total++; if (checkPole(total, "two plateaus, low then high", new int[]{2, 2, 2, 8, 8, 8}, () -> sol.solution(new int[]{2, 2, 2, 8, 8, 8}))) pass++;
        total++; if (check(total, "two plateaus, high then low, no pole", -1, () -> sol.solution(new int[]{8, 8, 8, 2, 2, 2}))) pass++;
        total++; if (checkPole(total, "large array at N bound, strictly ascending (perf check)", ascending(100000), () -> sol.solution(ascending(100000)))) pass++;
        total++; if (checkPole(total, "large array at N bound, all equal (perf check)", allSame(100000, 42), () -> sol.solution(allSame(100000, 42)))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] ascending(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }

    private static int[] allSame(int n, int val) {
        int[] a = new int[n];
        Arrays.fill(a, val);
        return a;
    }

    // Reference oracle: finds any magnitude pole of A, or -1 if none exists.
    private static int referencePole(int[] A) {
        int n = A.length;
        if (n == 0) return -1;
        int[] prefMax = new int[n];
        int[] sufMin = new int[n];
        prefMax[0] = A[0];
        for (int i = 1; i < n; i++) prefMax[i] = Math.max(prefMax[i - 1], A[i]);
        sufMin[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) sufMin[i] = Math.min(sufMin[i + 1], A[i]);
        for (int i = 0; i < n; i++) {
            if (prefMax[i] == A[i] && sufMin[i] == A[i]) return i;
        }
        return -1;
    }

    private static boolean isValidPole(int[] A, int q) {
        for (int p = 0; p < q; p++) if (A[p] > A[q]) return false;
        for (int r = q + 1; r < A.length; r++) if (A[q] > A[r]) return false;
        return true;
    }

    private static boolean checkPole(int idx, String desc, int[] A, Supplier actual) {
        try {
            Object o = actual.get();
            int q = (Integer) o;
            boolean hasPole = referencePole(A) != -1;
            boolean ok = (q == -1) ? !hasPole : (q >= 0 && q < A.length && isValidPole(A, q));
            String expectedDesc = hasPole ? "a valid pole" : "-1";
            System.out.printf("[%2d] %-4s %-65s expected=%-12s actual=%s%n",
                    idx, ok ? "PASS" : "FAIL", desc, expectedDesc, fmt(q));
            return ok;
        } catch (Throwable t) {
            System.out.printf("[%2d] %-4s %-65s expected=%-12s actual=THROWN %s: %s%n",
                    idx, "ERR", desc, "a valid pole", t.getClass().getSimpleName(), t.getMessage());
            return false;
        }
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
