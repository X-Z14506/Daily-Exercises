package second.day07;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-11
 * Time:23:11
 */

/*
学分绩点

输入：
5
4 3 4 2 3
91 88 72 69 56

输出：
2.52
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strings1 = sc.nextLine().split(" ");
        String[] strings2 = sc.nextLine().split(" ");
        //所有课程学分之和
        double scoreSum = 0;
        //所有学科绩点之和
        double scorePointSum = 0;
        for (int i = 0;i < n;i++) {
            scoreSum += Integer.parseInt(strings1[i]);
            scorePointSum += scorePoint(Integer.parseInt(strings2[i])) * Integer.parseInt(strings1[i]);
        }
        double ret = scorePointSum/scoreSum;
        System.out.println(String.format("%.2f",ret));
    }

    public static double scorePoint(int i) {
        if (i>=90 && i<=100) {
            return 4.0;
        }else if (i>=85 && i<=89) {
            return 3.7;
        }else if (i>=82 && i<=84) {
            return 3.3;
        }else if (i>=78 && i<=81) {
            return 3.0;
        }else if (i>=75 && i<=77) {
            return 2.7;
        }else if (i>=72 && i<=74) {
            return 2.3;
        }else if (i>=68 && i<=71) {
            return 2.0;
        }else if (i>=64 && i<=67) {
            return 1.5;
        }else if (i>=60 && i<=63) {
            return 1.0;
        }
        return 0;
    }
}
