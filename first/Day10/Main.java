package first.Day10;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-03
 * Time:10:02
 */
public class Main {
    public static void main(String[] args) {
        byte b1 = 1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6 = b4+b5;
        System.out.println(b1+b2);//3
        System.out.println(b6);//10
        b3=(byte)(b1+b2);//java不兼容类型，从int转换到byte可能会有损失，b1，b2是int类型，b3是byte类型
        System.out.println(b3+b6);
    }


    /////////////////////////////////////////////////////////////////////////

    public static void main1(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        op(a,b);
        System.out.println(a+" "+b);//AB B

    }

    private static void op(StringBuffer a, StringBuffer b) {
        a.append(b);
        b=a;
    }




}
