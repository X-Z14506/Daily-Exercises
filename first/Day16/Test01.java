package first.Day16;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-10
 * Time:7:49
 */
public class Test01 {
    public static void main(String[] args) {
        int i = 5;
        int s = (i++)+(++i)+(i--)+(--i);
        System.out.println(s);
    }
}
class A{
    Object object = new Test01();
}
