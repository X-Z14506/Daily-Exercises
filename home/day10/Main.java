package home.day10;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:19:57
 */

/*
多态的运行：
    实例方法：动态绑定，即引用的变量实际引用的类型是哪一个，则运行哪一个实例方法。在运行时由java虚拟机动态决定。
    静态方法：静态绑定，即引用的变量所声明的类型是哪一个，则运行哪一个静态方法。在编译阶段就已经做出了决定。
    成员变量（包括静态变量和实例变量）：静态绑定，即引用变量所声明的类型是哪一个，则运行哪个成员变量。在编译阶段就已经做出了决定。
 */
public class Main {
    void say() {
        System.out.println("我是Main类的方法");
    }
    static void eat() {
        System.out.println("Main吃饭！！！");
    }

    public static void main(String[] args) {

        Main m = new C();
        m.say();//我是C类的方法  new哪个类，调用实例方法就是调用该类的（动态绑定）
        m.eat();//Main吃饭！！！  new哪个类，调用静态方法就是调用引用变量声明的类（静态绑定）
    }
}
class C extends Main{
    @Override
    void say() {
        System.out.println("我是C类的方法");
    }
    static void eat() {
        System.out.println("C吃饭！！！");
    }
}
