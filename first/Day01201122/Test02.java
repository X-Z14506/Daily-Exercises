package first.Day01201122;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-24
 * Time:17:35
 */
public class Test02 {
    public static void main(String[] args) {
        Test mv = new Test();
        Thread t1 = new ThreadExample(mv);
        Thread t2 = new ThreadExample(mv);
        Thread t3 = new ThreadExample(mv);
        t1.start();
        t2.start();
        t3.start();
    }
}
class Test {
    private int data;
    int result = 0;
    public void m() {
        result+=2;
        data+=2;
        System.out.print(result+" "+data);
    }
}
class ThreadExample extends Thread {
    private Test mv;
    public ThreadExample(Test mv) {
        this.mv = mv;
    }
    public void run() {
        synchronized (mv) {
            mv.m();
        }
    }
}
