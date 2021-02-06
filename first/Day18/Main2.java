package first.Day18;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-12
 * Time:12:50
 */

/*
            题目描述：

            一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。该计划如下：我每天给你10 万元，你第一天给我1 分钱，第二天2 分钱，
            第三天4 分钱……这样交换 30 天后，百万富翁交出了多少钱？陌生人交出了多少钱？（注意一个是万元，一个是分）

            输入：

            该题没有输入

            输出：

            输出两个整数，分别代表百万富翁交出的钱和陌生人交出的钱，富翁交出的钱以万元作单位，陌生人交出的钱以分作单位。


            分析：
            题目要求输出富翁用万元作单位，陌生人用分作单位，但判断正好是相反的！！
            pow函数返回的是double类型的，需要进行强制类型转换
            (int)pow(2, 30);
 */
public class Main2 {
    public static void main(String[] args) {
        long money1 = 0;
        long money2 = 0;
        for (int i = 1; i <= 30; i++) {
            money1 += 10;
            money2 += (long)Math.pow(2,i-1);
        }
        System.out.println(money1+"万元"+ " " + money2+"分");//300万元 1073741823分
    }
}
