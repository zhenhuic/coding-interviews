import entity.TreeNode;

/**
 * 二叉树的镜像
 */
public class Problem27 {
    /**
     * 画图就能看出只要遍历二叉树，并交换其左右子节点
     */
    public void Mirror(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
