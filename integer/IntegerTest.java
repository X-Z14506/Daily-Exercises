package integer;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Locale;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-20
 * Time:10:58
 */
public class IntegerTest {
    public static void main(String[] args) {

        //JDK9之后不建议使用这个构造方法，已经过时
        //将数字100转换成Integer包装类型（int-->Integer）
        Integer x = new Integer(100);
        System.out.println(x);//100

        //将String类型的数字转换造成Integer包装类型(String-->Integer)
        Integer y = new Integer("123");
        System.out.println(y);//123

        Double a = new Double(1.23);
        System.out.println(a);//1.23

        Double b = new Double("3.14");
        System.out.println(b);//3.14

        /**
         * 注意：编译时候没问题，符合java语法，运行会抛出 java.lang.NumberFormatException（数字格式化异常）
         * 不是一个数字不能包装成Integer类型
         */
      /*  try {
            Integer c = new Integer("中文");
            System.out.println(c);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误");
        }//错误 java.lang.NumberFormatException*/


        //通过访问包装类的常量，获得最大值和最小值
        System.out.println("int的最大值："+Integer.MAX_VALUE);//2147483647
        System.out.println("int的最小值："+Integer.MIN_VALUE);//-2147483648
        System.out.println("byte的最大值："+Byte.MAX_VALUE);//127
        System.out.println("byte的最小值："+Byte.MIN_VALUE);//-128
        System.out.println("char的最大值："+Long.MAX_VALUE);//9223372036854775807
        System.out.println("char的最小值："+ Long.MIN_VALUE);//-9223372036854775808

        //重点方法
        //static int parseInt(String s)  静态方法，传参String，返回int
        int retValue = Integer.parseInt("100");
        System.out.println(retValue+1);//101
        double retValue2 = Double.parseDouble("3.14");
        System.out.println(retValue2+1);//4.140000000000001
        float retValue3 = Float.parseFloat("1.0");
        System.out.println(retValue3+1);//2.0
    }
}
