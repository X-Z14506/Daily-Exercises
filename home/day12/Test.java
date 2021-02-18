package home.day12;

import org.omg.CORBA.MARSHAL;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-16
 * Time:19:28
 */
public class Test {
    public static void main(String[] args) {
        double d = Math.cos(Math.toDegrees(60));
        double f = Math.cos(Math.toRadians(60));
        System.out.println(d);
        System.out.println(f);
        String s = "-11";
        System.out.println(Integer.valueOf(s));
    }
}
