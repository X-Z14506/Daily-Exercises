package second.day16;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-21
 * Time:18:07
 */

/*
计算球的半径和体积
 */
public class Main2 {

    public static void main(String []args){
        Scanner sc =new Scanner(System.in);
        while(sc.hasNextLine()){
            String s =sc.nextLine();
            String [] c=s.split(" ");
            double []b=new double[6];
            for(int i=0;i<6;i++){              //本题意在考察库函数基本用法
                b[i]=Double.parseDouble(c[i]);
            }
            //已知球心和表面上一点坐标 球的半径为 ： r=((x2-x1)^2 + (y2-y1)^2 + (z2-z1)^2)^0.5
            double r=Math.pow(Math.pow((b[3]-b[0]),2)+Math.pow((b[4]-b[1]),2)+Math.pow((b[5]-b[2]),2),0.5);
            double v = Math.acos(-1)*4*r*r*r/3;
            System.out.println(String.format("%.3f",r)+" "+String.format("%.3f",v));
        }
    }

}
