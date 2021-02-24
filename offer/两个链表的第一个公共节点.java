package offer;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-09
 * Time:23:04
 */
public class 两个链表的第一个公共节点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //只要有一个链表为空，则不存在公共节点
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode pl = pHead1;
        ListNode ps = pHead2;
        int lenA = 0;
        int lenB = 0;
        //分别统计两个链表的长度
        while(pl!=null) {
            pl = pl.next;
            lenA++;
        }
        while(ps!=null) {
            ps = ps.next;
            lenB++;
        }
        //将pl和ps重新指向两个链表头结点，因为遍历完他们都指向空了
        pl = pHead1;
        ps = pHead2;
        //求出两个链表的长度差
        int len = lenA-lenB;
        //无论如何，令pl指针指向长链表的头，如果len<0说明pHead2是长链表
        if(len<0) {
            pl = pHead2;
            ps = pHead1;
            len = lenB-lenA;
        }
        //先遍历长链表的长度差个节点，保证两个链表的长度相同，
        //这样同时遍历，才能找到公共节点
        for(int i = 0;i < len;i++) {
            pl = pl.next;
        }
        while(pl!=ps && pl!=null && ps!=null) {
            pl = pl.next;
            ps = ps.next;
        }
        //程序走到这里有两种可能
        //1.没找到公共节点，链表遍历完了，此时就返回null
        //2.找到公共节点了，此时的pl和ps共同指向第一个公共节点
        if(pl != ps || pl == null) {
            return null;
        }else{
            return pl;
        }
    }
}
