package first.Day13;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-07
 * Time:8:15
 */
public class Test1 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                dianping();
            }
        };
        t.run();
        System.out.println("dazhong");
    }
    static void dianping() {
        System.out.println("dianping");
    }
}
