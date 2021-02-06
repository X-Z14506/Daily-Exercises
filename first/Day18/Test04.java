package first.Day18;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-12
 * Time:9:51
 */
public class Test04 {
    public String str = "6";

    public static void main(String[] args) {
        Test04 test04 = new Test04();
        test04.change(test04.str);
        System.out.println(test04.str);//6
    }
    public void change(String str) {
        str = "10";
    }
}
