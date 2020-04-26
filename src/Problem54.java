import entity.TreeNode;

import java.util.Objects;

/**
 * 二叉搜索树的第 k 大节点
 * 二叉树的中序遍历
 */
public class Problem54 {
    int count;
    int result = -1;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        kthLargest(root);
        return result;
    }

    public void kthLargest(TreeNode root) {
        if (Objects.nonNull(root)) {
            kthLargest(root.right);
            if (count == 1) {
                result = root.val;
                count--;
                return;
            }
            count--;
            kthLargest(root.left);
        }
    }
}
