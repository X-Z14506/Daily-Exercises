package home.day01;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-14
 * Time:14:10
 */
public class Mystery {
    public static void main(String[] args) {
        m(1234);
    }
    public static void m(int x) {
        System.out.print(x%10);
        if (x/10!=0) {
            m(x/10);
        }
        System.out.print(x%10);
    }
}
