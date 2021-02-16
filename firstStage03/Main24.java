package firstStage03;

import java.awt.*;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-07
 * Time:15:34
 */
/*
题目描述
KiKi理解了继承可以让代码重用，他现在定义一个基类shape，私有数据为坐标点x,y,
      由它派生Rectangle类和Circle类，它们都有成员函数GetArea()求面积。
      派生类Rectangle类有数据：矩形的长和宽；
      派生类Circle类有数据：圆的半径。Rectangle类又派生正方形Square类，定义各类并测试。
      输入三组数据，分别是矩形的长和宽、圆的半径、正方形的边长，输出三组数据，分别是矩形、圆、正方形的面积。圆周率按3.14计算。
输入描述:
输入三行，
第一行为矩形的长和宽，
第二行为圆的半径，
第三行为正方形的边长。
输出描述:
三行，分别是矩形、圆、正方形的面积。

输入：
7 8
10
5

输出：
56
314
25

 */
public class Main24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int x = Integer.parseInt(strings[0]);
        int y = Integer.parseInt(strings[1]);
        int r = Integer.parseInt(sc.nextLine());
        int a = Integer.parseInt(sc.nextLine());
        //Shape shape = new Shape(x,y);
        Rectangle rectangle = new Rectangle(x,y);
        int ret  = rectangle.GetArea();
        Circle circle = new Circle(r);
        double ret2 =  circle.GetArea();
        Square square = new Square(a);
        int ret3 = square.GetArea();

        System.out.println(ret);
        System.out.println(ret2);
        System.out.println(ret3);
    }
}
class Shape{
    private  int x;
    private  int y;

    public Shape() {

    }

}
class Rectangle extends Shape {
    int x;
    int y;

    public Rectangle() {

    }
    public Rectangle(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }

    public int GetArea() {
        return this.x * this.y;
    }
}
class Circle extends Shape {
    int r;
    public Circle (int r) {
        this.r = r;
    }
    public double GetArea() {
        return 3.14* this.r * this.r;
    }
}
class Square extends Rectangle {
    int a ;
    public Square (int a) {
        this.a = a;
    }
    public int GetArea() {
        return a*a;
    }
}