package second.day12;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-16
 * Time:22:23
 */
public class Test08 {
    public static void main(String[] args) throws InterruptedException {
        final Object obj = new Object();
        Thread t1 = new Thread() {
            public void run() {
                synchronized (obj) {
                    try {
                        obj.wait();
                        System.out.println("Thread 1 wake up.");
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread() {
            public void run() {
                synchronized (obj) {
                    obj.notifyAll();
                    System.out.println("Thread 2 sent notify");
                }
            }
        };
        t2.start();
    }
}
