package first.Day02201123;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-25
 * Time:19:09
 */
public class Test3 {
    public static void main1(String[] args) {
        Test3 test3 = new Test3();
        test3.method();
    }

    private int method() {
        /**
         * 以下代码错误，因为static不能修饰局部变量
         * static int i = 0;
           i++;
           return i;
         **/
        int j = 0;
        return j;
    }

}


class Base{
    Base() {
        System.out.print("Base");
    }
}
class Add extends Base {
    public static void main(String[] args) {
        new Add();
        new Base(); //BaseBase
    }
}

