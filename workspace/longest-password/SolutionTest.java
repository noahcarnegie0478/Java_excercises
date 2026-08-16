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

        total++; if (check(total, "example: \"test 5 a0A pass007 ?xy1\"", 7, () -> sol.solution("test 5 a0A pass007 ?xy1"))) pass++;
        total++; if (check(total, "single valid word: \"a0A\" (2 letters, 1 digit)", 3, () -> sol.solution("a0A"))) pass++;
        total++; if (check(total, "single word with a symbol: \"?xy1\"", -1, () -> sol.solution("?xy1"))) pass++;
        total++; if (check(total, "letters only, no digits (0 is even): \"ab\"", -1, () -> sol.solution("ab"))) pass++;
        total++; if (check(total, "single digit: \"5\" (0 letters, 1 digit)", 1, () -> sol.solution("5"))) pass++;
        total++; if (check(total, "letters only, even letter count still invalid: \"test\"", -1, () -> sol.solution("test"))) pass++;
        total++; if (check(total, "three words, one clearly longest valid: \"5 a0A pass007\"", 7, () -> sol.solution("5 a0A pass007"))) pass++;
        total++; if (check(total, "no valid word in the whole string", -1, () -> sol.solution("test ?xy1 !!"))) pass++;
        total++; if (check(total, "word with only symbols: \"!!!\"", -1, () -> sol.solution("!!!"))) pass++;
        total++; if (check(total, "odd letters, odd digits (letters must be even): \"a1\"", -1, () -> sol.solution("a1"))) pass++;
        total++; if (check(total, "digits only, odd count: \"123\"", 3, () -> sol.solution("123"))) pass++;
        total++; if (check(total, "digits only, even count: \"12\"", -1, () -> sol.solution("12"))) pass++;
        total++; if (check(total, "letters only, 6 letters, 0 digits: \"abcdef\"", -1, () -> sol.solution("abcdef"))) pass++;
        total++; if (check(total, "digits only, 3 digits: \"007\"", 3, () -> sol.solution("007"))) pass++;
        total++; if (check(total, "single digit \"0\"", 1, () -> sol.solution("0"))) pass++;
        total++; if (check(total, "two digits \"00\" (even, invalid)", -1, () -> sol.solution("00"))) pass++;
        total++; if (check(total, "2 letters + 1 digit: \"aa1\"", 3, () -> sol.solution("aa1"))) pass++;
        total++; if (check(total, "3 letters + 1 digit (odd letters, invalid): \"aaa1\"", -1, () -> sol.solution("aaa1"))) pass++;
        total++; if (check(total, "shorter valid word first, longer valid word second", 5, () -> sol.solution("1 aa135"))) pass++;
        total++; if (check(total, "longer valid word first, shorter valid word second", 5, () -> sol.solution("aa135 1"))) pass++;
        total++; if (check(total, "mixed case letters + odd digits: \"AbCd12345\"", 9, () -> sol.solution("AbCd12345"))) pass++;
        total++; if (check(total, "otherwise-valid counts but contains a hyphen: \"aa-135\"", -1, () -> sol.solution("aa-135"))) pass++;
        total++; if (check(total, "leading/trailing spaces create empty words: \" a0A \"", 3, () -> sol.solution(" a0A "))) pass++;
        total++; if (check(total, "long valid word among filler (boundary N<=200)",
                101, () -> sol.solution("?? " + repeat('x', 60) + repeat('7', 41)))) pass++;
        total++; if (check(total, "long invalid word, short valid digits word: \"abcdefgh 13579 !!!!\"", 5, () -> sol.solution("abcdefgh 13579 !!!!"))) pass++;

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
