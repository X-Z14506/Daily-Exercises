package first.Day17;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-11
 * Time:8:19
 */
public class Test10 {
    public String name = "abc";
    public static void main(String[] args) {
        Test10 test = new Test10();
        Test10 test1 = new Test10();
        System.out.println(test.equals(test1)+","+ test.name.equals(test1.name));
    }
}
