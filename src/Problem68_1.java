import entity.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 */
public class Problem68_1 {
    /**
     * So easy!
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode node = root;
        while (node != null) {
            if (node.val == p.val || node.val == q.val ||
                    (node.val > p.val && node.val < q.val) ||
                    (node.val < p.val && node.val > q.val)) {
                return node;
            } else if (p.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
}
