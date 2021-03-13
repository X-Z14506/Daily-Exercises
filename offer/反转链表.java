/*
反转链表
 */
public class 反转链表 {
    public ListNode16 ReverseList(ListNode16 head) {
        ListNode16 cur = head;
        ListNode16 prev = null;
        ListNode16 newHead = null;
        while (cur != null) {
            //每次循环刚进来需要开辟一个节点保存cur.next，
            // 因为要让cur指向cur前一个节点，不保存cur.next就会找不到cur.next
            ListNode16 curNext = cur.next;
            if (cur.next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
}
class ListNode16 {
    int val;
    ListNode16 next = null;

    ListNode16(int val) {
        this.val = val;
    }
}
