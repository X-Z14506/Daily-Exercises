package second.day17;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-21
 * Time:22:42
 */

/*
百万富翁问题
 */

public class Main {
    public static void main(String[] args) {
        //百万富翁每天天交出的钱
        long sum1 = 0;
        //陌生人交的钱
        long sum2 = 0;
        for (int i = 0;i < 30;i++) {
            sum1+=10;
            sum2+=Math.pow(2,i);
        }
        System.out.println(sum1+"万元"+ " " + sum2+"分");
    }
}
