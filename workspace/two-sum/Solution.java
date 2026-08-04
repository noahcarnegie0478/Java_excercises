import java.util.*;

/**
 * ĐỀ BÀI: Two Sum
 * Nguồn: exercise/two-sum.png (bài mẫu, không có ảnh thật — dùng để tham khảo định dạng)
 *
 * Cho mảng số nguyên nums và số nguyên target. Trả về chỉ số (index) của 2 phần tử
 * có tổng bằng target. Giả sử luôn có đúng 1 đáp án, không được dùng lại cùng 1 phần
 * tử 2 lần. Kết quả trả về theo thứ tự bất kỳ.
 *
 * Ví dụ: nums = [2,7,11,15], target = 9  =>  [0,1]  (vì nums[0]+nums[1] = 9)
 *
 * Ràng buộc:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Luôn tồn tại đúng một đáp án hợp lệ.
 */


// public int[] twoSum(int[] nums, int target) {
        
//     }
public class Solution {

    // ==================== CODE CỦA BẠN ====================
    // Sửa bên trong method này. Không cần sửa gì bên dưới.

    public int[] twoSum(int[] nums, int target) {
        // Map lưu trữ: <Giá trị số, Index của số đó>
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Nếu complement đã tồn tại trong map, ta tìm thấy đáp án
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Nếu chưa, đưa số hiện tại và index vào map để dùng cho các bước sau
            map.put(nums[i], i);
        }
        
        // Đề bài đảm bảo luôn có 1 đáp án nên dòng này sẽ không bao giờ tới
        return new int[] {};
        // throw new UnsupportedOperationException("TODO: implement");
    }

    // ==================== TEST RUNNER (không cần sửa bên dưới) ====================
    // Kết quả trả về được sort trước khi so sánh vì đề bài cho phép thứ tự bất kỳ.

    public static void main(String[] args) {
        Solution sol = new Solution();
        int pass = 0, total = 0;

        total++; if (check(total, "[2,7,11,15], target=9", new int[]{0,1}, () -> sorted(sol.twoSum(new int[]{2,7,11,15}, 9)))) pass++;
        total++; if (check(total, "[3,2,4], target=6", new int[]{1,2}, () -> sorted(sol.twoSum(new int[]{3,2,4}, 6)))) pass++;
        total++; if (check(total, "[3,3], target=6 (trùng giá trị)", new int[]{0,1}, () -> sorted(sol.twoSum(new int[]{3,3}, 6)))) pass++;
        total++; if (check(total, "[1,2,3,4,5], target=9", new int[]{3,4}, () -> sorted(sol.twoSum(new int[]{1,2,3,4,5}, 9)))) pass++;
        total++; if (check(total, "[-3,4,3,90], target=0", new int[]{0,2}, () -> sorted(sol.twoSum(new int[]{-3,4,3,90}, 0)))) pass++;
        total++; if (check(total, "[0,4,3,0], target=0 (có số 0 trùng)", new int[]{0,3}, () -> sorted(sol.twoSum(new int[]{0,4,3,0}, 0)))) pass++;
        total++; if (check(total, "[5,75,25], target=100", new int[]{1,2}, () -> sorted(sol.twoSum(new int[]{5,75,25}, 100)))) pass++;
        total++; if (check(total, "[-1,-2,-3,-4,-5], target=-8 (toàn số âm)", new int[]{2,4}, () -> sorted(sol.twoSum(new int[]{-1,-2,-3,-4,-5}, -8)))) pass++;
        total++; if (check(total, "[1,3,4,2], target=6", new int[]{2,3}, () -> sorted(sol.twoSum(new int[]{1,3,4,2}, 6)))) pass++;
        total++; if (check(total, "[10,20,30,40,50], target=90", new int[]{3,4}, () -> sorted(sol.twoSum(new int[]{10,20,30,40,50}, 90)))) pass++;
        total++; if (check(total, "[6,2,9,3], target=11", new int[]{1,2}, () -> sorted(sol.twoSum(new int[]{6,2,9,3}, 11)))) pass++;
        total++; if (check(total, "[100,200,300,400], target=700", new int[]{2,3}, () -> sorted(sol.twoSum(new int[]{100,200,300,400}, 700)))) pass++;
        total++; if (check(total, "[-10,7,19,15,-3], target=4", new int[]{1,4}, () -> sorted(sol.twoSum(new int[]{-10,7,19,15,-3}, 4)))) pass++;
        total++; if (check(total, "[0,0,1], target=0 (hai số 0)", new int[]{0,1}, () -> sorted(sol.twoSum(new int[]{0,0,1}, 0)))) pass++;
        total++; if (check(total, "[2,5,-3,10,7,-2], target=9", new int[]{0,4}, () -> sorted(sol.twoSum(new int[]{2,5,-3,10,7,-2}, 9)))) pass++;
        total++; if (check(total, "[1,2], target=3 (mảng nhỏ nhất, size=2)", new int[]{0,1}, () -> sorted(sol.twoSum(new int[]{1,2}, 3)))) pass++;
        total++; if (check(total, "[1000000000,1000000000], target=2000000000 (số rất lớn)", new int[]{0,1}, () -> sorted(sol.twoSum(new int[]{1000000000, 1000000000}, 2000000000)))) pass++;
        total++; if (check(total, "[-1000000000,1000000000], target=0 (biên min/max)", new int[]{0,1}, () -> sorted(sol.twoSum(new int[]{-1000000000, 1000000000}, 0)))) pass++;
        total++; if (check(total, "[3,3,3,3], target=6 (nhiều cặp trùng, lấy 2 index đầu hợp lệ)", new int[]{0,1}, () -> sorted(sol.twoSum(new int[]{3,3,3,3}, 6)))) pass++;
        total++; if (check(total, "[-5,-5], target=-10 (hai số âm bằng nhau)", new int[]{0,1}, () -> sorted(sol.twoSum(new int[]{-5,-5}, -10)))) pass++;
        total++; if (check(total, "[1,5,1,5], target=10", new int[]{1,3}, () -> sorted(sol.twoSum(new int[]{1,5,1,5}, 10)))) pass++;
        total++; if (check(total, "[8,1,2,7,9,3], target=17", new int[]{0,4}, () -> sorted(sol.twoSum(new int[]{8,1,2,7,9,3}, 17)))) pass++;
        total++; if (check(total, "[0,-1,2,-3,1], target=-2", new int[]{3,4}, () -> sorted(sol.twoSum(new int[]{0,-1,2,-3,1}, -2)))) pass++;
        total++; if (check(total, "[-2,1,-3,4,-1,2,1,-5,4], target=-1", new int[]{0,1}, () -> sorted(sol.twoSum(new int[]{-2,1,-3,4,-1,2,1,-5,4}, -1)))) pass++;
        total++; if (check(total, "[4,4,4,4,4,4,4,4,4,4], target=8 (đáp án ở cuối dãy sau nhiều phần tử giống nhau)", new int[]{0,1}, () -> sorted(sol.twoSum(new int[]{4,4,4,4,4,4,4,4,4,4}, 8)))) pass++;

        System.out.println();
        System.out.println(pass == total
                ? "PASS " + pass + "/" + total + " — tất cả test đều qua!"
                : "FAIL " + pass + "/" + total + " — còn " + (total - pass) + " test chưa qua.");
    }

    private static int[] sorted(int[] a) {
        int[] c = a.clone();
        Arrays.sort(c);
        return c;
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
