package firstStage01;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:19:05
 */

/*
        变种水仙花数 - Lily Number：把任意的数字，从中间拆分成两个数字，比如1461 可以拆分成（1和461）,（14和61）,（146和1),
        如果所有拆分后的乘积之和等于自身，则是一个Lily Number。
        例如：
        655 = 6 * 55 + 65 * 5
        1461 = 1*461 + 14*61 + 146*1

        求出 5位数中的所有 Lily Number。

        输入描述:
        无
        输出描述:
        一行，5位数中的所有 Lily Number，每两个数之间间隔一个空格。
 */
public class Main31 {
    public static void main1(String[] args) {
        for (int i = 10000;i <= 99999; i++) {
            //将整数转换为字符串
            String s = Integer.toString(i);
            //求出4种乘法的乘积
            //第一个数字*后四位数字
            int first = Integer.parseInt(s.substring(0,1)) * Integer.parseInt(s.substring(1,5));
            //前两位数字*后三位数字
            int second = Integer.parseInt(s.substring(0,2)) * Integer.parseInt(s.substring(2,5));
            //前三位数字*后两位数字
            int third = Integer.parseInt(s.substring(0,3)) * Integer.parseInt(s.substring(3,5));
            //前四位数字*最后一个数字
            int fourth = Integer.parseInt(s.substring(0,4)) * Integer.parseInt(s.substring(4,5));

            //判断是否为Lily Number
            if (first+second+third+fourth == i) {
                System.out.print(i+" ");//14610 16420 23610 34420 65500
            }
        }
    }

    public static void main(String[] args) {
        int a, b, c, d, e;
        int r1, r2, r3, r4;

        for (int i = 10000; i < 99999; i++) {
            r1 = (i / 10000) * (i % 10000);
            r2 = (i / 1000) * (i % 1000);
            r3 = (i / 100) * (i % 100);
            r4 = (i / 10) * (i % 10);

            if (i == (r1 + r2 + r3 + r4)) {
                System.out.print(i);
                System.out.print(" ");
            }

        }
    }
}
