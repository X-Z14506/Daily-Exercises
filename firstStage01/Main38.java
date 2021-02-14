package firstStage01;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:16:04
 */

/*
    题目描述
        KiKi想知道已经给出的三条边a，b，c能否构成三角形，如果能构成三角形，判断三角形的类型（等边三角形、等腰三角形或普通三角形）。
        输入描述:
        题目有多组输入数据，每一行输入三个a，b，c(0<a,b,c<1000)，作为三角形的三个边，用空格分隔。
        输出描述:
        针对每组输入数据，输出占一行，如果能构成三角形，等边三角形则输出“Equilateral triangle!”，等腰三角形则输出“Isosceles triangle!”，
        其余的三角形则输出“Ordinary triangle!”，反之输出“Not a triangle!”。

        输入：2 3 2
             3 3 3
        输出：Isosceles triangle!
             Equilateral triangle!
 */
public class Main38 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] strings = s.nextLine().split(" ");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            int c = Integer.parseInt(strings[2]);
            if (a+b>c && a+c>b && b+c>a) {
                if (a==b && b==c) {
                    System.out.println("Equilateral triangle!");
                }else if (a==b || a==c || b==c) {
                    System.out.println("Isosceles triangle!");
                }else {
                    System.out.println("Ordinary triangle!");
                }
            }else {
                System.out.println("Not a triangle!");
            }
        }

    }
}
