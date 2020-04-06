/**
 * 二叉搜索树的后序遍历序列
 */
public class Problem33 {
    /**
     * 根据以下两个特性验证：
     * 1、二叉树的后序遍历序列的最后一个节点是根节点；
     * 2、二叉搜索树（二叉查找树）的左子节点小于根节点，右子节点大于根节点
     */
    public boolean VerifySequenceOfBST(int [] sequence) {
        if (sequence == null) return false;
        if (sequence.length == 0) return true;

        return verifyCore(sequence, 0, sequence.length);
    }

    private boolean verifyCore(int[] sequence, int startIndex, int endIndex) {
        if (endIndex - startIndex == 1 || startIndex == endIndex) return true;

        int root = sequence[endIndex - 1];
        int leftEndIndex = -1;
        for (int i = startIndex; i < endIndex - 1; i++) {
            if (sequence[i] > root) {
                leftEndIndex = i;
                break;
            }
        }
        if (leftEndIndex == -1) {
            return verifyCore(sequence, startIndex, endIndex - 1);
        }
        for (int i = leftEndIndex; i < endIndex - 1; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return verifyCore(sequence, startIndex, leftEndIndex) &&
                verifyCore(sequence, leftEndIndex, endIndex - 1);
    }

    public static void main(String[] args) {
        int[] seq = {1,2,5,10,6,9,4,3};
        Problem33 p = new Problem33();
        System.out.println(p.VerifySequenceOfBST(seq));
    }
}
