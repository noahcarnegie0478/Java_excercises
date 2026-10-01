import java.util.*;

/**
 * ĐỀ BÀI: AddFive
 * Nguồn: exercise/m-20-AddFive.png
 *
 * Viết hàm solution nhận vào số nguyên N, trả về giá trị lớn nhất có thể có
 * được bằng cách chèn thêm đúng một chữ số '5' vào biểu diễn thập phân của N.
 *
 * Ví dụ:
 * 1. N = 268   => trả về 5268
 * 2. N = 670   => trả về 6750
 * 3. N = 0     => trả về 50
 * 4. N = -999  => trả về -5999s
 *
 * Ràng buộc:
 * - N là số nguyên trong khoảng [-8 000..8 000].
 * - Bài tập chú trọng vào tính đúng đắn (correctness), không chú trọng hiệu năng.
 */
public class Solution {

    // ==================== CODE CỦA BẠN ====================
    // Sửa bên trong method này. Không cần sửa gì bên dưới.

    public int solution(int n) {
        String s = String.valueOf(n > 0 ? n : (n*-1));
        String result = "";
        boolean tagged = false;
        // System.out.println(s);

         for (int i = 0; i < s.length(); i++) {
            int currentNumber = s.charAt(i) - '0'; 
            if (!tagged) {
                if (n >= 0) {
                if (currentNumber < 5) { result = result + "5" + s.charAt(i); tagged = true;}
                else result = result + s.charAt(i);
            }
            else {
                if (currentNumber > 5) {result = result + "5" + s.charAt(i);tagged = true;}
                else result = result + s.charAt(i);
            }
            }else 
                result = result + s.charAt(i);
            }
        if (!tagged) result = result + "5";
        return  n >= 0 ? Integer.parseInt(result) : Integer.parseInt(result) * -1;
        
    }
    //345 => 5345
    //721 => 7521
    //691 => 6951
    
    

    // ==================== TEST RUNNER (không cần sửa bên dưới) ====================s

    public static void main(String[] args) {
        Solution sol = new Solution();
        int pass = 0, total = 0;

        total++; if (check(total, "N=268 (ví dụ đề bài)", 5268, () -> sol.solution(268))) pass++;
        total++; if (check(total, "N=670 (ví dụ đề bài)", 6750, () -> sol.solution(670))) pass++;
        total++; if (check(total, "N=0 (ví dụ đề bài)", 50, () -> sol.solution(0))) pass++;
        total++; if (check(total, "N=-999 (ví dụ đề bài, số âm)", -5999, () -> sol.solution(-999))) pass++;
        total++; if (check(total, "N=-8000 (biên nhỏ nhất theo ràng buộc)", -58000, () -> sol.solution(-8000))) pass++;
        total++; if (check(total, "N=8000 (biên lớn nhất theo ràng buộc)", 85000, () -> sol.solution(8000))) pass++;
        total++; if (check(total, "N=1 (số dương 1 chữ số)", 51, () -> sol.solution(1))) pass++;
        total++; if (check(total, "N=-1 (số âm 1 chữ số)", -15, () -> sol.solution(-1))) pass++;
        total++; if (check(total, "N=9 (chữ số 9, lớn hơn 5)", 95, () -> sol.solution(9))) pass++;
        total++; if (check(total, "N=4 (chữ số 4, nhỏ hơn 5)", 54, () -> sol.solution(4))) pass++;
        total++; if (check(total, "N=5 (chữ số đúng bằng 5)", 55, () -> sol.solution(5))) pass++;
        total++; if (check(total, "N=-5 (âm, chữ số đúng bằng 5)", -55, () -> sol.solution(-5))) pass++;
        total++; if (check(total, "N=555 (tất cả chữ số = 5)", 5555, () -> sol.solution(555))) pass++;
        total++; if (check(total, "N=-555 (âm, tất cả chữ số = 5)", -5555, () -> sol.solution(-555))) pass++;
        total++; if (check(total, "N=444 (tất cả chữ số < 5)", 5444, () -> sol.solution(444))) pass++;
        total++; if (check(total, "N=-444 (âm, tất cả chữ số < 5)", -4445, () -> sol.solution(-444))) pass++;
        total++; if (check(total, "N=666 (tất cả chữ số > 5)", 6665, () -> sol.solution(666))) pass++;
        total++; if (check(total, "N=-666 (âm, tất cả chữ số > 5)", -5666, () -> sol.solution(-666))) pass++;
        total++; if (check(total, "N=100 (có chữ số 0)", 5100, () -> sol.solution(100))) pass++;
        total++; if (check(total, "N=-100 (âm, có chữ số 0)", -1005, () -> sol.solution(-100))) pass++;
        total++; if (check(total, "N=1000 (4 chữ số, đuôi toàn 0)", 51000, () -> sol.solution(1000))) pass++;
        total++; if (check(total, "N=-1000 (âm, 4 chữ số, đuôi toàn 0)", -10005, () -> sol.solution(-1000))) pass++;
        total++; if (check(total, "N=7999 (gần biên lớn nhất)", 79995, () -> sol.solution(7999))) pass++;
        total++; if (check(total, "N=-7999 (gần biên nhỏ nhất)", -57999, () -> sol.solution(-7999))) pass++;
        total++; if (check(total, "N=4321 (chữ số giảm dần)", 54321, () -> sol.solution(4321))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — tất cả test đều qua!"
                : "FAIL " + pass + "/" + total + " — còn " + (total - pass) + " test chưa qua.");
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
