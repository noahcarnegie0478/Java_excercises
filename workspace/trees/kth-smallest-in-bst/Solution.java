import java.util.ArrayList;
import java.util.List;

/**
 * TASK: Kth Smallest Integer in BST
 * Source image: exercise/trees/Smallest Integer.png
 *
 * Cho gốc (root) của một cây tìm kiếm nhị phân (Binary Search Tree - BST) và
 * một số nguyên k, hãy trả về giá trị nhỏ thứ k (1-indexed, tức k=1 là giá
 * trị nhỏ nhất) trong cây.
 *
 * Một BST thoả các tính chất sau:
 * - cây con trái của mỗi node chỉ chứa các node có giá trị NHỎ HƠN giá trị
 *   của node đó;
 * - cây con phải của mỗi node chỉ chứa các node có giá trị LỚN HƠN giá trị
 *   của node đó;
 * - cả cây con trái và cây con phải cũng đều là BST.
 *
 * Ví dụ 1: với cây
 *       2
 *      / \
 *     1   3
 * và k = 1, hàm nên trả về 1 (giá trị nhỏ nhất trong cây).
 *
 * Ví dụ 2: với cây
 *         5
 *        / \
 *       3   6
 *      / \
 *     2   4
 *    /
 *   1
 * và k = 3, hàm nên trả về 3 (giá trị nhỏ thứ 3, theo thứ tự tăng dần:
 * 1, 2, 3, 4, 5, 6).
 *
 * Viết hàm:
 *     class Solution { public int solution(TreeNode root, int k); }
 *
 * Giả sử:
 * - số lượng node trong cây nằm trong khoảng [1..10,000];
 * - 0 <= giá trị mỗi node <= 10,000;
 * - 1 <= k <= số lượng node trong cây.
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

    public int solution(TreeNode root, int k) {
        if (root == null) return -1;
        List<Integer> result = new ArrayList<>();
        // call the recursive function
        addToArray(root, result);
        System.out.println(result);
        return result.get(k-1);
        

        //add the node into the list by the order.  
        // if null ignore 
        // and then return the k-1 order in the list

    }

    private void addToArray(TreeNode root, List<Integer> numbers) {
        if (root == null) return;
        addToArray(root.left, numbers);
        addToArray(root.right, numbers);
        numbers.add(root.val);
    }
}
