package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-10
 * Time:13:55
 */
/*
约瑟夫环问题，但是可以用链表模拟游戏过程即可
每出一个孩子，链表长度在变，链表各个元素下标也在变化

输入：5，3（即5个孩子，编号分别为0,1,2,3,4，从0开始报数到3-1=2的孩子出环，接着下一个孩子继续从0开始报数，以此循环，直到只剩一个孩子截止)
输出：3（即编号为3的孩子最后一个没出环的）
 */
public class 孩子们的游戏 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int n = 5;
        int m = 3;
        int i = LastRemaining_Solution(n, m);
        System.out.println(i);
    }
    public static int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        //将所有孩子编号放入链表
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }

        //第一个报数孩子的下标为0
        int bt = 0;
        //直到链表的长度<=1退出循环
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            //出链表中下标为bt的元素
            list.remove(bt);
        }
        //如果m为1的话就可能所有小朋友挨着出环了，这种可能性存在
        return list.size() == 1 ? list.get(0) : -1;
    }
}
