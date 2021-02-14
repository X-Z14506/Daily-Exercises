package firstStage02;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:19:26
 */

/*

        题目描述
        输入n科成绩（浮点数表示），统计其中的最高分，最低分以及平均分。

        输入描述:
        两行，

        第1行，正整数n（1≤n≤100）

        第2行，n科成绩（范围0.0~100.0），用空格分隔。
        输出描述:
        输出一行，三个浮点数，分别表示，最高分，最低分以及平均分（小数点后保留2位），用空格分隔。

        输入：5
             99.5 100.0 22.0 60.0 88.5

        输出：100.00 22.00 74.00

 */


public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] s = new double[n];
        for (int i = 0; i < n;i++) {
            double score = Double.parseDouble(scanner.next());
            s[i] = score;
        }
        double sum = 0;
        double max = s[s.length-1];
        double min = s[0];
        for (int i = 0; i < s.length;i++) {
            sum += s[i];
        }
        double avg = sum/s.length;
        System.out.println(String.format("%.2f",max)+" "+String.format("%.2f",min)+" "+String.format("%.2f",avg));
    }
}
