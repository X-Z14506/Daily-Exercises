package first.Day11;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-04
 * Time:7:55
 */
public class Test02 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run(){
                pong();
            }
        };
        t.run();
        System.out.println("ping");
    }

    private static void pong() {
        System.out.println("pong");
    }
}
