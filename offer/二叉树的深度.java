/*
二叉树的深度
 */
public class Main07 {
    //递归
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }

    //非递归，每遍历一层就加一
    public int TreeDepth2(TreeNode root) {
        if(root==null) return 0;
        ArrayList<TreeNode> arr=new ArrayList<>();
        arr.add(root);
        int count=0;
        while(arr.size()!=0){
            count++;
            for(int i=0; i<arr.size(); i++){
                TreeNode temp=arr.remove(0);
                if(temp.left!=null)
                    arr.add(temp.left);
                if(temp.right!=null)
                    arr.add(temp.right);
            }
        }
        return count;
    }

    public int TreeDepth3(TreeNode pRoot)
    {
        if(pRoot == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int depth = 0, count = 0, nextCount = 1;
        while(queue.size()!=0){
            TreeNode top = queue.poll();
            count++;
            if(top.left != null){
                queue.add(top.left);
            }
            if(top.right != null){
                queue.add(top.right);
            }
            if(count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }
}

