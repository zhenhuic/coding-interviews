import entity.TreeNode;

public class Problem36 {
    /**
     * 利用二叉树的 *中序遍历*
     */
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        convertHelper(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void convertHelper(TreeNode curr) {
        if (curr != null) {
            convertHelper(curr.left);
            curr.left = pre;
            if (pre != null) pre.right = curr;
            pre = curr;
            convertHelper(curr.right);
        }
    }

    public static void main(String[] args) {
        Problem36 p = new Problem36();
        TreeNode h = new TreeNode(1);
        p.Convert(h);
    }
}
