/**
 * TASK: Unvisited Indexes
 * Source image: exercise/linked-lists/e-40-UnvisitedIndexes.png
 *
 * Cho mảng A gồm N số nguyên. Ta duyệt các chỉ số của mảng theo cách sau: ở
 * bước đầu tiên ta đứng ở chỉ số 0; ở mỗi bước tiếp theo, từ chỉ số đang đứng
 * là K, ta di chuyển tới chỉ số:
 *     M = K + A[K]
 * nếu M nằm trong phạm vi mảng. Nếu không, K là chỉ số cuối cùng đã ghé thăm
 * (dừng lại).
 *
 * Viết hàm:
 *     class Solution { public int solution(int[] A); }
 * nhận vào mảng A, trả về số lượng chỉ số KHÔNG THỂ được ghé thăm theo quy
 * trình trên.
 *
 * Ví dụ 1: A[0] = 1, A[1] = 2, A[2] = 3
 *     Chỉ có chỉ số 2 không thể ghé thăm, kết quả trả về là 1.
 *
 * Ví dụ 2: A[0] = 3, A[1] = -5, A[2] = 0, A[3] = -1, A[4] = -3
 *     Chỉ số 1 và 4 không thể ghé thăm, kết quả trả về là 2.
 *
 * Viết thuật toán hiệu quả với các giả định sau:
 * - N là số nguyên trong khoảng [0..200,000];
 * - mỗi phần tử của mảng A là số nguyên trong khoảng [-1,000,000..1,000,000].
 */
public class Solution {

    // ==================== CODE CỦA BẠN ====================
    // Cài đặt hàm này. Không cần sửa gì khác.

    public int solution(int[] A) {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
