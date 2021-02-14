package firstStage01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:20:20
 */

/*
    题目描述
    期中考试开始了，大家都想取得好成绩，争夺前五名。从键盘输入n个学生成绩（不超过40个），输出每组排在前五高的成绩。

    输入描述:
    两行，第一行输入一个整数，表示n个学生（>=5），第二行输入n个学生成绩（整数表示，范围0~100），用空格分隔。
    输出描述:
    一行，输出成绩最高的前五个，用空格分隔。

    输入：6
         99 45 78 67 72 88

    输出：99 88 78 72 67
 */
public class Main32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        if (n>=40){
            return;
        }else {

            for (int i = 0;i < n;i++) {
                int score = scanner.nextInt();
                scores[i] = score;
            }
        }
        Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));
        for (int i = n-1;i >= n-5;i--) {
            System.out.print(scores[i]+" ");
        }
    }
}
