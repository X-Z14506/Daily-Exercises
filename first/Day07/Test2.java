package first.Day07;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-28
 * Time:12:40
 */


//静态代码块先执行，子类继承父类，创建一个子类对象，先执行父类的方法，在执行子类的方法
class A {
    public A(){
        System.out.println("A");
    }
    static {
        System.out.println("static A");
    }
}
public class Test2 extends A{
    public Test2() {
        System.out.println("B");
    }
    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new Test2();
    }
}
