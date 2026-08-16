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

        total++; if (check(total, "example 1: \"doernedeevrvn\" (anagram of \"neveroddoreven\")", 1, () -> sol.solution("doernedeevrvn"))) pass++;
        total++; if (check(total, "example 2: \"aabcba\" (no palindrome anagram)", 0, () -> sol.solution("aabcba"))) pass++;
        total++; if (check(total, "N=1: \"a\" (single character is always ok)", 1, () -> sol.solution("a"))) pass++;
        total++; if (check(total, "N=1: \"z\"", 1, () -> sol.solution("z"))) pass++;
        total++; if (check(total, "\"aa\" (single pair)", 1, () -> sol.solution("aa"))) pass++;
        total++; if (check(total, "\"ab\" (two distinct singles, both odd)", 0, () -> sol.solution("ab"))) pass++;
        total++; if (check(total, "\"ba\" (two distinct singles, order swapped)", 0, () -> sol.solution("ba"))) pass++;
        total++; if (check(total, "\"aabb\" (two pairs, all even)", 1, () -> sol.solution("aabb"))) pass++;
        total++; if (check(total, "\"aabbc\" (two pairs plus one odd leftover)", 1, () -> sol.solution("aabbc"))) pass++;
        total++; if (check(total, "\"aabbccdd\" (four pairs, all even)", 1, () -> sol.solution("aabbccdd"))) pass++;
        total++; if (check(total, "\"abc\" (three distinct singles, all odd)", 0, () -> sol.solution("abc"))) pass++;
        total++; if (check(total, "\"kayak\" (already a palindrome)", 1, () -> sol.solution("kayak"))) pass++;
        total++; if (check(total, "\"neveroddoreven\" (already a palindrome)", 1, () -> sol.solution("neveroddoreven"))) pass++;
        total++; if (check(total, "\"aaabbbccc\" (three letters, all odd counts)", 0, () -> sol.solution("aaabbbccc"))) pass++;
        total++; if (check(total, "\"aaabbbbcccc\" (only one odd count)", 1, () -> sol.solution("aaabbbbcccc"))) pass++;
        total++; if (check(total, "\"aaaaa\" (single letter, odd count)", 1, () -> sol.solution("aaaaa"))) pass++;
        total++; if (check(total, "\"aaaa\" (single letter, even count)", 1, () -> sol.solution("aaaa"))) pass++;
        total++; if (check(total, "all 26 letters once each (26 odd counts)", 0, () -> sol.solution("abcdefghijklmnopqrstuvwxyz"))) pass++;
        total++; if (check(total, "all 26 letters twice each (all even counts)", 1, () -> sol.solution(twice("abcdefghijklmnopqrstuvwxyz")))) pass++;
        total++; if (check(total, "all 26 letters twice each plus one extra 'q' (one odd count)", 1, () -> sol.solution(twice("abcdefghijklmnopqrstuvwxyz") + "q"))) pass++;
        total++; if (check(total, "all 26 letters twice each plus 'q' and 'z' (two odd counts)", 0, () -> sol.solution(twice("abcdefghijklmnopqrstuvwxyz") + "qz"))) pass++;
        total++; if (check(total, "large N=100,000, single repeated letter, even count (perf)", 1, () -> sol.solution(repeat('a', 100000)))) pass++;
        total++; if (check(total, "large N=100,000, two letters with odd counts (perf)", 0, () -> sol.solution(repeat('a', 99999) + "b"))) pass++;
        total++; if (check(total, "\"civic\" (already a palindrome, one odd count)", 1, () -> sol.solution("civic"))) pass++;
        total++; if (check(total, "\"aabbccdde\" (four pairs plus one odd leftover)", 1, () -> sol.solution("aabbccdde"))) pass++;

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

    private static String twice(String s) {
        return s + s;
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
