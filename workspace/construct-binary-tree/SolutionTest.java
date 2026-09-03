import java.util.*;

/**
 * TEST RUNNER for Solution.java — no need to edit this file.
 * Run it via the "Run" CodeLens above main() in VS Code; the Java extension
 * automatically compiles Solution.java from the same folder alongside this file.
 *
 * Since the result is a TreeNode (not directly comparable with equals()),
 * each test builds an expected tree, derives its preorder/inorder arrays as
 * input, and compares a preorder-with-explicit-nulls serialization of the
 * expected tree against the same serialization of whatever Solution builds.
 */
public class SolutionTest {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int pass = 0, total = 0;

        {
            TreeNode t = node(1, leaf(2), node(3, null, leaf(4)));
            total++; if (check(total, "example: root=1, left=2, right=3 with right child 4",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = leaf(5);
            total++; if (check(total, "single node tree",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = leftChain(3, 2, 1);
            total++; if (check(total, "left-only chain, 3 nodes",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = rightChain(1, 2, 3);
            total++; if (check(total, "right-only chain, 3 nodes",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(4, node(2, leaf(1), leaf(3)), node(6, leaf(5), leaf(7)));
            total++; if (check(total, "full binary tree, 7 nodes, 3 levels",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(-3000, null, leaf(3000));
            total++; if (check(total, "boundary values: -3000 root, +3000 right child",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(10, leaf(-10), null);
            total++; if (check(total, "2 nodes, left child only",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(-5, null, leaf(5));
            total++; if (check(total, "2 nodes, right child only",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(8, node(3, null, leaf(6)), leaf(10));
            total++; if (check(total, "5 nodes, mixed shape",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = leftChain(4, 3, 2, 1);
            total++; if (check(total, "left-only chain, 4 nodes",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = rightChain(1, 2, 3, 4, 5);
            total++; if (check(total, "right-only chain, 5 nodes",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(5, node(3, null, leaf(4)), node(8, leaf(7), null));
            total++; if (check(total, "zigzag shape, 5 nodes",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(10,
                    node(6, null, node(8, leaf(7), null)),
                    node(15, node(13, null, leaf(14)), null));
            total++; if (check(total, "deeper zigzag shape, 7 nodes",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(-1, leaf(-2), leaf(-3));
            total++; if (check(total, "all negative values, 3 nodes",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(0, leaf(-3000), leaf(3000));
            total++; if (check(total, "root=0 with boundary-value children",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = buildBalancedRange(1, 9);
            total++; if (check(total, "balanced tree, 9 nodes (values 1..9)",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = buildBalancedRange(1, 15);
            total++; if (check(total, "balanced tree, 15 nodes (values 1..15)",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = buildLeftChain(12, 100);
            total++; if (check(total, "left-only chain, 12 nodes",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = buildRightChain(12, 100);
            total++; if (check(total, "right-only chain, 12 nodes",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = buildBalancedRange(1, 3000);
            total++; if (check(total, "large balanced tree, 3000 nodes (max N, perf)",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = buildLeftChain(1000, 1);
            total++; if (check(total, "large left-only chain, 1000 nodes (perf)",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = buildRightChain(1000, 1);
            total++; if (check(total, "large right-only chain, 1000 nodes (perf)",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = buildBalancedRange(-1500, 1499);
            total++; if (check(total, "large balanced tree, 3000 nodes, negative range (perf)",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(-3000, null, leaf(1));
            total++; if (check(total, "2 nodes, root at the minimum boundary value",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }
        {
            TreeNode t = node(100, leaf(99), leaf(101));
            total++; if (check(total, "3 nodes with closely spaced values",
                    serialize(t), () -> serialize(sol.solution(pre(t), in(t))))) pass++;
        }

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — all tests passed!"
                : "FAIL " + pass + "/" + total + " — " + (total - pass) + " test(s) still failing.");
    }

    // ---- tree-building helpers (used only to construct test input, unrelated to how Solution should work) ----

    private static TreeNode leaf(int v) { return new TreeNode(v); }

    private static TreeNode node(int v, TreeNode left, TreeNode right) { return new TreeNode(v, left, right); }

    /** Chain of left children: vals[0] is the root, each next value is the left child of the previous one. */
    private static TreeNode leftChain(int... vals) {
        TreeNode root = null, cur = null;
        for (int v : vals) {
            TreeNode n = new TreeNode(v);
            if (root == null) root = n; else cur.left = n;
            cur = n;
        }
        return root;
    }

    /** Chain of right children: vals[0] is the root, each next value is the right child of the previous one. */
    private static TreeNode rightChain(int... vals) {
        TreeNode root = null, cur = null;
        for (int v : vals) {
            TreeNode n = new TreeNode(v);
            if (root == null) root = n; else cur.right = n;
            cur = n;
        }
        return root;
    }

    /** n-node left-only chain with values startVal, startVal+1, startVal+2, ... */
    private static TreeNode buildLeftChain(int n, int startVal) {
        TreeNode root = null, cur = null;
        for (int i = 0; i < n; i++) {
            TreeNode node = new TreeNode(startVal + i);
            if (root == null) root = node; else cur.left = node;
            cur = node;
        }
        return root;
    }

    /** n-node right-only chain with values startVal, startVal+1, startVal+2, ... */
    private static TreeNode buildRightChain(int n, int startVal) {
        TreeNode root = null, cur = null;
        for (int i = 0; i < n; i++) {
            TreeNode node = new TreeNode(startVal + i);
            if (root == null) root = node; else cur.right = node;
            cur = node;
        }
        return root;
    }

    /** Balanced binary tree built from the consecutive integer range [lo..hi]. */
    private static TreeNode buildBalancedRange(int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode n = new TreeNode(mid);
        n.left = buildBalancedRange(lo, mid - 1);
        n.right = buildBalancedRange(mid + 1, hi);
        return n;
    }

    // ---- traversal / serialization helpers ----

    private static int[] pre(TreeNode t) { return toIntArray(preorderOf(t)); }

    private static int[] in(TreeNode t) { return toIntArray(inorderOf(t)); }

    private static List<Integer> preorderOf(TreeNode n) {
        List<Integer> out = new ArrayList<>();
        preorderHelper(n, out);
        return out;
    }

    private static void preorderHelper(TreeNode n, List<Integer> out) {
        if (n == null) return;
        out.add(n.val);
        preorderHelper(n.left, out);
        preorderHelper(n.right, out);
    }

    private static List<Integer> inorderOf(TreeNode n) {
        List<Integer> out = new ArrayList<>();
        inorderHelper(n, out);
        return out;
    }

    private static void inorderHelper(TreeNode n, List<Integer> out) {
        if (n == null) return;
        inorderHelper(n.left, out);
        out.add(n.val);
        inorderHelper(n.right, out);
    }

    private static int[] toIntArray(List<Integer> l) {
        int[] a = new int[l.size()];
        for (int i = 0; i < l.size(); i++) a[i] = l.get(i);
        return a;
    }

    /** Preorder traversal with explicit null markers, uniquely identifying tree shape + values. */
    private static List<Integer> serialize(TreeNode n) {
        List<Integer> out = new ArrayList<>();
        serializeHelper(n, out);
        return out;
    }

    private static void serializeHelper(TreeNode n, List<Integer> out) {
        if (n == null) { out.add(null); return; }
        out.add(n.val);
        serializeHelper(n.left, out);
        serializeHelper(n.right, out);
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
