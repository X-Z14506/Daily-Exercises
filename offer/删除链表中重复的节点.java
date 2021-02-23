package offer;

import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-10
 * Time:16:21
 */
/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

输入：{1,2,3,3,4,4,5}
输出：{1,2,5}
 */
public class 删除链表中重复的节点 {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode pre = newHead;
        ListNode last = pHead;
        while (last!=null) {
            //存在重复节点时，删的只剩最后一个
            if (last.next!=null && last.val == last.next.val) {
                while (last.next!=null && last.val == last.next.val) {
                    last = last.next;
                }
                //删的只剩最后一个之后改变指针的指向,继续向后判断
                pre.next = last.next;
                last = last.next;
            }else {
                pre = pre.next;
                last = last.next;
            }
        }
        return newHead.next;
    }
}
