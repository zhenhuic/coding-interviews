import entity.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 从树的根节点开始往下一直到叶节点所经过的节点形成的一条路径
 */
public class Problem34 {
    /**
     * 利用二叉树的前序遍历
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        traverseFindPath(root, target, path, 0, result);
        return result;
    }

    private void traverseFindPath(TreeNode root, int target, ArrayList<Integer> path, int pathSum, ArrayList<ArrayList<Integer>> result) {
        if (pathSum + root.val == target && root.left == null && root.right == null) {
            path.add(root.val);
            ArrayList<Integer> res = new ArrayList<>(path);
            result.add(res);
            path.remove(path.size() - 1);
        } else if ((pathSum + root.val) < target) {
            int newPathSum = pathSum + root.val;
            path.add(root.val);
            if (root.left != null) {
                traverseFindPath(root.left, target, path, newPathSum, result);
            }
            if (root.right != null) {
                traverseFindPath(root.right, target, path, newPathSum, result);
            }
            path.remove(path.size() - 1);
        }
    }
}
