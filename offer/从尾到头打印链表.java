import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //先按顺序压栈
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
