package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-20
 * Time:15:08
 */


/**
 * 怎样获取系统当前时间
 * String--》Date
 * Date--》String
 */

public class Test01 {
    public static void main(String[] args) throws ParseException {
        //获得系统当前时间（精确到毫秒的当前时间）
        Date nowTime = new Date();
        //java.util.Date类的toString（）方法已经被重写了
        //输出的应该不是一个对象的内存地址了，而是一个日期字符串
        System.out.println(nowTime);//Sun Dec 20 15:11:44 CST 2020

        /**
         * 日期格式化：将日期类型Date，按指定的格式进行转换，Date--转换成具有一定格式的日期字符串-->String
         * SimpleDateFormat事java.text包下的，专门负责日期格式化的
         * yyyy 年
         * MM 月
         * dd 日
         * HH 时
         * mm 分
         * ss 秒
         * SSS 毫秒（毫秒最高999，1000毫秒为1秒）
         */
        Date nowTime1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String time = simpleDateFormat.format(nowTime1);
        System.out.println(time);//2020-12-20 15:22:48 793

        //有一个日期字符串String，怎么转换成Date类型
        String time1 = "2008-08-08 16:54:50 586";
        //注意：字符串的日期格式和SimpleDateFormat对象指定的日期格式要一致，不然会出现异常：ParseException
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date date = simpleDateFormat1.parse(time1);
        System.out.println(date);//Fri Aug 08 16:54:50 CST 2008

    }
}
