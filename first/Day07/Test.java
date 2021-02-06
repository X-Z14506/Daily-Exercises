package first.Day07;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-28
 * Time:12:35
 */
public class Test {
    public static void main(String[] args) {
        int a =10;
        System.out.println(test(a));//30
    }

    private static int test(int a) {
        try {
            a+=10;
            return a;
        }catch (RuntimeException e) {
        }catch (Exception e) {
        }
        finally {
            a+=10;
            return a;
        }
    }
}
