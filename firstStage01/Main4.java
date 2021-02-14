package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:15:23
 */

/*
        输入3科成绩，然后把三科成绩输出，成绩为整数形式。

        输入描述:
        一行，3科成绩，用空格分隔，范围（0~100）。

        输出描述:
        一行，把3科成绩显示出来，输出格式详见输出样例。

        示例1

        输入
        60 80 90

        输出
        score1=60,score2=80,score3=90
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] score = new int[3];
        for (int i = 0;i < score.length;i++) {
            score[i] = input.nextInt();
        }
        for (int i = 0;i < score.length-1;i++) {
            System.out.print("score"+(i+1)+"="+score[i]+",");
        }
        System.out.println("score"+3+"="+score[2]);
    }
}
