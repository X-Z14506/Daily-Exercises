package first.Day09;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-01
 * Time:19:48
 */
public class Test {
    public static void main1(String[] args) {
        String x = "fmn";
        x.toUpperCase();//x的内容未发生变化
        String z = x.toUpperCase();
        System.out.println(z);//FMN
        String y = x.replace('f','F');
        System.out.println(y);//Fmn
        y = y+"wxy";
        System.out.println(y);//Fmnwxy
    }
///////////////////////////////////////////////////////////////////

    String str = new String("hello");
    char[] ch = {'a','b'};

    public static void main2(String[] args) {
        Test x = new Test();
        x.change(x.str,x.ch);
        System.out.println(x.str+" and");//hello and
        System.out.println(x.ch);//cb
    }

    private void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'c';
    }
//////////////////////////////////////////////////////////////////////

    public static void main3(String[] args) {
        ((Test)null).testMethod();
    }
    public static void testMethod() {
        System.out.println("testMethod");
    }
    /*
     这个是可以正常运行的，如果把static去掉就会空指针异常
     1: null可以转化为任何类型
     2: private 只是权限声明
     2：static静态关键字 仅仅意味着可以不用实例化这个类
     通过类名.方法名就可以访问
     当然也可以通过实例化类的对象后 通过对象.方法名
     但是不能通过this关键字，因为this是指本实例中的方法被static声明的方法属于类的方法
     */

    public static void main(String[] args) {
        int i = 0;
        Integer j = new Integer(0);
        System.out.println(i==j);//true
        System.out.println(j.equals(i));//true
        //自动拆箱
    }

}
