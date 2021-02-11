package integer;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-20
 * Time:11:19
 */

/**
 * 自动拆箱和自动装箱机制：好处是方便编程
 * JDK1.5之后才有的机制
 *
 * 自动装箱：基本数据类型自动转换为包装类
 * 自动拆箱：包装类自动转换为基本数据类型
 */
public class IntegerTest02 {
    public static void main(String[] args) {

        //自动装箱
        Integer m = 1000;
        //自动拆箱
        int n = m;
        System.out.println(m);//1000   Integer类型的
        System.out.println(n);//1000   int类型的

        //z是一个引用，保存的是对象的内存地址
        //分析： 为什么没有报错？
        //     +两边要求是基本数据类型的数字，z是包装类，不是基本数据类型，但是自动拆箱机制将z转换为基本数据类型
        //在JDK1.5之前这样写会编译报错，因为之前没有自动拆箱机制
        Integer z = 1000;//等同于Integer z = new Integer(1000);
        System.out.println(z+1);//1001

        Integer a = 1000;
        Integer b = 1000;
        //  ==这个运算符不会触发自动拆箱机制，只有+-*/等运算的时候会触发自动拆箱机制
        System.out.println(a == b);//==比较的是对象的内存地址，false


        /**
         * Integer包装类里非常重要的面试题
         * 分析以下程序是为什么？
         * 原因：integer3和integer4变量中保存的对象的内存地址是一样的
         *
         * java中为了提高程序的执行效率，将[-128,127]之间所有的包装对象提前创建好，
         * 放到一个方法区的"整数型常量池"当中了，目的是只要用这个区间的数据不需要再new了，
         * 直接从整数型常量池中取出来
         */

        Integer integer1 = 128;
        Integer integer2 = 128;
        System.out.println(integer1==integer2);//false

        Integer integer3 = 127;
        Integer integer4 = 127;
        System.out.println(integer3==integer4);//true


        //手动装箱
        Integer x = new Integer(1000);
        //手动拆箱
        int y = x.intValue();
        System.out.println(y);//1000
    }
}
