package offer;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-19
 * Time:15:08
 */
public class 链表中倒数第k个节点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        //如果头为空说明链表为空，如果链表的长度小于k，说明找不到倒数第k个
        if(head == null || size(head)<k ) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(k > 0) {
            fast = fast.next;
            k--;
        }
        while(fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    //封装一个求链表长度的方法
    public int size(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while(cur!=null) {
            cur = cur.next;
            size++;
        }
        return size;
    }
}
