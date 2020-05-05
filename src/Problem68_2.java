import entity.TreeNode;

/**
 * 二叉树的最近公共祖先
 */
public class Problem68_2 {
    /**
     * 若 root 是 p, q 的最近公共祖先，则只可能为以下情况之一：
     * p 和 q 在 root 的子树中，且分列 root 的异侧（即分别在左、右子树中）；
     * p = root，且 q 在 root 的左或右子树中；
     * q = root，且 p 在 root 的左或右子树中。
     *
     * 考虑通过递归对二叉树进行后序遍历，当遇到节点 p 或 q 时返回。
     * 从底至顶回溯，当节点 p, q 在节点 root 的异侧时，
     * 节点 root 即为最近公共祖先，则向上返回 root。
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;  // 节点 p, q 在节点 root 的异侧
    }
}
