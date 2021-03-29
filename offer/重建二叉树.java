
/*
重建二叉树：
根据二叉树的前序遍历和中序遍历构造二叉树

输入：
[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]

输出：
{1,2,5,3,4,6,7}
 */
public class Main14 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0) {
            return null;
        }
        int rootVal = pre[0];
        if (pre.length == 1){
            return new TreeNode(rootVal);
        }

        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        //在中序遍历中先找到根的位置，好确定左子树和右子树的范围
        for (int i=0 ; i<in.length;i++) {
            if (in[i]==rootVal) {
                rootIndex = i;
                break;
            }
        }

        //Arrays.copyOfRange()是左闭右开的
        root.left = reConstructBinaryTree(
                Arrays.copyOfRange(pre,1,rootIndex+1),
                Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree(
                Arrays.copyOfRange(pre,rootIndex+1,pre.length),
                Arrays.copyOfRange(in,rootIndex+1,in.length));

        return root;
    }
}
