package second.day04;

import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-06
 * Time:22:29
 */
/*
链式A+B
 */
public class Main02 {
    public ListNode plusAB(ListNode a, ListNode b) {
         if (a==null) {
             return b;
         }
         if (b==null) {
             return a;
         }
         ListNode head = new ListNode(-1);
         ListNode cur = head;
         ListNode p1 = a;
         ListNode p2 = b;
         int sum = 0;
         while (p1 != null || p2 != null || sum!=0) {
             if (p1!=null) {
                 sum+=p1.val;
                 p1 = p1.next;
             }
             if (p2!=null) {
                 sum+=p2.val;
                 p2 = p2.next;
             }
             cur.next = new ListNode(sum%10);
             sum = sum/10;
             cur = cur.next;
         }
         return head.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}