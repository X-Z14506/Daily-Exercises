package second.day02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-04
 * Time:21:14
 */

//TODO 不知道问题在哪
public class Main2 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.addFirst(5);
        listNode1.addFirst(6);
        listNode1.addFirst(8);
        listNode1.addFirst(1);
        int x = 5;
        listNode1.display();
        Main2 main2 = new Main2();
         main2.partition(listNode1.head,x);
        System.out.println();
        listNode1.display();
    }


    public ListNode partition(ListNode pHead, int x) {
        ListNode aHead = null;
        ListNode aLast = null;
        ListNode bHead = null;
        ListNode bLast = null;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x ) {
                if (aHead == null) {
                    aHead = cur;
                    aLast = cur;
                }else {
                    aLast.next = cur;
                    aLast = aLast.next;
                }
            }else {
                if (bHead == null) {
                    bHead = cur;
                    bLast = cur;
                }else {
                    bLast.next = cur;
                    bLast = bLast.next;
                }
            }
            cur = cur.next;
        }
        if (aHead == null) {
            return bHead;
        }else if (bHead == null) {
            return aHead;
        }else {
            aLast.next = bHead;
            bLast.next = null;
        }
        return aHead;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode head = null;

    ListNode(int val) {
        this.val = val;
    }
    ListNode() {

    }

    public void addFirst(int val) {
        ListNode listNode = new ListNode(val);
        if (head == null) {
            this.head = listNode;
        }else {
            listNode.next = this.head;
            this.head = listNode;
        }
    }
    public void display() {
        ListNode cur = this.head;
        while (cur !=null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
