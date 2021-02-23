package offer;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-18
 * Time:20:15
 */
public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) {
            return false;
        }
        //如果找到与子树相同根的值，走判断方法
        if(root1.val == root2.val) {
            if(judge(root1,root2)) {
                return true;
            }
        }
        //遍历左右孩子
        return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
    public boolean judge(TreeNode root, TreeNode subTree) {
        //子结构循环完毕，没有返回false，则代表全部匹配
        if(subTree == null) {
            return true;
        }
        //A数循环完毕，未成功匹配
        if(root == null) {
            return false;
        }
        //相等后判断左右孩子
        if(root.val == subTree.val) {
            return judge(root.left,subTree.left) &&
                    judge(root.right,subTree.right);
        }
        return false;
    }
}
