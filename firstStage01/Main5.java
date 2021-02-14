package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-28
 * Time:15:47
 */
/*
    题目描述
    依次输入一个学生的学号，以及3科（C语言，数学，英语）成绩，在屏幕上输出该学生的学号，3科成绩。
    输入描述:
    学号以及3科成绩，学号和成绩之间用英文分号隔开，成绩之间用英文逗号隔开。
    输出描述:
    学号，3科成绩，输出格式详见输出样例。
    示例1
    输入
    17140216;80.845,90.55,100.00
    输出
    The each subject score of  No. 17140216 is 80.85, 90.55, 100.00.
 */
public class Main5 {
    //这断代码有问题
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int no = scanner.nextInt();
        double[] score = new double[3];
        for (int i = 0; i < score.length; i++) {
            score[i] = scanner.nextDouble();
        }
        System.out.print("The each subject score of  No. " + no + " is ");
        for (int i = 0; i < score.length - 1; i++) {
            System.out.print(score[i] + ",");
        }
        System.out.print(score[2] + ".");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] a = s.nextLine().split("[;,]");//split表示输入的字符以;,分割成String数组，多个字符，要带中括号[]
        int id = Integer.parseInt(a[0]);
        double s1 = Double.parseDouble(a[1]);
        double s2 = Double.parseDouble(a[2]);
        double s3 = Double.parseDouble(a[3]);
        System.out.print("The each subject score of  No. " + id + " is " + String.format("%.2f", s1) + ", " + String.format("%.2f", s2) + ", " + String.format("%.2f", s3) + ".");
    }

    public static void main3(String[] args) {
        String s5 = "17140216;80.845,90.55,100.00";
        String[] b = s5.split("[;,.]");
        for (int i = 0;i < b.length;i++) {
            System.out.println(b[i]);
        }
        /*
           17140216
            80
            845
            90
            55
            100
            00
         */

        int a = 500;
        String x = "600";
        Double d = Double.parseDouble(x);
        System.out.println(String.format("%.3f",d));//600.000
        System.out.println(d);//600.0
        String s = String.valueOf(a);
        System.out.println(s);//500
    }
}
