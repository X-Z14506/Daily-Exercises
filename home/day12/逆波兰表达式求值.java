package home.day12;

import java.util.Stack;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-16
 * Time:20:39
 */
public class 逆波兰表达式求值 {
    public static void main(String[] args) {
        String[] s = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = evalRPN(s);
        System.out.println(i);
    }
    public static int evalRPN(String[] tokens) {
        if(tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stackNum = new Stack<>();
        int ret = 0;
        for(int i = 0;i < tokens.length;i++) {
            char c = tokens[i].charAt(0);
            //此处要考虑tokens[i]为负数或者多位数
            if(Character.isDigit(c) || tokens[i].length()>1) {
                stackNum.push(Integer.valueOf(tokens[i]));
            }else if (!Character.isDigit(c) && !stackNum.isEmpty()) {
                int num1 = stackNum.pop();
                int num2 = stackNum.pop();
                ret = operator(num1,num2,c);
                stackNum.push(ret);
            }
        }
        return ret;

    }
    //操作两数的运算
    private static int operator(int num1, int num2,char operator) {
        int ret;
        switch (operator) {
            case '+' : ret = num1+num2;break;
            case '-' : ret = num2-num1;break;
            case '*' : ret = num1*num2;break;
            case '/' : ret = num2/num1;break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return ret;
    }
}
