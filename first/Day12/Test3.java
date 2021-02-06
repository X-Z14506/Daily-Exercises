package first.Day12;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-06
 * Time:8:55
 */
public class Test3 {
    public static void main(String[] args) {
      test();
    }
    public static void add(Byte b) {
        b=b++;
    }
    public static void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a + " ");
        add(b);
        System.out.println(b + " ");
    }
}
