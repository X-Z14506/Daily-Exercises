package first.Day17;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-11
 * Time:9:27
 */

/*
        题目描述
        操作给定的二叉树，将其变换为源二叉树的镜像。
        二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5

    	解题思路：
        1、找到不为空的节点。
        2、然后交换左右节点。
        3、递归调用此函数。
 */

public class Code2 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void Mirror(TreeNode root) {
        //1.如果根节点不为空并且左右子树节点不全为空，交换左右子树节点的值
        if (root!=null&&(root.left!=null||root.right!=null)) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            //2.在分别递归左右子树，交换其左右子节点的值
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
