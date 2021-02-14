package firstStage01;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:18:18
 */

/*
    请计算表达式“(-8+22)×a-10+c÷2”，其中，a = 40，c = 212
 */
public class Main12 {
    public static void main(String[] args) {
        int a = 40;
        int c = 212;
        int ret = (int)((-8+22)*a-10+c/2);
        System.out.println(ret);
    }
}
