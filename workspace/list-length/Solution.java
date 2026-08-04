import java.util.*;

/**
 * ĐỀ BÀI: Length of a linked list
 * Nguồn: exercise/done 1.png
 *
 * Một con trỏ được gọi là linked list nếu:
 * - nó là con trỏ rỗng (empty pointer), khi đó gọi là terminator / empty list; hoặc
 * - nó trỏ tới một structure (gọi là node hoặc head) chứa 1 giá trị (value) và
 *   1 linked list khác (gọi là tail).
 *
 * Length của 1 list là tổng số node mà nó chứa. List rỗng có length = 0.
 *
 * Ví dụ, xét linked list sau: A -> B -> C -> D -> (terminator)
 * List này có 4 node: A, B, C, D. D là node cuối, tail của nó là terminator.
 * Length của list này là 4.
 *
 * Giả sử có khai báo sau:
 *
 *     class IntList {
 *       public int value;
 *       public IntList next;
 *     }
 *
 * Viết hàm:
 *
 *     class Solution { public int solution(IntList L); }
 *
 * cho một linked list L không rỗng gồm N node, trả về length của nó.
 *
 * Ví dụ, với list L như ví dụ trên, hàm phải trả về 4.
 *
 * Ràng buộc:
 * - N là số nguyên trong khoảng [1..5.000];
 * - list L không có cycle (mỗi con trỏ non-empty trỏ tới 1 structure khác nhau).
 *
 * Trong lời giải, chỉ tập trung vào correctness. Performance không phải trọng tâm chấm điểm.
 */

class IntList {
    public int value;
    public IntList next;
}

public class Solution {

    // ==================== CODE CỦA BẠN ====================
    // Sửa bên trong method này. Không cần sửa gì bên dưới.

    public int solution(IntList L) {
        int count = 0;
        // for (IntList node = L; node != null; node = node.next) {
        //     count++;
        // }
        return count;
    }

    // ==================== TEST RUNNER (không cần sửa bên dưới) ====================

    public static void main(String[] args) {
        Solution sol = new Solution();
        int pass = 0, total = 0;

        total++; if (check(total, "N=1, value=0", 1, () -> sol.solution(buildList(new int[]{0})))) pass++;
        total++; if (check(total, "N=1, value=-1000000000 (min biên value)", 1, () -> sol.solution(buildList(new int[]{-1000000000})))) pass++;
        total++; if (check(total, "N=1, value=1000000000 (max biên value)", 1, () -> sol.solution(buildList(new int[]{1000000000})))) pass++;
        total++; if (check(total, "N=2, [1,2]", 2, () -> sol.solution(buildList(new int[]{1,2})))) pass++;
        total++; if (check(total, "N=4, ví dụ đề bài A->B->C->D", 4, () -> sol.solution(buildList(new int[]{65,66,67,68})))) pass++;
        total++; if (check(total, "N=3, tất cả value giống nhau [5,5,5]", 3, () -> sol.solution(buildList(new int[]{5,5,5})))) pass++;
        total++; if (check(total, "N=5, toàn value âm", 5, () -> sol.solution(buildList(new int[]{-1,-2,-3,-4,-5})))) pass++;
        total++; if (check(total, "N=5, âm/0/dương lẫn lộn", 5, () -> sol.solution(buildList(new int[]{-3,0,3,-7,7})))) pass++;
        total++; if (check(total, "N=10, value tăng dần", 10, () -> sol.solution(buildList(range(10))))) pass++;
        total++; if (check(total, "N=10, value giảm dần", 10, () -> sol.solution(buildList(reversedRange(10))))) pass++;
        total++; if (check(total, "N=100", 100, () -> sol.solution(buildList(range(100))))) pass++;
        total++; if (check(total, "N=1000", 1000, () -> sol.solution(buildList(range(1000))))) pass++;
        total++; if (check(total, "N=4999 (sát biên trên)", 4999, () -> sol.solution(buildList(range(4999))))) pass++;
        total++; if (check(total, "N=5000 (biên trên, N max)", 5000, () -> sol.solution(buildList(range(5000))))) pass++;
        total++; if (check(total, "N=2, hai value trùng nhau [7,7]", 2, () -> sol.solution(buildList(new int[]{7,7})))) pass++;
        total++; if (check(total, "N=7, value trùng lặp rải rác", 7, () -> sol.solution(buildList(new int[]{1,2,1,3,2,1,3})))) pass++;
        total++; if (check(total, "N=50", 50, () -> sol.solution(buildList(range(50))))) pass++;
        total++; if (check(total, "N=6, value gồm cả min/max int xen kẽ", 6, () -> sol.solution(buildList(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE, -1, 1, 0})))) pass++;
        total++; if (check(total, "N=3, toàn value 0", 3, () -> sol.solution(buildList(new int[]{0,0,0})))) pass++;
        total++; if (check(total, "N=15", 15, () -> sol.solution(buildList(range(15))))) pass++;
        total++; if (check(total, "N=200", 200, () -> sol.solution(buildList(range(200))))) pass++;
        total++; if (check(total, "N=2500 (giữa khoảng)", 2500, () -> sol.solution(buildList(range(2500))))) pass++;
        total++; if (check(total, "N=4998", 4998, () -> sol.solution(buildList(range(4998))))) pass++;
        total++; if (check(total, "N=9", 9, () -> sol.solution(buildList(range(9))))) pass++;
        total++; if (check(total, "N=20", 20, () -> sol.solution(buildList(range(20))))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — tất cả test đều qua!"
                : "FAIL " + pass + "/" + total + " — còn " + (total - pass) + " test chưa qua.");
    }

    private static IntList buildList(int[] vals) {
        IntList head = null, tail = null;
        for (int v : vals) {
            IntList node = new IntList();
            node.value = v;
            node.next = null;
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static int[] range(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }

    private static int[] reversedRange(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = n - i;
        return a;
    }

    private interface Supplier { Object get() throws Throwable; }

    private static boolean check(int idx, String desc, Object expected, Supplier actual) {
        try {
            Object a = actual.get();
            boolean ok = Objects.deepEquals(expected, a);
            System.out.printf("[%2d] %-4s %-55s expected=%-20s actual=%s%n",
                    idx, ok ? "PASS" : "FAIL", desc, fmt(expected), fmt(a));
            return ok;
        } catch (Throwable t) {
            System.out.printf("[%2d] %-4s %-55s expected=%-20s actual=THROWN %s: %s%n",
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
