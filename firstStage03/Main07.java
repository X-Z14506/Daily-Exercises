package firstStage03;

import sun.text.resources.en.JavaTimeSupplementary_en_SG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-04
 * Time:23:01
 */

/*
杨辉三角：杨辉三角，本质上是二项式(a+b)的n次方展开后各项的系数排成的三角形。
其性质包括：每行的端点数为1， 一个数也为1；每个数等于它左上方和上方的两数之和。

输入：
输出：
    1
    1    1
    1    2    1
    1    3    3    1
    1    4    6    4    1
    1    5   10   10    5    1
 */
public class Main07 {
    //法三
    public static void main3(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i =0;i < n;i++){
            for(int j = 0;j <= i;j++){
                if(j == 0||j == i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i - 1][j -1]+arr[i - 1][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < n;i++){
            for(int j = 0;j <i + 1;j++){
                int len = (arr[i][j] + "").length();
                for(int k = 0;k < 5-len;k++){
                    sb.append(" ");
                }
                System.out.print(sb.toString() + arr[i][j]);
                sb.setLength(0);
            }
            if(i != n -1){
                System.out.println();
            }
        }
    }
    //法二：
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a[][]=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i)a[i][j]=1;
                else a[i][j]=a[i-1][j-1]+a[i-1][j];
                System.out.print(String.format("%5d",a[i][j]));
            }
            System.out.println("");
        }
    }
    //法一
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        //将数存入二维数组，方便输出，并且数组默认初始值是0
        int[][] arr = new int[n][n];

        //先给第一行第一列赋值1
        arr[0][0] = 1;

        //输出
        System.out.println(String.format("%5d",arr[0][0]));
        //每一行第一个都是1，从第二行开始
        for (int i = 1;i < n;i++) {
            arr[i][0] = 1;
            System.out.print(String.format("%5d",arr[i][0]));
            for (int j = 1;j <= i;j++) {
                arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                System.out.print(String.format("%5d",arr[i][j]));
            }
            System.out.println();
        }
    }
}
