package firstStage02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:21:53
 */


/*

题目描述
输入一个整数序列，判断是否是有序序列，有序，指序列中的整数从小到大排序或者从大到小排序。
输入描述:
第一行输入一个整数N(3≤N≤50)。
第二行输入N个整数，用空格分隔N个整数。
输出描述:
输出为一行，如果序列有序输出sorted，否则输出unsorted。


输入：5
     1 6 9 22 30
输出：sorted

输入：5
     3 4 7 2 10
输出：unsorted

 */

    //注：升序降序都是有序输出，两种情况都要考虑，不能只考虑一种
public class Main26 {
        public static void main1(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int n = sc.nextInt();
                int pre = sc.nextInt();
                int flag = 0;
                boolean judge = true;
                for (int i = 1; i < n; i++) {
                    int cur = sc.nextInt();
                    //判断是否全部是升序的
                    if (cur - pre >= 0 && flag>=0){
                        flag = 1;
                     //判断是否全部是降序
                    }else if(cur - pre <= 0 && flag<=0){
                        flag = -1;
                    //不是全部升或者降，将判断标志改为false
                    }else{
                        judge = false;
                    }
                    pre = cur;
                }
                if (judge){
                    System.out.println("sorted");
                }else {
                    System.out.println("unsorted");
                }
            }
        }
    //如果一个数比两边的数都大，或者比两边的数都小，则不是有序的，利用数学单调性的思想
    public static void main3(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] str=br.readLine().split(" ");
        int []a = new int[n];
        for(int i = 0; i < str.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        int flag = 0;
        for(int i=1;i<str.length-1;i++) {
            if((a[i]>a[i-1]&&a[i]>a[i+1])||(a[i]<a[i-1]&&a[i]<a[i+1])) {
                flag = 1;
            }
        }
        if(flag == 1) {
            System.out.println("unsorted");
        }
        else {
            System.out.println("sorted");
        }
    }

}
