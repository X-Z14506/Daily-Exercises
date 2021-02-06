package second.day03;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-06
 * Time:18:57
 */
public class Test09 {
    public static void main(String[] args) {
        int ret = foo(20,13);
        System.out.println(ret);
    }
    static int foo(int x,int y) {
        if (x<=0 || y<= 0) {
            return 1;
        }else {
            return 3*foo(x-6,y/2);
        }
    }
}
