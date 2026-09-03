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

        TreeNode ex1 = node(2, leaf(1), leaf(3));
        total++; if (check(total, "example 1: root=2,left=1,right=3, k=1", 1, () -> sol.solution(ex1, 1))) pass++;
        total++; if (check(total, "example 1, k=2 (root)", 2, () -> sol.solution(ex1, 2))) pass++;
        total++; if (check(total, "example 1, k=3 (largest)", 3, () -> sol.solution(ex1, 3))) pass++;

        TreeNode ex2 = node(5, node(3, node(2, leaf(1), null), leaf(4)), leaf(6));
        total++; if (check(total, "example 2: 6-node BST, k=1 (smallest)", 1, () -> sol.solution(ex2, 1))) pass++;
        total++; if (check(total, "example 2, k=3", 3, () -> sol.solution(ex2, 3))) pass++;
        total++; if (check(total, "example 2, k=6 (largest)", 6, () -> sol.solution(ex2, 6))) pass++;

        TreeNode single = leaf(42);
        total++; if (check(total, "single node, k=1", 42, () -> sol.solution(single, 1))) pass++;

        TreeNode leftSpine = leftChain(5, 4, 3, 2, 1);
        total++; if (check(total, "left-only spine (5,4,3,2,1), k=1 (smallest)", 1, () -> sol.solution(leftSpine, 1))) pass++;
        total++; if (check(total, "left-only spine, k=3 (middle)", 3, () -> sol.solution(leftSpine, 3))) pass++;
        total++; if (check(total, "left-only spine, k=5 (largest)", 5, () -> sol.solution(leftSpine, 5))) pass++;

        TreeNode rightSpine = rightChain(1, 2, 3, 4, 5);
        total++; if (check(total, "right-only spine (1,2,3,4,5), k=1 (smallest)", 1, () -> sol.solution(rightSpine, 1))) pass++;
        total++; if (check(total, "right-only spine, k=3 (middle)", 3, () -> sol.solution(rightSpine, 3))) pass++;
        total++; if (check(total, "right-only spine, k=5 (largest)", 5, () -> sol.solution(rightSpine, 5))) pass++;

        TreeNode boundary = node(5000, leaf(0), leaf(10000));
        total++; if (check(total, "boundary values (0, 5000, 10000), k=1", 0, () -> sol.solution(boundary, 1))) pass++;
        total++; if (check(total, "boundary values, k=2", 5000, () -> sol.solution(boundary, 2))) pass++;
        total++; if (check(total, "boundary values, k=3", 10000, () -> sol.solution(boundary, 3))) pass++;

        TreeNode balanced15 = buildBalancedBST(1, 15);
        total++; if (check(total, "balanced BST, 15 nodes, k=1 (smallest)", 1, () -> sol.solution(balanced15, 1))) pass++;
        total++; if (check(total, "balanced BST, 15 nodes, k=15 (largest)", 15, () -> sol.solution(balanced15, 15))) pass++;
        total++; if (check(total, "balanced BST, 15 nodes, k=8 (middle)", 8, () -> sol.solution(balanced15, 8))) pass++;

        TreeNode balanced9 = buildBalancedBST(1, 9);
        total++; if (check(total, "balanced BST, 9 nodes, k=5 (middle)", 5, () -> sol.solution(balanced9, 5))) pass++;

        TreeNode large = buildBalancedBST(1, 10000);
        total++; if (check(total, "large balanced BST, 10,000 nodes (max N), k=1 (perf)", 1, () -> sol.solution(large, 1))) pass++;
        total++; if (check(total, "large balanced BST, 10,000 nodes, k=10000 (perf)", 10000, () -> sol.solution(large, 10000))) pass++;
        total++; if (check(total, "large balanced BST, 10,000 nodes, k=5000 (perf)", 5000, () -> sol.solution(large, 5000))) pass++;

        TreeNode twoNodes = node(10000, leaf(0), null);
        total++; if (check(total, "2 nodes (10000 with left child 0), k=1", 0, () -> sol.solution(twoNodes, 1))) pass++;
        total++; if (check(total, "2 nodes (10000 with left child 0), k=2", 10000, () -> sol.solution(twoNodes, 2))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    // ---- BST-building helpers (used only to construct test input) ----

    private static TreeNode leaf(int v) { return new TreeNode(v); }

    private static TreeNode node(int v, TreeNode left, TreeNode right) { return new TreeNode(v, left, right); }

    /** Strictly-decreasing left spine: vals[0] is the root, each next value (smaller) is the left child. */
    private static TreeNode leftChain(int... vals) {
        TreeNode root = null, cur = null;
        for (int v : vals) {
            TreeNode n = new TreeNode(v);
            if (root == null) root = n; else cur.left = n;
            cur = n;
        }
        return root;
    }

    /** Strictly-increasing right spine: vals[0] is the root, each next value (larger) is the right child. */
    private static TreeNode rightChain(int... vals) {
        TreeNode root = null, cur = null;
        for (int v : vals) {
            TreeNode n = new TreeNode(v);
            if (root == null) root = n; else cur.right = n;
            cur = n;
        }
        return root;
    }

    /** Balanced BST built from the consecutive integer range [lo..hi]. */
    private static TreeNode buildBalancedBST(int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode n = new TreeNode(mid);
        n.left = buildBalancedBST(lo, mid - 1);
        n.right = buildBalancedBST(mid + 1, hi);
        return n;
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
