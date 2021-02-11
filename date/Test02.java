package date;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-20
 * Time:15:32
 */

/*
       获取自1970年1月1日00:00:00 000 到当前系统时间的总毫秒数
       long nowTime = System.currentTimeMillis();
       1秒 = 1000毫秒

简单总结一下System类的相关属性和方法（带括号的是方法，不带括号的是属性）
System.out   【out是System类的静态变量】
System.exit(0);  退出JVM
System.currentTimeMillis(); 获取自1970年1月1日00:00:00 000 到当前系统时间的总毫秒数
System.gc() 建议启动垃圾回收器
System.out.println（）【println（）方法不是System类的，是PrintStream类的方法】


 */
public class Test02 {
    public static void main(String[] args) {
        long nowTime = System.currentTimeMillis();
        System.out.println(nowTime);//1608449677742

        //统计一个方法耗时
        //执行前记录一下毫秒数，执行后记录下毫秒数，相减
        long begin =System.currentTimeMillis();
        print();
        long end = System.currentTimeMillis();
        System.out.println("该方法执行时间：" + (end-begin)+"毫秒");
    }

    //统计一个方法执行所耗费的时间
    public static  void print() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
