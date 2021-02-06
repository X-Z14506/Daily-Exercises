package first.Day08;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-30
 * Time:9:29
 */
public class Test {
    private static int x = 100;

    public static void main(String[] args) {
        System.out.println(Math.round(11.5));
        Test hs1 = new Test();
        hs1.x++;
        Test hs2 = new Test();
        hs2.x++;
        hs1 = new Test();
        hs1.x++;
        Test.x--;
        System.out.println("x="+x);//x=102
    }
}

