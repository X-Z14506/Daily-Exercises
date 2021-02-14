package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:17:27
 */

/*
    求5人平均成绩，结果保留一位小数
    输入：75 80 43 67 96
    输出：72.2

 */
public class Main27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        double sum = 0;
        for (int i = 0;i < s.length;i++) {
            sum += Double.parseDouble(s[i]);
        }
        System.out.println(String.format("%.1f",sum/5));
    }
}
