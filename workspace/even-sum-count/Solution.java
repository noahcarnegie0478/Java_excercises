/**
 * ĐỀ BÀI: Even Sum Count (Đếm cặp có tổng chẵn)
 * Ảnh nguồn: exercise/m-35-EvenSumCount.png
 *
 * Viết hàm:
 *     class Solution { public int solution(int[] A); }
 * cho một mảng A gồm N số nguyên, hãy trả về số lượng cặp (P, Q) sao cho
 * 0 <= P < Q < N và tổng A[P] + A[Q] là một số chẵn. Hàm phải trả về -1 nếu
 * số lượng cặp như vậy vượt quá 1,000,000,000.
 *
 * Ví dụ, với mảng A sao cho:
 *     A[0] = 2
 *     A[1] = 1
 *     A[2] = 5
 *     A[3] = -6
 *     A[4] = 9
 * hàm phải trả về 4, vì có đúng bốn cặp thỏa mãn điều kiện trên, cụ thể là:
 * - (0, 3), vì tổng A[0] + A[3] = 2 + (-6) = -4, là số chẵn;
 * - (1, 2), vì tổng A[1] + A[2] = 1 + 5 = 6;
 * - (1, 4), vì tổng A[1] + A[4] = 1 + 9 = 10;
 * - (2, 4), vì tổng A[2] + A[4] = 5 + 9 = 14.
 *
 * Viết thuật toán hiệu quả cho các ràng buộc sau:
 * - N là số nguyên trong khoảng [0..50,000];
 * - mỗi phần tử của mảng A là số nguyên trong khoảng
 *   [-1,000,000,000..1,000,000,000].
 */

public class Solution {
    public int solution(int[] A) {
        int count = 0;
        int left = 0;
        int right = left+1;
        while (left < (A.length -1)) {
        if (left >= A.length -1) break;
        if (right > (A.length -1) ) {left++; right = left + 1; continue;}
        boolean requirement = ((A[left] + A[right]) % 2) == 0;
        if (requirement) {
            System.out.println(" is pass: " + " left: " + A[left] + " " + "right: " + A[right]);
            count++;
        }
        right++;
        }
        return count;

    }
}
