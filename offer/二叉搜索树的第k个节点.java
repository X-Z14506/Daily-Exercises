
/*
二叉搜索树的第k个节点
二叉搜索树（二叉查找树）（二叉排序树）：
     根节点的值大于其左子树中任意一个节点的值，小于其右节点中任意一节点的值，

深度优先--栈--前中后序遍历
 */
public class Main13 {
    TreeNode2 KthNode(TreeNode2 pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        Stack<TreeNode2> stack = new Stack<>();
        //计数，每次出栈一个加一次，出栈顺序就是二叉树的节点的值的大小顺序
        int count = 0;
        //判断有没有遍历完
        while (pRoot!=null || !stack.empty()) {
            //中序遍历 左根右
            while (pRoot!=null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            //出栈顺序是按照终须遍历出的栈，即二叉树节点的大小顺序
            pRoot = stack.pop();
            count++;
            if (count==k) {
                return pRoot;
            }
            pRoot = pRoot.right;
        }
        //走到这里说明k超过了二叉树的节点个数
        return null;
    }
}
class TreeNode2 {
    int val;
    TreeNode2 left = null;
    TreeNode2 right = null;

    public TreeNode2(int val) {
        this.val = val;
    }
}
