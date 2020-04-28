import entity.TreeNode;

import java.util.Stack;

/**
 * 二叉树的深度
 */
public class Problem55_1 {
    /**
     * 递归解法
     */
    public int maxDepthRecursion(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 利用双栈层次遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        int depth = 0;
        while (!s1.isEmpty()) {
            ++depth;
            while (!s1.isEmpty()) {
                TreeNode pop = s1.pop();
                if (pop.left != null) s2.push(pop.left);
                if (pop.right != null) s2.push(pop.right);
            }
            if (!s2.isEmpty()) ++depth;
            while (!s2.isEmpty()) {
                TreeNode pop = s2.pop();
                if (pop.left != null) s1.push(pop.left);
                if (pop.right != null) s1.push(pop.right);
            }
        }
        return depth;
    }


}
