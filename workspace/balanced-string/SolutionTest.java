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

        total++; if (check(total, "example 1: \"azABaabza\"", 5, () -> sol.solution("azABaabza"))) pass++;
        total++; if (check(total, "example 2: \"TacoCat\" (no balanced fragment)", -1, () -> sol.solution("TacoCat"))) pass++;
        total++; if (check(total, "example 3: \"AcZCbaBz\" (whole string balanced)", 8, () -> sol.solution("AcZCbaBz"))) pass++;
        total++; if (check(total, "example 4: all lowercase, no pairs", -1, () -> sol.solution("abcdefghijklmnopqrstuvwxyz"))) pass++;
        total++; if (check(total, "\"a\" (N=1, smallest possible input)", -1, () -> sol.solution("a"))) pass++;
        total++; if (check(total, "\"Z\" (N=1, uppercase only)", -1, () -> sol.solution("Z"))) pass++;
        total++; if (check(total, "\"Aa\" (smallest balanced fragment, upper then lower)", 2, () -> sol.solution("Aa"))) pass++;
        total++; if (check(total, "\"bB\" (smallest balanced fragment, lower then upper)", 2, () -> sol.solution("bB"))) pass++;
        total++; if (check(total, "\"ab\" (N=2, different letters, no case pair)", -1, () -> sol.solution("ab"))) pass++;
        total++; if (check(total, "\"ABCDE\" (all uppercase only)", -1, () -> sol.solution("ABCDE"))) pass++;
        total++; if (check(total, "\"abcde\" (all lowercase only)", -1, () -> sol.solution("abcde"))) pass++;
        total++; if (check(total, "\"aAbB\" (two pairs, shortest fragment at the start)", 2, () -> sol.solution("aAbB"))) pass++;
        total++; if (check(total, "\"aabbAABB\" (duplicated letters before pairs complete)", 6, () -> sol.solution("aabbAABB"))) pass++;
        total++; if (check(total, "\"xXyYzZ\" (several adjacent pairs)", 2, () -> sol.solution("xXyYzZ"))) pass++;
        total++; if (check(total, "\"AaAaAa\" (repeated pair, occurrence count doesn't matter)", 2, () -> sol.solution("AaAaAa"))) pass++;
        total++; if (check(total, "\"aaaaAAAA\" (long lowercase run then long uppercase run)", 2, () -> sol.solution("aaaaAAAA"))) pass++;
        total++; if (check(total, "\"ABCabc\" (all uppercase block then all lowercase block)", 6, () -> sol.solution("ABCabc"))) pass++;
        total++; if (check(total, "\"zzzzzzzzzzzzzzzzzzzzZ\" (answer sits at the very end)", 2, () -> sol.solution("zzzzzzzzzzzzzzzzzzzzZ"))) pass++;
        total++; if (check(total, "\"aBAb\" (interleaved single letter, needs whole string)", 4, () -> sol.solution("aBAb"))) pass++;
        total++; if (check(total, "\"AbaB\" (interleaved single letter, different order)", 4, () -> sol.solution("AbaB"))) pass++;
        total++; if (check(total, "\"xxxxAaxxxx\" (balanced fragment found in the middle)", 2, () -> sol.solution("xxxxAaxxxx"))) pass++;
        total++; if (check(total, "large N=200, answer near the end (perf check)", 2, () -> sol.solution(repeat('x', 196) + "Aa" + repeat('x', 2)))) pass++;
        total++; if (check(total, "large N=200, no balanced fragment at all (perf check)", -1, () -> sol.solution(repeat('x', 200)))) pass++;
        total++; if (check(total, "\"AxbXaB\" (three letters, complex interleaving, whole string needed)", 6, () -> sol.solution("AxbXaB"))) pass++;
        total++; if (check(total, "\"AAaaBBbbCCcc\" (several pairs with duplicate counts)", 2, () -> sol.solution("AAaaBBbbCCcc"))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    private static String repeat(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(c);
        return sb.toString();
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
