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

        total++; if (check(total, "example 1: common values {2,3}, min is 2", 2, () -> sol.solution(new int[]{1, 3, 2, 1}, new int[]{4, 2, 5, 3, 2}))) pass++;
        total++; if (check(total, "example 2: no common value", -1, () -> sol.solution(new int[]{2, 1}, new int[]{3, 3}))) pass++;
        total++; if (check(total, "single matching elements [5] / [5] (N=M=1)", 5, () -> sol.solution(new int[]{5}, new int[]{5}))) pass++;
        total++; if (check(total, "single non-matching elements [5] / [6]", -1, () -> sol.solution(new int[]{5}, new int[]{6}))) pass++;
        total++; if (check(total, "all duplicates of the common value [3,3,3] / [3,3]", 3, () -> sol.solution(new int[]{3, 3, 3}, new int[]{3, 3}))) pass++;
        total++; if (check(total, "common value is zero [0,5,10] / [0,7]", 0, () -> sol.solution(new int[]{0, 5, 10}, new int[]{0, 7}))) pass++;
        total++; if (check(total, "disjoint ranges, no overlap", -1, () -> sol.solution(new int[]{1, 2, 3}, new int[]{4, 5, 6}))) pass++;
        total++; if (check(total, "multiple common values, pick the smallest", 10, () -> sol.solution(new int[]{10, 20, 30}, new int[]{30, 20, 10}))) pass++;
        total++; if (check(total, "common values include zero, reversed order", 0, () -> sol.solution(new int[]{0, 1, 2}, new int[]{2, 1, 0}))) pass++;
        total++; if (check(total, "duplicates in A around the common min [4,4,4,2] / [2,2]", 2, () -> sol.solution(new int[]{4, 4, 4, 2}, new int[]{2, 2}))) pass++;
        total++; if (check(total, "completely disjoint large values", -1, () -> sol.solution(new int[]{100, 200}, new int[]{300, 400}))) pass++;
        total++; if (check(total, "both single elements at the max bound 3000", 3000, () -> sol.solution(new int[]{3000}, new int[]{3000}))) pass++;
        total++; if (check(total, "single elements near the max bound, no match", -1, () -> sol.solution(new int[]{3000}, new int[]{2999}))) pass++;
        total++; if (check(total, "common value only at the high end of the range", 350, () -> sol.solution(new int[]{50, 150, 250, 350}, new int[]{350, 450, 550}))) pass++;
        total++; if (check(total, "identical arrays, several common values", 1, () -> sol.solution(new int[]{7, 3, 9, 1}, new int[]{7, 3, 9, 1}))) pass++;
        total++; if (check(total, "partial overlap of consecutive ranges", 3, () -> sol.solution(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 6, 7}))) pass++;
        total++; if (check(total, "same values, reversed order in B", 7, () -> sol.solution(new int[]{9, 8, 7}, new int[]{7, 8, 9}))) pass++;
        total++; if (check(total, "common values only near the max bound", 3000, () -> sol.solution(new int[]{1, 2, 3000}, new int[]{3000, 2999}))) pass++;
        total++; if (check(total, "all zeros in both arrays", 0, () -> sol.solution(new int[]{0, 0, 0}, new int[]{0, 0}))) pass++;
        total++; if (check(total, "N=1 array against a longer array", 5, () -> sol.solution(new int[]{5}, new int[]{9, 8, 5, 7}))) pass++;
        total++; if (check(total, "zero present in only one array", -1, () -> sol.solution(new int[]{0, 1, 2}, new int[]{3, 4, 5}))) pass++;
        total++; if (check(total, "common min appears once in each array", 2, () -> sol.solution(new int[]{9, 8, 2, 7}, new int[]{6, 2, 5}))) pass++;
        total++; if (check(total, "smallest element of A is not in B, next one is", 5, () -> sol.solution(new int[]{1, 5, 9}, new int[]{9, 5}))) pass++;
        total++; if (check(total, "three-way common values, pick the smallest", 1, () -> sol.solution(new int[]{1, 1000, 2000}, new int[]{2000, 1000, 1}))) pass++;
        total++; if (check(total, "large arrays, N=M=1000, overlap only in the middle range (perf check)", 500, () -> sol.solution(range(1, 1000), range(500, 1000)))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static int[] range(int start, int count) {
        int[] a = new int[count];
        for (int i = 0; i < count; i++) a[i] = start + i;
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
