package offer;

import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-18
 * Time:17:24
 */

/*
合并两个有序的链表
 */

public class 合并两个有序链表 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        //合并后的新链表的头结点
        ListNode listNode = new ListNode(-1);
        ListNode cur = listNode;//遍历用的节点
        while (list1!=null && list2!=null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }else {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }
        }
        //退出循环说明至少有一个链表已经全部遍历完了，因为两个链表都是升序，
        //所以剩下的未遍历的都是大于新链表的最后一个节点的
        if (list1!=null) {
            cur.next = list1;
        }else {
            cur.next = list2;
        }
        return listNode.next;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
