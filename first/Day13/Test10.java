package first.Day13;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-07
 * Time:8:08
 */

abstract class Animal{
    abstract void say();
}

public class Test10 extends Animal {
    public Test10() {
        System.out.println("111");
    }

    public static void main(String[] args) {
        Test10 t = new Test10();
    }

    //继承一个抽象类，必须实现抽象类里面的方法，不然会报错
    @Override
    void say() {

    }
}
