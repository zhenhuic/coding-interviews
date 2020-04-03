import entity.TreeNode;

import java.util.*;

/**
 * 从上到下打印二叉树
 */
public class Problem32 {
    /**
     * 用队列存子节点
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.remove();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    /**
     * 分行从上到下打印二叉树
     *
     * 需要设置额外两个变量，
     * 一个变量表示当前层需要打印的节点个数，
     * 另一个表示下一层需要打印的节点个数
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int currLevelNum = 0;
        int nextLevelNum = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            currLevelNum = nextLevelNum;
            nextLevelNum = 0;
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < currLevelNum; i++) {
                TreeNode node = queue.remove();
                res.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    nextLevelNum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextLevelNum++;
                }
            }
            result.add(res);
        }
        return result;
    }

    /**
     * 之字形打印二叉树
     *
     * 需要利用两个栈来保存下一行的节点
     * 奇数行，先左子节点，后右子节点
     * 偶数行反之
     */
    public List<List<Integer>> zShapeLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        int level = 1;
        int currLevelNum = 0;
        int nextLevelNum = 1;
        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            currLevelNum = nextLevelNum;
            nextLevelNum = 0;
            ArrayList<Integer> res = new ArrayList<>();
            if ((level & 1) == 1) {
                for (int i = 0; i < currLevelNum; i++) {
                    TreeNode node = stack1.pop();
                    res.add(node.val);
                    if (node.left != null) {
                        stack2.add(node.left);
                        nextLevelNum++;
                    }
                    if (node.right != null) {
                        stack2.add(node.right);
                        nextLevelNum++;
                    }
                }
            } else {
                for (int i = 0; i < currLevelNum; i++) {
                    TreeNode node = stack2.pop();
                    res.add(node.val);
                    if (node.right != null) {
                        stack1.add(node.right);
                        nextLevelNum++;
                    }
                    if (node.left != null) {
                        stack1.add(node.left);
                        nextLevelNum++;
                    }
                }
            }
            level++;
            result.add(res);
        }
        return result;

    }

    public static void main(String[] args) {
        Problem32 p = new Problem32();
        System.out.println(p.PrintFromTopToBottom(new TreeNode(1)));
    }
}
