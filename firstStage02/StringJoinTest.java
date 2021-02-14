package firstStage02;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:20:33
 */
public class StringJoinTest {
    public static void main(String[] args) {
        //下列代码String.join（）方法是用delimiter将elements连接起来
        System.out.println(String.join(" ","Hello","World","!"));//Hello World !
        System.out.println(String.join("","Hello","World","!"));

        //Collections.nCopies(num-i," ")方法作用：将num-i个空格字符串连接起来
    }
}
