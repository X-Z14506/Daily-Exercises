package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-20
 * Time:20:28
 */

/*
//解题思路：其实就是二叉树的层级遍历，不过是在遍历的时候，需要将偶数层的节点逆序。
//关键点：用一个标志位区分奇数层和偶数层，每打印完一层需要变换标志位的状态
 */

public class 之字形打印二叉树 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        //偶数行/奇数行的标志位
        boolean flag = true;
        while(!queue.isEmpty()) {
            //每开始一次循环说明一层结束了
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i =0;i < size;i++) {
                TreeNode node = queue.poll();
                if(flag) {//奇数行直接按顺序打印
                    level.add(node.val);
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }else{//偶数行逆序打印
                    level.add(0,node.val);
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            list.add(level);
            flag=!flag;//每遍历完一行，变换标志位
        }
        return list;
    }
}
