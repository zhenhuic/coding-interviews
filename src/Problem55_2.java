import entity.TreeNode;

/**
 * 平衡二叉树
 */
public class Problem55_2 {
    /**
     * 注意平衡二叉树的定义：
     * 如果某二叉树中任意节点的左右子树的深度相差不超过 1 ，那么它就是一棵平衡二叉树。
     *
     * 递归求出每个左右子二叉树的深度，计算他们的差是否小于等于 1
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
