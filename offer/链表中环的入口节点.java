package offer;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-10
 * Time:15:41
 */

/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

 */
public class 链表中环的入口节点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null) {
            return null;
        }
        //先判断链表有环没
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast==null || fast.next==null) {
            return null;
        }
        //程序走到这里说明链表有环
        slow = pHead;
        while(slow!=fast) {
            fast=fast.next;
            slow=slow.next;
        }
        //走到这里说明slow指针和fast指针相遇，该节点就是
        return slow;
    }
}
