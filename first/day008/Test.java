package first.day008;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-01
 * Time:10:05
 */
public class Test {
    static int i = 6;
    static {
        i+=9;
    };

    public static void main(String[] args) {
        System.out.println("i = "+ i);//i = 5
    }
    static {
        i/=3;
    };
}
