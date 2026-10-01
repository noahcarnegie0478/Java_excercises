/**
 * TASK: Construct Binary Tree from Preorder and Inorder Traversal
 * Source image: exercise/trees/Construct Binary.png
 *
 * Cho hai mảng số nguyên preorder và inorder:
 * - preorder là kết quả duyệt cây nhị phân theo thứ tự preorder (gốc - trái - phải);
 * - inorder là kết quả duyệt CÙNG cây nhị phân đó theo thứ tự inorder (trái - gốc - phải).
 *
 * Hai mảng có cùng độ dài và các phần tử đều là số nguyên phân biệt.
 *
 * Hãy dựng lại cây nhị phân từ hai kết quả duyệt trên và trả về gốc (root)
 * của cây.
 *
 * Ví dụ, với cây:
 *         1
 *        / \
 *       2   3
 *            \
 *             4
 * thì preorder = [1, 2, 3, 4] và inorder = [2, 1, 3, 4]. Từ hai mảng này,
 * hàm cần dựng lại đúng cây như trên và trả về node gốc (giá trị 1).
 *
 * Viết hàm:
 *     class Solution { public TreeNode solution(int[] preorder, int[] inorder); }
 *
 * Giả sử:
 * - 1 <= độ dài preorder = độ dài inorder <= 3000;
 * - -3000 <= preorder[i], inorder[i] <= 3000;
 * - preorder và inorder đều gồm các giá trị phân biệt (không trùng lặp);
 * - mỗi giá trị trong inorder cũng xuất hiện trong preorder (cùng là kết quả
 *   duyệt của cùng một cây);
 * - preorder chắc chắn là kết quả duyệt preorder hợp lệ của một cây nhị phân,
 *   và inorder chắc chắn là kết quả duyệt inorder hợp lệ của CÙNG cây đó.
 */

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    // ==================== CODE CỦA BẠN ====================
    // Cài đặt hàm này. Không cần sửa gì khác.

    public TreeNode solution(int[] preorder, int[] inorder) {
        throw new UnsupportedOperationException("TODO: implement");
    }
}
