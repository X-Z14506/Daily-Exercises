/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

// push操作就直接往stack1中push，
// pop操作需要分类一下：如果stack2为空，那么需要将stack1中的数据全部转移到stack2中，然后在对stack2进行pop，如果stack2不为空，直接pop就ok。
public class 两个栈实现一个队列 {
    //模拟入队列的栈
    Stack<Integer> stack1 = new Stack<Integer>();
    //模拟出队列的栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        //如果stack2为空，那么需要将stack1中的数据全部转移到stack2中，然后在对stack2栈顶元素弹出
        if (stack2.empty()) {
            while (!stack1.empty()) {
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
        //如果stack2不为空，直接将stack2的栈顶元素弹出
        return stack2.pop();
    }
}
