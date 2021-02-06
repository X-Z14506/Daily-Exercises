package second.day05;

import javax.swing.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-09
 * Time:11:54
 */

/*
平衡二叉树

现一个函数，检查二叉树是否平衡，平衡二叉树的定义如下，对于树中的任意 一个结点，
其两颗子树的高度差不超过1。
给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
public class Main01 {
    public static void main(String[] args) {

    }
    //判断是不是平衡二叉树
    public boolean isBalance(TreeNode root) {
        if (root==null) {
            return true;
        }
        //左子树高度
        int left = getHeight(root.left);
        //右子树高度
        int right = getHeight(root.right);
        //如果左右子树高度相差<=1，说明为平衡树，接着判断左右子树是否为平衡树
        if (Math.abs(left-right) <= 1) {
            return isBalance(root.left) && isBalance(root.right);
        }else {
            //若左右子树高度相差>1,或者左右子树的高度相差>1，说明不是平衡树
            return false;
        }

    }

    //计算二叉树的高度
    private int getHeight(TreeNode root) {
        if (root==null) {
            return 0;
        }
        //计算左子树的高度
        int leftHeight = getHeight(root.left);
        //计算右子树的高度
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
