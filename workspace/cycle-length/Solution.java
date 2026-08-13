/**
 * TASK: Cycle Length
 * Source image: exercise/linked-lists/e-45-CycleLength.png
 *
 * Cho mảng không rỗng A gồm N số nguyên. Mảng chỉ chứa các số nguyên trong
 * khoảng [0..N-1]. Mỗi phần tử của mảng có thể được xem như con trỏ tới một
 * phần tử khác của mảng: nếu A[K] = M thì phần tử A[K] trỏ tới A[M].
 *
 * Mảng định nghĩa một chuỗi các bước nhảy của một quân cờ (pawn) như sau:
 * - ban đầu, quân cờ đứng ở vị trí 0;
 * - ở mỗi bước nhảy, quân cờ di chuyển từ vị trí hiện tại K tới A[K];
 * - quân cờ nhảy mãi mãi.
 *
 * Vì số vị trí có thể của quân cờ là hữu hạn, nên cuối cùng, sau một chuỗi
 * bước nhảy ban đầu nào đó, quân cờ sẽ đi vào một chu trình (cycle). Hãy
 * tính độ dài của chu trình này.
 *
 * Ví dụ, với mảng A:
 *     A[0] = 2   A[1] = 3   A[2] = 1   A[3] = 1   A[4] = 3
 * các vị trí liên tiếp của quân cờ là: 0, 2, 1, 3, 1, 3, 1, 3, ..., và độ dài
 * của chu trình là 2.
 *
 * Viết hàm:
 *     class Solution { public int solution(int[] A); }
 * nhận vào mảng không rỗng A gồm N số nguyên trong khoảng [0..N-1], trả về
 * độ dài của chu trình mà quân cờ cuối cùng sẽ đi vào, như mô tả ở trên.
 *
 * Viết thuật toán hiệu quả với các giả định sau:
 * - N là số nguyên trong khoảng [1..200,000];
 * - mỗi phần tử của mảng A là số nguyên trong khoảng [0..N-1].
 */
public class Solution {

    // ==================== CODE CỦA BẠN ====================
    // Cài đặt hàm này. Không cần sửa gì khác.

    public int solution(int[] A) {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
