package firstStage01;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:15:17
 */
/*
    KiKi写了一个输出“Hello world!”的程序，
    BoBo老师告诉他printf函数有返回值，
    你能帮他写个程序输出printf(“Hello world!”)的返回值吗？
 */
public class Main3 {
    public static void main(String[] args) {
        String a = "Hello world!";
        System.out.println(a);
        System.out.printf("%d",a.length());
    }
}
