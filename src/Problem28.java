import entity.TreeNode;

/**
 * 对称二叉树
 */
public class Problem28 {
    /**
     * 对比二叉树的前序遍历和前序的对称遍历
     * 前序遍历：先左后右
     * 前序的对称遍历：先右后左
     */
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) return true;
        if (pRoot1 == null || pRoot2 == null) return false;
        if (pRoot1.val != pRoot2.val) return false;

        return isSymmetrical(pRoot1.left, pRoot2.right) &&
                isSymmetrical(pRoot1.right, pRoot2.left);

    }
}
