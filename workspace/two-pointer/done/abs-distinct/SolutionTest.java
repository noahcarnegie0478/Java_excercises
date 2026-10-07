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

        total++; if (check(total, "official example: {-5,-3,-1,0,3,6}", 5, () -> sol.solution(new int[]{-5,-3,-1,0,3,6}))) pass++;
        total++; if (check(total, "single element zero (N=1)", 1, () -> sol.solution(new int[]{0}))) pass++;
        total++; if (check(total, "single positive element (N=1)", 1, () -> sol.solution(new int[]{7}))) pass++;
        total++; if (check(total, "single negative element (N=1)", 1, () -> sol.solution(new int[]{-7}))) pass++;
        total++; if (check(total, "two equal positive elements", 1, () -> sol.solution(new int[]{3,3}))) pass++;
        total++; if (check(total, "two opposite values, same absolute value", 1, () -> sol.solution(new int[]{-3,3}))) pass++;
        total++; if (check(total, "two distinct absolute values", 2, () -> sol.solution(new int[]{-4,2}))) pass++;
        total++; if (check(total, "all negative, all distinct", 5, () -> sol.solution(new int[]{-5,-4,-3,-2,-1}))) pass++;
        total++; if (check(total, "all positive, all distinct", 5, () -> sol.solution(new int[]{1,2,3,4,5}))) pass++;
        total++; if (check(total, "all identical zeros", 1, () -> sol.solution(new int[]{0,0,0,0}))) pass++;
        total++; if (check(total, "Integer.MIN_VALUE and Integer.MAX_VALUE (overflow risk)", 2, () -> sol.solution(new int[]{-2147483648, 2147483647}))) pass++;
        total++; if (check(total, "duplicated Integer.MIN_VALUE (overflow risk)", 1, () -> sol.solution(new int[]{-2147483648, -2147483648}))) pass++;
        total++; if (check(total, "duplicated Integer.MAX_VALUE", 1, () -> sol.solution(new int[]{2147483647, 2147483647}))) pass++;
        total++; if (check(total, "negative values with repeated duplicates", 3, () -> sol.solution(new int[]{-9,-9,-9,-5,-5,-1}))) pass++;
        total++; if (check(total, "zero with symmetric positive/negative pair", 2, () -> sol.solution(new int[]{-2,0,2}))) pass++;
        total++; if (check(total, "symmetric run around zero, no zero present", 4, () -> sol.solution(new int[]{-4,-3,-2,-1,1,2,3,4}))) pass++;
        total++; if (check(total, "large distinct absolute values, no overlap", 8, () -> sol.solution(new int[]{-100,-50,-10,-1,2,20,60,120}))) pass++;
        total++; if (check(total, "many overlapping absolute values via duplicates", 3, () -> sol.solution(new int[]{-6,-6,-4,-4,-2,-2,2,2,4,4,6,6}))) pass++;
        total++; if (check(total, "all negative ending at zero", 4, () -> sol.solution(new int[]{-3,-2,-1,0}))) pass++;
        total++; if (check(total, "zero followed by all positive", 4, () -> sol.solution(new int[]{0,1,2,3}))) pass++;
        total++; if (check(total, "single absolute value cluster, no zero", 1, () -> sol.solution(new int[]{-1,-1,-1,1,1,1}))) pass++;
        total++; if (check(total, "three absolute values with multiplicities incl. zero", 2, () -> sol.solution(new int[]{-5,-5,-5,0,0,5,5}))) pass++;
        total++; if (check(total, "Integer.MIN_VALUE paired with zero (overflow risk)", 2, () -> sol.solution(new int[]{-2147483648, 0}))) pass++;
        total++; if (check(total, "consecutive negative duplicates, no positives", 3, () -> sol.solution(new int[]{-3,-3,-2,-2,-1,-1}))) pass++;
        total++; if (check(total, "larger mixed array, all absolute values distinct", 11, () -> sol.solution(new int[]{-10,-8,-6,-4,-2,0,1,3,5,7,9}))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
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
