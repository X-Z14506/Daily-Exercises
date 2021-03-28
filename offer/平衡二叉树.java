/*
平衡二叉树
 */
public class Main12 {
    //判断是不是平衡二叉树
    public boolean IsBalanced_Solution(TreeNode1 root) {
        if (root==null) {
            return true;
        }
        int l = height(root.left);
        int r = height(root.right);
        if (Math.abs(l-r) < 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }else {
            return false;
        }
    }

    //求二叉树的高度
    public int height(TreeNode1 root) {
        if (root == null) {
            return 1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight,rightHeight);
    }
}
class TreeNode1{
    public int val;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;
    }
}
