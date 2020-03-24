import entity.TreeNode;

/**
 * 树的子结构
 */
public class Problem26 {
    /**
     * 1. 递归遍历二叉树 A，找到 A 中与二叉树 B 根节点值相同的节点，
     * 2. 再递归判断他们各自的左右节点的值是否相同，
     * 这里递归的终止条件是到达了树 A 或者树 B 的叶节点。
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                res = areSame(root1, root2);
            }
            if (!res) {
                res = HasSubtree(root1.left, root2);
            }
            if (!res) {
                res = HasSubtree(root1.right, root2);
            }
        }
        return res;
    }

    private boolean areSame(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;

        if (root1.val != root2.val) return false;
        return areSame(root1.left, root2.left)
                && areSame(root1.right, root2.right);
    }
}
