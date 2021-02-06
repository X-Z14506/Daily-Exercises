package first.Day02201123;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-24
 * Time:20:36
 */
public class Test {
    public static void main1(String[] args) {
        System.out.println(isAdmin("Admin")); // false
    }

    private static boolean isAdmin(String admin) {
        return admin.toLowerCase()=="admin";
    }

    public static void main(String[] args) {
        Test1 test1 = null;
        test1.hello();
    }
}

class Test1 {
    public static void hello() {
        System.out.println("hello");
    }
}
abstract class Shape{
    abstract public void draw();//抽象方法没有方法体，即抽象方法没有{}，不能执行具体代码，
    // 抽象类存在的最大意义就是为了被继承，抽象类本身不能被实例化，要想使用，只能创建该抽象类的子类，然后让子类重写抽象类中的抽象方法
}