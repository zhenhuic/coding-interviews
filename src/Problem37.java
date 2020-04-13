import entity.TreeNode;

/**
 * 序列化二叉树
 * 用一个特殊字符 $ 代替 null，
 * 这样就只需要一种遍历的序列就能完成反序列化，
 * 不然就要前序遍历序列和中序遍历序列才能构造出一个二叉树
 */
public class Problem37 {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeCore(root, sb);
        return sb.toString();
    }

    private void serializeCore(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("$,");
            return;
        }
        sb.append(root.val).append(",");
        serializeCore(root.left, sb);
        serializeCore(root.right, sb);
    }

    int index = -1;
    TreeNode Deserialize(String str) {
        String[] treeStr = str.split(",");
        return deserializeCore(treeStr);
    }

    private TreeNode deserializeCore(String[] treeStr) {
        index++;
        TreeNode node = null;
        if (!treeStr[index].equals("$")) {
            node = new TreeNode(Integer.parseInt(treeStr[index]));
            node.left = deserializeCore(treeStr);
            node.right = deserializeCore(treeStr);
        }
        return node;
    }

}
