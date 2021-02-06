package first.Day18;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-12
 * Time:10:02
 */
public class Test07 {
    public static void main(String[] args) {
        Integer i1 = 59;
        int i2 = 59;
        Integer i3 = Integer.valueOf(59);
        Integer i4 = new Integer(59);
        System.out.println(i1==i3);//true
        System.out.println(i2==i4);//true
        System.out.println(i1==i2);//true
        System.out.println(i3==i4);//false
    }
}
