package date;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-20
 * Time:15:49
 */
public class Test03 {
    public static void main(String[] args) {
        Date date = new Date(1);//参数是一个毫秒
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = simpleDateFormat.format(date);
        //北京是东8区，不是格林威治时间，差八个小时 所以是8点
        System.out.println(strTime);//1970-01-01 08:00:00 001

        //获取昨天此时的时间
        Date date1 = new Date(System.currentTimeMillis() - 1000*60*60*24);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String string = simpleDateFormat1.format(date1);
        System.out.println(string);//2020-12-19 15:58:55 818

        //获取一周前此时的时间
        Date date2 =new Date(System.currentTimeMillis()- 1000*60*60*24*7);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String string2 = simpleDateFormat2.format(date2);
        System.out.println(string2);//2020-12-13 16:02:39 050
    }
}
