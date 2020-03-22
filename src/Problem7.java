import entity.TreeNode;


/**
 * 重建二叉树
 * 由前序遍历和中序遍历重建二叉树
 */
public class Problem7 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }

        return construct(pre, 0, pre.length - 1, in, 0, in.length-1);
    }

    private TreeNode construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode treeNode = new TreeNode(rootVal);

        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                treeNode.left = construct(pre, preStart + 1, i - inStart + preStart, in, inStart, i-1);
                treeNode.right = construct(pre, preStart + 1 + i - inStart, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return treeNode;
    }
}
