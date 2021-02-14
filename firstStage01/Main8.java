package firstStage01;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:17:26
 */

/*
        BoBo教KiKi字符常量或字符变量表示的字符在内存中以ASCII码形式存储。BoBo出了一个问题给KiKi，转换以下ASCII码为对应字符并输出他们。
        73, 32, 99, 97, 110, 32, 100, 111, 32, 105, 116 , 33
 */
public class Main8 {
    public static void main(String[] args) {
        char[] chars = {73, 32, 99, 97, 110, 32, 100, 111, 32, 105, 116 , 33};
        for (char c : chars) {
            System.out.printf("%c",c);//I can do it!
        }
    }
}
