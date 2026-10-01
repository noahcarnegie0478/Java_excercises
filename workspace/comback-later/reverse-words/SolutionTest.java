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

        total++; if (check(total, "example: \"we test coders\"", "ew tset sredoc", () -> sol.solution("we test coders"))) pass++;
        total++; if (check(total, "single word, no spaces: \"hello\"", "olleh", () -> sol.solution("hello"))) pass++;
        total++; if (check(total, "N=1: \"a\"", "a", () -> sol.solution("a"))) pass++;
        total++; if (check(total, "two words: \"ab cd\"", "ba dc", () -> sol.solution("ab cd"))) pass++;
        total++; if (check(total, "leading space: \" abc\" (empty first word)", " cba", () -> sol.solution(" abc"))) pass++;
        total++; if (check(total, "trailing space: \"abc \" (empty last word)", "cba ", () -> sol.solution("abc "))) pass++;
        total++; if (check(total, "double space between single-letter words: \"a  b\"", "a  b", () -> sol.solution("a  b"))) pass++;
        total++; if (check(total, "three spaces only: \"   \" (all words empty)", "   ", () -> sol.solution("   "))) pass++;
        total++; if (check(total, "single space: \" \" (two empty words)", " ", () -> sol.solution(" "))) pass++;
        total++; if (check(total, "already-palindrome words unchanged: \"kayak level\"", "kayak level", () -> sol.solution("kayak level"))) pass++;
        total++; if (check(total, "varied word lengths: \"a bc def ghij\"", "a cb fed jihg", () -> sol.solution("a bc def ghij"))) pass++;
        total++; if (check(total, "one long word: \"abcdefghij\"", "jihgfedcba", () -> sol.solution("abcdefghij"))) pass++;
        total++; if (check(total, "repeated pattern word: \"abab\"", "baba", () -> sol.solution("abab"))) pass++;
        total++; if (check(total, "four words: \"the quick brown fox\"", "eht kciuq nworb xof", () -> sol.solution("the quick brown fox"))) pass++;
        total++; if (check(total, "leading and trailing spaces: \" abc def \"", " cba fed ", () -> sol.solution(" abc def "))) pass++;
        total++; if (check(total, "double spaces between two-letter words: \"ab  cd  ef\"", "ba  dc  fe", () -> sol.solution("ab  cd  ef"))) pass++;
        total++; if (check(total, "two spaces only: \"  \"", "  ", () -> sol.solution("  "))) pass++;
        total++; if (check(total, "uniform-letter word unchanged: \"zzzzzzzz\"", "zzzzzzzz", () -> sol.solution("zzzzzzzz"))) pass++;
        total++; if (check(total, "single distinct letter: \"b\"", "b", () -> sol.solution("b"))) pass++;
        total++; if (check(total, "two words: \"abcd efgh\"", "dcba hgfe", () -> sol.solution("abcd efgh"))) pass++;
        total++; if (check(total, "two big words separated by many spaces (perf)",
                reverseStr(cyclicWord(50000)) + repeatChar(' ', 5) + reverseStr(cyclicWord(50000)),
                () -> sol.solution(cyclicWord(50000) + repeatChar(' ', 5) + cyclicWord(50000)))) pass++;
        total++; if (check(total, "large N=200,000, single word (perf)",
                reverseStr(cyclicWord(200000)), () -> sol.solution(cyclicWord(200000)))) pass++;
        total++; if (check(total, "large N, many short words (perf)",
                manyWordsReversedExpected(20000), () -> sol.solution(manyWords(20000)))) pass++;
        total++; if (check(total, "only spaces, length 50 (all words empty, perf)",
                repeatChar(' ', 50), () -> sol.solution(repeatChar(' ', 50)))) pass++;
        total++; if (check(total, "three words with mixed lengths: \"x ab defg\"", "x ba gfed", () -> sol.solution("x ab defg"))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    // Builds a cyclic a..z..a..z... word of the given length (used only to
    // build test input; not related to how Solution should be implemented).
    private static String cyclicWord(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append((char) ('a' + (i % 26)));
        return sb.toString();
    }

    // "aa bb cc ... " built from n two-letter words separated by single spaces
    // (used only to build test input).
    private static String manyWords(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            char c = (char) ('a' + (i % 26));
            sb.append(c).append(c);
        }
        return sb.toString();
    }

    // Expected output for manyWords(n): each two-letter word "cc" reversed is
    // still "cc", so the expected string is identical to the input.
    private static String manyWordsReversedExpected(int n) {
        return manyWords(n);
    }

    private static String reverseStr(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String repeatChar(char c, int n) {
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
        String str = String.valueOf(o);
        return str.length() > 40 ? str.substring(0, 40) + "...(len=" + str.length() + ")" : str;
    }
}
