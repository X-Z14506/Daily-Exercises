package first.Day06;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-28
 * Time:10:30
 */
public class Test03 {
    String str = new String("good");
    char[] ch = {'a','b','c'};
    public static void main1(String[] args) {
       Test03 test03 = new Test03();
       test03.change(test03.str,test03.ch);
        System.out.print(test03.str+"and");
        System.out.print(test03.ch);
    }

    private void change(String str, char[] ch) {
        str ="test ok";
        ch[0] ='g';
        System.out.print(str+"and");
        System.out.print(ch);
        System.out.println();
    }

    public static void main(String[] args) {
        int a = 10,b=20;
        int x,y;
        x=5>>2;
        y=x>>>2;
        System.out.println(y);
        //按位或 |: 如果两个二进制位都是 0, 则结果为 0, 否则结果为 1.
        System.out.println(a|b);//30
        //按位与 &: 如果两个二进制位都是 1, 则结果为 1, 否则结果为 0.
        System.out.println(a&b);//0
    }

}
